public class Philospher implements Runnable{
    
    public enum PhilospherStates{
        THINKING(120), 
        HUNGRY(50), 
        EATING(110);
    
    public int timeTofinish;
    
    PhilospherStates(int timeToWait){
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
    private void doYourAction(){
        System.out.println()
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
    
}
