/**
 * 
 */
package monmouth.cpm.model;

/**
 * @author ken
 * Virtual Task used as the Start or End task in whole project.
 */
public class DummyTask extends Task {
	private String title;
	
	@Override
	public String toString() {
		switch(new Long(getId()).intValue()) {
		case Task.START_TASK_ID:
			return "Start";
		case Task.FINISH_TASK_ID:
			return "Finish";
		default: 
			return "";	
		}
	}
	
	@Override
	public boolean isDummy() {
		return true;
	}
	
	private DummyTask(int id, int duration) {
		super(id, duration);
	}
	
	public static DummyTask createStart() {
		return new DummyTask(Integer.MIN_VALUE, 0);
	}
	
	public static DummyTask createFinish() {
		return new DummyTask(Integer.MAX_VALUE, 0);
	}
}
