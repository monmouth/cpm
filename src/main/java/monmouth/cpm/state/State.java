package monmouth.cpm.state;

import java.util.LinkedList;
import java.util.List;

import edu.uci.ics.jung.graph.Graph;
import monmouth.cpm.model.Edge;
import monmouth.cpm.model.Task;
import monmouth.cpm.model.TaskDependency;
import monmouth.cpm.state.StateInterface.StateNew;
import monmouth.cpm.state.StateInterface.StateReadyToDoBackwarddPass;
import monmouth.cpm.state.StateInterface.StateReadyToDoForwardPass;
import monmouth.cpm.state.StateInterface.StateWithTaskDependencies;
import monmouth.cpm.state.StateInterface.StateWithTasks;

public class State {
	public static class MyStateNew implements StateNew {

		@Override
		public StateWithTasks addTasks(List<Task> tasks) {
			if ((tasks != null && tasks.isEmpty()) | tasks == null)
			    throw new IllegalArgumentException("must have at lease 1 task");
			MyStateWithTasks state = new MyStateWithTasks();
			state.setTasks(tasks);
			return state;
		}

	}
	
	public static class MyStateWithTasks implements StateWithTasks {
        private List<Task> tasks = new LinkedList<>();
		@Override
		public StateWithTaskDependencies addTaskDependencies(List<TaskDependency> taskDependencies) {
			MyStateWithTaskDependencies state = new StateWithTaskDependenciesImpl(this);
			state.setTaskDependencies(taskDependencies);
			return state;
			
		}
		
		@Override
		public List<Task> getTasks() {
			return tasks;
		}

		@Override
		public void setTasks(List<Task> tasks) {
			this.tasks = tasks;
		}
		
	}
	
	public static abstract class MyStateWithTaskDependencies implements StateWithTaskDependencies {
		private StateWithTasks previousState;
		private List<TaskDependency> taskDependencies = new LinkedList<>();
		
		public MyStateWithTaskDependencies(StateWithTasks previousState) {
			this.previousState = previousState;
		}
		
		public List<TaskDependency> getTaskDependencies() {
			return taskDependencies;
		}
		
		public void setTaskDependencies(List<TaskDependency> taskDependencies) {
			this.taskDependencies = taskDependencies;
		}
		
		@Override
		public List<Task> getTasks() {
			return previousState.getTasks();
		}
		
	}
	
	public static abstract class MyStateReadyToDoForwardPass implements
			StateReadyToDoForwardPass {
		private StateWithTaskDependencies previousState;

		public MyStateReadyToDoForwardPass(
				StateWithTaskDependencies previousState) {
			this.previousState = previousState;
		}

		@Override
		public Graph<Task, Edge> getGraph() {
			return previousState.getGraph();
		}

	}
	
	public static class MyStateReadyToDoBackwarddPass implements StateReadyToDoBackwarddPass {

		@Override
		public void backwardPass() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
