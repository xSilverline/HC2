package HashCode;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Solver {
    Solution s;
    int max_time;
    int vehicles;

    public Solver(int max_time, int vehicles) {
        this.max_time = max_time;
        this.vehicles = vehicles;
        s = new Solution(vehicles);
    }

    public void findSolution(List<Ride> rides, int num_of_rides) {
        for(Ride r: rides) {
            for(Car c: s.cars) {
                if(c.addRide(r)) break;
            }
        }
    }



    class Solution {
        List<Car> cars = new ArrayList<>();

        Solution(int vehicles) {
            for(int i = 0; i < vehicles; i++) {
                cars.add(new Car(max_time));
            }
        }
    }

    public void saveSolution() {
        try {
            PrintWriter out = new PrintWriter("out.txt");
            for(Car c: s.cars) {
                System.out.println(c.getRides());
                out.println(c.getRides());
            }
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
