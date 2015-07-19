/**
 * 
 */
package monmouth.cpm.state;

import monmouth.cpm.state.State.MyStateReadyToDoBackwarddPass;
import monmouth.cpm.state.State.MyStateReadyToDoForwardPass;
import monmouth.cpm.state.StateInterface.StateReadyToDoBackwarddPass;
import monmouth.cpm.state.StateInterface.StateWithTaskDependencies;

/**
 * @author ken
 * Implement forward-pass computation logic in this concrete class.
 */
public class StateReadyToDoForwardPassImpl extends MyStateReadyToDoForwardPass {
	//Transformer<Edge, Integer> transformer = new Transformer<Edge, Integer>();
	
	public StateReadyToDoForwardPassImpl(StateWithTaskDependencies previousState) {
		super(previousState);
	}
	
	@Override
	public StateReadyToDoBackwarddPass forwardPass() {
		return new MyStateReadyToDoBackwarddPass();
	}
}
