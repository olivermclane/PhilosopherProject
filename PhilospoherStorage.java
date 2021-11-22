import java.util.List;
import java.util.ArrayList;

public class PhilospoherStorage {
    private final List<Philospher> philoList;

    PhilospoherStorage(){
        philoList = new ArrayList<Philospher>();
    }
    
    public void add(Philospher p) {
        synchronized (philoList){
                philoList.add(p);
                philoList.notify();
        }
    }

    public Philospher get() {
            synchronized (philoList) {
                    while (philoList.size() == 0) {
                            try {
                                    philoList.wait();
                            } catch (InterruptedException ignored) {}
                    }
                return philoList.remove(0);
            }
    }

    public synchronized boolean isEmpty(){
            return philoList.size() == 0;
    }

}
