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
            System.out.println("This worked");
            Stick right = sticks.get(i);
            Stick left = sticks.get((i+1)%sticks.size());
            System.out.println(philosophers.size());
            System.out.println();
            if(i == 3) {
                philosophers.add(new Philospher(right, left, i));
            }else{
                philosophers.add(new Philospher(left, right, i));
            }

            philosophers.get(i).startThread();
        }
    }
}