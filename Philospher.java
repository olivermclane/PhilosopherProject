public class Philospher implements Runnable {

    public enum PhilospherStates {
        THINKING(Math.random() * 2500), EATING(Math.random() * 2000);

        public double timeTofinish;

        /**
         * This will set the states of the philosopher and keep track of the think or
         * eating times.
         * 
         * @param timeToWait will decide how long the philosopher will either THINK or
         *                   EAT
         */
        PhilospherStates(double timeToWait) {
            this.timeTofinish = timeToWait;
        }

    }

    /**
     * different sticks for philospher location, this should help us decipher which
     * are avaliable
     */

    private Stick rightStick;
    private Stick leftStick;
    private PhilospherStates state;
    private final Thread philoThread;
    private boolean thinking;

    /**
     * This is the Philopsoher object and this keeps track of the sticks next to it
     * and which philosopher/thread it is.
     * 
     * @param rightStick a placeholder for the right stick
     * @param leftStick  a placeholder for the left stick
     * @param philoNum   the name for the philosopher
     */
    public Philospher(Stick righStick, Stick lefStick, int philoNum) {
        this.leftStick = lefStick;
        this.rightStick = righStick;
        state = PhilospherStates.THINKING;
        thinking = true;
        philoThread = new Thread(this, "Philosopher: " + philoNum);

    }

    /**
     * This method will print the current state of the philosopher and based on the
     * state will generate times to sleep the thread while they either think or eat
     * 
     * @exception InterruptedException used to manage the sleeping of the thread,
     *                                 will throw if it's distrubed while sleeping
     *                                 waiting or occupied
     * 
     */
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
    /**
     * This will stop the threads from print and doing work
     */
    public void threadStop(){
        thinking = false;
    }

    /**
     * This simply starts the philosopher thread
     */
    public void startThread() {
        philoThread.start();
    }

    /**
     * This method will be used to stop the threads
     * @throws InterruptedException catches interupts
     */
    public void stopThreadWait(){
        try{
            philoThread.join();
            System.out.println(philoThread.getName()+ " is stopping");
        }catch(InterruptedException e){
            System.err.println(philoThread.getName() + " stop malfunction");

        }
    }

    /**
     * This is the runnable for the philsopher and will manage each philsopher based
     * on its state of the sticks around them and the philosopher
     */
    @Override
    public void run() {
        try {
            // will continue to loop
            while (thinking) {
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
                // this was for testing purposes
                leftStick.avaliable();
                rightStick.avaliable();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

}
