package HashCode;

import java.util.ArrayList;
import java.util.List;

public class Car
{
    List<Ride> rideList = new ArrayList<>();
    boolean timetable[];
    static int counter = 0;
    int id;

    public Car(int max_time) {
        id = counter;
        counter++;
        timetable = new boolean[max_time];
        for(int i = 0; i < max_time; i++) {
            timetable[i] = false;
        }
    }

    public int getRidesSize() {
        return rideList.size();
    }

    @Override
    public String toString() {
        return "Car{" +
                "rideList=" + rideList +
                '}';
    }

    public boolean addRide(Ride r) {
        if(!checkIfAvailable(r)) return false;

        for(int i = r.start; i <= r.end; i++) {
            timetable[i] = true;
        }

        rideList.add(r);
        return true;
    }

    private boolean checkIfAvailable(Ride r) {
        for(int i = r.start; i <= r.end; i++) {
            if(timetable[i] == true) return false;
        }

        return true;
    }

    public String getRides() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id + " ");
        for(Ride r: rideList) {
            sb.append(r.id + " ");
        }
        return sb.toString();
    }
}
