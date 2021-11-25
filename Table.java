import java.util.ArrayList;
import java.util.List;

/**
 * This will in essence be the creation of the table.
 */
public class Table {
    /**
     * This run everything this starts the philosophers and creates the sticks and
     * assigns them.
     * 
     * @param args passed through arguments
     * @throws Exception will catch any exception, but all exception should be
     *                   handled
     */
    public static void main(String args[]) throws Exception {
        List<Philospher> philosophers = new ArrayList<Philospher>(5);
        List<Stick> sticks = new ArrayList<Stick>(5);

        // creates all my sticks for the table
        for (int i = 0; i < 5; i++) {
            sticks.add(i, new Stick());
        }

        // creates the philospohers and assigns left and right stick
        for (int i = 0; i < 5; i++) {
            Stick right = sticks.get(i);
            Stick left = sticks.get((i + 1) % sticks.size());
            // current problem talked about 5 philo so at the 4 index in the arraylist
            // switch the philosopher right for left stick to avoid deadlock
            if (i == 3) {
                philosophers.add(new Philospher(right, left, i));
            } else {
                philosophers.add(new Philospher(left, right, i));
            }

            philosophers.get(i).startThread();
        }
    }
}