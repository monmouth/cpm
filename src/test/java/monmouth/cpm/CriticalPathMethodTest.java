package monmouth.cpm;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import monmouth.cpm.logic.CriticalPathMethod;
import monmouth.cpm.model.Task;
import monmouth.cpm.model.TaskDependency;
import monmouth.cpm.state.StateInterface.StateReadyToDoForwardPass;
import monmouth.cpm.state.StateInterface.StateWithTaskDependencies;

import org.junit.Before;
import org.junit.Test;

public class CriticalPathMethodTest {
	CriticalPathMethod instance = null;
	/*
	 * Dependency: 
	 * T1
	 *  |_T2
	 *  |_T3
	 *     |_T4
	 * T5
	 *  |_T6
	 *     |_T7
	 * T8 
	 */
	Task task1 = new Task(1, createDate(2015, 7, 15), createDate(2015, 7, 16));
	Task task2 = new Task(2, createDate(2015, 7, 17), createDate(2015, 7, 18));
	Task task3 = new Task(3, createDate(2015, 7, 19), createDate(2015, 7, 21));
	Task task4 = new Task(4, createDate(2015, 7, 22), createDate(2015, 7, 25));
	Task task5 = new Task(5, createDate(2015, 7, 15), createDate(2015, 7, 18));
	Task task6 = new Task(6, createDate(2015, 7, 19), createDate(2015, 7, 24));
	Task task7 = new Task(7, createDate(2015, 7, 18), createDate(2015, 7, 21));
	Task task8 = new Task(8, createDate(2015, 7, 22), createDate(2015, 7, 31));
	List<Task> allTasks = Arrays.asList(task1, task2, task3, task4, task5, task6, task7, task8);
	
	TaskDependency dep1 = new TaskDependency(1, 2, TaskDependency.FS, 0);
	TaskDependency dep2 = new TaskDependency(1, 3, TaskDependency.FS, 0);
	TaskDependency dep3 = new TaskDependency(3, 4, TaskDependency.FS, 0);
	TaskDependency dep4 = new TaskDependency(5, 6, TaskDependency.FS, 0);
	TaskDependency dep5 = new TaskDependency(6, 7, TaskDependency.FS, 0);
	List<TaskDependency> dependencies = Arrays.asList(dep1, dep2, dep3, dep4, dep5);
	
	@Before
	public void setUp() throws Exception {
		instance = CriticalPathMethod.getInstance();
	}

	@Test(expected = RuntimeException.class)
	public void testNullTasks() {
		instance.create().addTasks(null/*Arrays.asList(task)*/);
	}
	
	@Test(expected = RuntimeException.class)
	public void testEmptyTasks() {
		List<Task> tasks = new LinkedList<>();
		instance.create().addTasks(tasks);
	}
	
	@Test
	public void testWithTasks() {
		instance.create().addTasks(Arrays.asList(task1, task2));
	}
	
	@Test
	public void testStateWithTaskDependencyMustHaveTasks() {
		StateWithTaskDependencies state = instance
				.create()
				.addTasks(
						Arrays.asList(task1))
				.addTaskDependencies(null);
		assertNotNull(state);
		assertFalse(state.getTasks().isEmpty());
	}
	
	@Test
	public void testStateWithTaskDependencyMustHaveDependencies() {
		StateWithTaskDependencies state = instance
				.create()
				.addTasks(
						Arrays.asList(task1))
				.addTaskDependencies(dependencies);
		assertNotNull(state);
		assertFalse(state.getTaskDependencies().isEmpty());
		assertEquals(dependencies.size(), state.getTaskDependencies().size());
	}
	
	@Test
	public void testMyStateReadyToDoForwardPassMustHaveGraph() {
		StateReadyToDoForwardPass state = instance.create().addTasks(allTasks)
				.addTaskDependencies(dependencies).createNetworkDiagram();
		assertNotNull(state.getGraph());
		assertTrue(state.getGraph().getVertexCount() > 0);
		assertTrue(state.getGraph().getEdgeCount() > 0);
	}
	
	@Test
	public void testCreateGrpah() {
		instance.create().addTasks(allTasks).addTaskDependencies(dependencies).createNetworkDiagram();
	}
	
	private Date createDate(int year, int monthOfYear, int date) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, monthOfYear - 1);
		cal.set(Calendar.DATE, date);
		return cal.getTime();
	}
	
}
