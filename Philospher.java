
public class Philospher implements Runnable {

    public enum PhilospherStates {
        THINKING(Math.random() * 2000), EATING(Math.random() * 1400);

        public double timeTofinish;

        PhilospherStates(double timeToWait) {
            this.timeTofinish = timeToWait;
        }

    }

    // different sticks for philospher location, this should help us decipher which
    // are avaliable
    private Stick rightStick;
    private Stick leftStick;
    private PhilospherStates state;
    private final Thread philoThread;


    public Philospher(Stick righStick, Stick lefStick, int philoNum) {
        this.leftStick = lefStick;
        this.rightStick = righStick;
        state = PhilospherStates.THINKING;
        philoThread = new Thread(this, "Philosopher: " + philoNum); 

    }

    // using the state of the Philosopher it will decide how long to let the
    // philsopher think or eat
    private void whatyouDoing() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + state.toString());
        Thread.sleep((int) state.timeTofinish);

        // after they finish the current state they will switch to the next
        switch (state) {
        case EATING:
            state = PhilospherStates.THINKING;
            break;
        case THINKING:
            state = PhilospherStates.EATING;
            break;
        }
    }
    public void startThread(){
        philoThread.start();
    }

    @Override
    public void run() {
        try {
            // will continue to loop
            while (true) {
                // should start at thinking
                whatyouDoing();
                // need to check the left fork and right stick too see if they are being used
                synchronized (rightStick) {
                    System.out.println(Thread.currentThread().getName() + ": Right Stick Taken");
                    rightStick.taken();
                    synchronized (leftStick) {
                        System.out.println(Thread.currentThread().getName() + ": Left Stick Taken");
                        leftStick.taken();
                        whatyouDoing();
                    }
                }
                leftStick.avaliable();
                rightStick.avaliable();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

}
