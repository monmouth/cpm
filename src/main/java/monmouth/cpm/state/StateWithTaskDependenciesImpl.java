package monmouth.cpm.state;

import java.util.ArrayList;
import java.util.Hashtable;

import monmouth.cpm.logic.DateCalcIF;
import monmouth.cpm.logic.SimpleDateCalculator;
import monmouth.cpm.model.DummyTask;
import monmouth.cpm.model.Edge;
import monmouth.cpm.model.Task;
import monmouth.cpm.model.TaskDependency;
import monmouth.cpm.state.State.MyStateWithTaskDependencies;
import monmouth.cpm.state.StateInterface.StateReadyToDoForwardPass;
import monmouth.cpm.state.StateInterface.StateWithTasks;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;

public class StateWithTaskDependenciesImpl extends MyStateWithTaskDependencies {

    private Hashtable<Long, Task> tasks = new Hashtable<>();
    private ArrayList<Task> tasksWithPredecessor = new ArrayList<>();
    private ArrayList<Task> tasksWithSuccessor = new ArrayList<>();
    private Task Start = new DummyTask();
    private Task Finish = new DummyTask();
    private Graph<Task, Edge> g = new DirectedSparseGraph<>();
    private DateCalcIF calculator = new SimpleDateCalculator();

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
            g.addEdge(new Edge(0), Start, task);
        }
    }

    private void linkToFinish() {
        for (Task task : this.getTasks()) {
            if (tasksWithSuccessor.contains(task)) {
                continue;
            }
            g.addEdge(new Edge(0), task, Finish);
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
            g.addEdge(
                    new Edge(calculator.getCalendarDays(predecessor.getStart(),
                        successor.getStart())), predecessor, successor);
        }

        return new StateReadyToDoForwardPassImpl(this);
    }

    public Graph<Task, Edge> getGraph() {
        return g;
    }

}
