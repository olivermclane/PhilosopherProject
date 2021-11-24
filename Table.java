import java.util.ArrayList;
import java.util.List;

public class Table {
    public static void main(String args[]) throws Exception {
        List<Philospher> philosophers = new ArrayList<Philospher>(5);
        List<Stick> sticks = new ArrayList<Stick>(5);
        //creates all my sticks for the table
        for(int i = 0; i < 5; i++){
            sticks.add(i, new Stick());
        }
        //creates the philospohers and assigns left and right stick
        for(int i = 0; i < 5; i++){
            Stick right = sticks.get(i);
            Stick left = sticks.get((i+1)%sticks.size());

            philosophers.add(i, new Philospher(right, left, i));
            philosophers.get(i).startThread();
        }
    }
}