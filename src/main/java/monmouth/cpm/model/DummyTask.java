/**
 * 
 */
package monmouth.cpm.model;

/**
 * @author ken
 * Virtual Task used as the Start or End task in whole project.
 */
public class DummyTask extends Task {
	@Override
	public boolean isDummy() {
		return true;
	}
}
