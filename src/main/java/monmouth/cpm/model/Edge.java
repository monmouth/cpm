/**
 * 
 */
package monmouth.cpm.model;

/**
 * @author ken
 * Edge class in the graph data structure.
 */
public class Edge {
	private double capacity = 0.0;
	private Task start;
	private Task end;
	
	public Edge(Task start, Task end) {
		this.start = start;
		this.end = end;
		if (!start.isDummy()) {
			this.capacity = start.getDuration();
		}
	}

	public double getCapacity() {
		return capacity;
	}
	
	@Override
	public String toString() {
		return String.format("Edge(%s->%s)", start.toString(), end.toString());
	}
}
