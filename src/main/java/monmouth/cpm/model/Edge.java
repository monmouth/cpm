/**
 * 
 */
package monmouth.cpm.model;

/**
 * @author ken
 * Edge class in the graph data structure.
 */
public class Edge {
	private int capacity;
	
	public Edge(int capacity) {
		this.capacity = capacity;
	}
	
	public String toString() {
		return "EdgeOf";
	}
	/*
    private Task start;
    private Task end;
    private TaskDependency dependency;
    
	public Task getStart() {
		return start;
	}
	public Edge setStart(Task start) {
		this.start = start;
		return this;
	}
	public Task getEnd() {
		return end;
	}
	public Edge setEnd(Task end) {
		this.end = end;
		return this;
	}
	public TaskDependency getDependency() {
		return dependency;
	}
	public Edge setDependency(TaskDependency dependency) {
		this.dependency = dependency;
		return this;
	}
	
	public static Edge create() {
		return new Edge();
	}*/
}
