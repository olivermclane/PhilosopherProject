/**
 * This is the stick class and allows you to create a stick object. This will be
 * able to keep track of the sticks state.
 */
public class Stick {

    public enum stickState {
        AVAILABLE, TAKEN;

        /**
         * This is for testing purposes and was used to test certian functions in early
         * stages.
         */
        stickState() {
        }
    }

    // instance of the sticks state
    public stickState state;

    /**
     * This is a stick object and when created the stick is set to AVALIABLE
     */
    Stick() {
        state = stickState.AVAILABLE;
    }

    /**
     * This will set the sticks state to AVALIABLE
     */
    public void avaliable() {
        state = stickState.AVAILABLE;
    }

    /**
     * This will set the sticks state to TAKEN
     */
    public void taken() {
        state = stickState.TAKEN;
    }

    /**
     * this function will convert the current state of the stick to a string and
     * then return it
     * 
     * @return the state of the stick as a string
     */
    public String avaliablity() {
        return state.toString();
    }

}
