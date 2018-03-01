package HashCode;

import java.util.ArrayList;
import java.util.List;

public class Solver {
    List<Solution> solution = new ArrayList<>();


    public void findSolution(List<Ride> rides, int num_of_rides, int vehicles) {
        Solution s = new Solution(vehicles);
        for(Ride r: rides) {
            int min = s.cars.get(0).getRidesSize();
            for(Car c: s.cars) {
                if(c.getRidesSize() < min) min = c.getRidesSize();
            }

            for(Car c: s.cars) {
                if(c.getRidesSize() == min) {
                    c.rideList.add(r);
                    break;
                }
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
                cars.add(new Car());
            }
        }
    }
}
