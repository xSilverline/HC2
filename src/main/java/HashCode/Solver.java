package HashCode;

import java.util.ArrayList;
import java.util.List;

public class Solver {
    List<Solution> solution = new ArrayList<>();
    int max_time;

    public Solver(int max_time) {
        this.max_time = max_time;
    }

    public void findSolution(List<Ride> rides, int num_of_rides, int vehicles) {
        Solution s = new Solution(vehicles);
        for(Ride r: rides) {
            for(Car c: s.cars) {
                if(c.addRide(r)) break;
            }
        }

        for(Car c: s.cars) {
            System.out.println(c);
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
}
