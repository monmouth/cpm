package monmouth.cpm.state;

import java.util.List;

import edu.uci.ics.jung.graph.Graph;
import monmouth.cpm.model.Edge;
import monmouth.cpm.model.Task;
import monmouth.cpm.model.TaskDependency;

public interface StateInterface {
	/**
	 * Create schedule network diagram.
	 * @param tasks tasks
	 * @param dependencies task dependencies
	 */
	void createNetworkDiagram(List<Task> tasks,
			List<TaskDependency> dependencies);

	/**
	 * Do the forward pass computation in the schedule network diagram.
	 */
	void forwardPass();
	
	/**
	 * Do the backward pass computation in the schedule network diagram.
	 */
	void backwardPass();
	
	public interface StateNew {
		StateWithTasks addTasks(List<Task> tasks);
	}
	
	public interface StateWithTasks {
		StateWithTaskDependencies addTaskDependencies(List<TaskDependency> taskDependencies);
		List<Task> getTasks();
		void setTasks(List<Task> tasks);
	}
	
	public interface StateWithTaskDependencies {
		List<Task> getTasks();
		List<TaskDependency> getTaskDependencies();
		void setTaskDependencies(List<TaskDependency> taskDependencies);
		StateReadyToDoForwardPass createNetworkDiagram();
		Graph<Task, Edge> getGraph();
	}
	
	public interface StateReadyToDoForwardPass {
		StateReadyToDoBackwarddPass forwardPass();
		Graph<Task, Edge> getGraph();
	}
	
	public interface StateReadyToDoBackwarddPass {
		void backwardPass();
	}
}
