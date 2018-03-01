package HashCode;

import java.util.ArrayList;
import java.util.List;

public class Car
{
    List<Ride> rideList = new ArrayList<>();

    public int getRidesSize() {
        return rideList.size();
    }

    @Override
    public String toString() {
        return "Car{" +
                "rideList=" + rideList +
                '}';
    }
}
