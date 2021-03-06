package monmouth.cpm.state;

import java.util.ArrayList;
import java.util.Hashtable;
import monmouth.cpm.model.DummyTask;
import monmouth.cpm.model.Edge;
import monmouth.cpm.model.NetworkDiagram;
import monmouth.cpm.model.Task;
import monmouth.cpm.model.TaskDependency;
import monmouth.cpm.state.State.MyStateWithTaskDependencies;
import monmouth.cpm.state.StateInterface.StateReadyToDoForwardPass;
import monmouth.cpm.state.StateInterface.StateWithTasks;
import edu.uci.ics.jung.graph.DirectedGraph;

public class StateWithTaskDependenciesImpl extends MyStateWithTaskDependencies {

    private Hashtable<Long, Task> tasks = new Hashtable<>();
    private ArrayList<Task> tasksWithPredecessor = new ArrayList<>();
    private ArrayList<Task> tasksWithSuccessor = new ArrayList<>();
    private Task Start = DummyTask.createStart();
    private Task Finish = DummyTask.createFinish();
    private DirectedGraph<Task, Edge> g = new NetworkDiagram<>();

    public StateWithTaskDependenciesImpl(StateWithTasks previousState) {
        super(previousState);
        init();
    }

    private void init() {
        setTasks();
    }

    private void setTasks() {
        for (Task task : this.getTasks()) {
            tasks.put(task.getId(), task);
        }
    }

    private void linkToStart() {
        for (Task task : this.getTasks()) {
            if (tasksWithPredecessor.contains(task)) {
                continue;
            }
            g.addEdge(new Edge(Start, task), Start, task);
        }
    }

    private void linkToFinish() {
        for (Task task : this.getTasks()) {
            if (tasksWithSuccessor.contains(task)) {
                continue;
            }
            g.addEdge(new Edge(task, Finish), task, Finish);
        }
    }

    private void categorizeTasks() {
        for (TaskDependency dependency : getTaskDependencies()) {
            tasksWithPredecessor.add(tasks.get(dependency.getSuccessorId()));
            tasksWithSuccessor.add(tasks.get(dependency.getPredecessorId()));
        }
    }

    @Override
	public StateReadyToDoForwardPass createNetworkDiagram() {
		Task predecessor;
		Task successor;

		categorizeTasks();
		linkToStart();
		linkToFinish();

		for (TaskDependency dependency : this.getTaskDependencies()) {
			predecessor = tasks.get(dependency.getPredecessorId());
			successor = tasks.get(dependency.getSuccessorId());
			g.addEdge(new Edge(predecessor, successor), predecessor, successor);
		}
        /*
		Transformer<Edge, Number> myTransformer = new Transformer<Edge, Number>() {
			public Double transform(Edge edge) {
				return edge.getCapacity();
			}
		};

		Map<Edge, Number> edgeFlowMap = new HashMap<>();
		Factory<Edge> edgeFactory = new Factory<Edge>() {
			public Edge create() {
				return new Edge(new DummyTask("s"), new DummyTask("e"));
			}
		};

		EdmondsKarpMaxFlow<Task, Edge> alg = new EdmondsKarpMaxFlow<Task, Edge>(g, Start,
				Finish, myTransformer, edgeFlowMap, edgeFactory);
		alg.evaluate();
		System.out.println("the max flow is: " + alg.getMaxFlow());
		System.out.println("the edge set is: " + alg.getMinCutEdges().toString());
        */
		return new StateReadyToDoForwardPassImpl(this);
	}

    public DirectedGraph<Task, Edge> getGraph() {
        return g;
    }

}
