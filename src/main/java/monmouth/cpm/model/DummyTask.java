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
		return getTitle();
	}
	
	@Override
	public boolean isDummy() {
		return true;
	}
	
	public DummyTask(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
