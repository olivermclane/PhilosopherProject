public class Stick {

    public enum stickState {
        AVAILABLE, TAKEN;

        stickState() {
        }
    }

    public stickState state;

    Stick() {
        state = stickState.AVAILABLE;
    }

    public void avaliable() {
        state = stickState.AVAILABLE;
    }

    public void taken() {
        state = stickState.TAKEN;
    }

    public String avaliablity() {
        return state.toString();
    }

}
