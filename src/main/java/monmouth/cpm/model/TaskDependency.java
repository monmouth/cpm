package monmouth.cpm.model;

public class TaskDependency {
	/**
	 * Finish-Start relation.
	 */
	public static final int FS = 0;
	/**
	 * Finish-Finish relation.
	 */
	public static final int FF = 1;
	/**
	 * Start-Start relation.
	 */
	public static final int SS = 2;
	/**
	 * Start-Finish relation.
	 */
	public static final int SF = 3;
	
	private long predecessorId;
	private long successorId;
	private int type;
	private int lag;
	
	public TaskDependency(long predecessorId, long successorId, int type, int lag) {
		this.predecessorId = predecessorId;
		this.successorId = successorId;
		this.type = type;
		this.lag = lag;
	}

	public long getPredecessorId() {
		return predecessorId;
	}

	public void setPredecessorId(long predecessorId) {
		this.predecessorId = predecessorId;
	}

	public long getSuccessorId() {
		return successorId;
	}

	public void setSuccessorId(long successorId) {
		this.successorId = successorId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getLag() {
		return lag;
	}

	public void setLag(int lag) {
		this.lag = lag;
	}

	@Override
	public String toString() {
		return String.format("dep(%s-%s)", predecessorId, successorId);
	}
}
