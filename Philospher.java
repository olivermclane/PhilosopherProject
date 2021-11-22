
public class Philospher implements Runnable{
    
    public enum PhilospherStates{
        THINKING(120), 
        HUNGRY(50), 
        EATING(Math.random()* 100);
    
    public double timeTofinish;
    
    PhilospherStates(double timeToWait){
         this.timeTofinish = timeToWait;
    }
    
    }

    //different sticks for philospher location, this shoudl help us decipher which are avaliable
    private Stick rightStick;
    private Stick leftStick;
    private PhilospherStates state;

    public Philospher(Stick left, Stick right){
        this.leftStick = left;
        this.rightStick = right;
        state = PhilospherStates.THINKING;
    }

    //takes a string for an action and computes what to do and waits the thread 
    private void doYourAction() throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + " " +state.toString());
        Thread.sleep((int) state.timeTofinish);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
    
}
