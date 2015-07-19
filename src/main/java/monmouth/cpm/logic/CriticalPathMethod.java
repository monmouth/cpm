package monmouth.cpm.logic;

import monmouth.cpm.state.State.MyStateNew;

public class CriticalPathMethod {
	/**
	 * Default constructor.
	 */
	private CriticalPathMethod() {
		
	}
	
	/**
	 * A static method to create a new instance.
	 * @return a new CriticalPathMethod instance
	 */
	public static final CriticalPathMethod getInstance() {
		return new CriticalPathMethod();
	}
	
	public MyStateNew create() {
		return new MyStateNew();
	}
}
