package HashCode;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Solv2
{
    private ArrayList<Car2> cars = new ArrayList<>();
    private ArrayList<Ride> rides = new ArrayList<>();
    private int numberOfCars;
    private int minimalDistance;
    private int whoIsMinimal;
    private int steps;
    private int tick;


    Solv2(int cars, ArrayList<Ride> rides, int steps)
    {
        this.numberOfCars = cars;
        this.rides = rides;
        this.steps = steps;

        createCars();
        runTicks();
        saveSolution();
    }

    private void createCars()
    {
        for (int i = 0; i < numberOfCars; i++)
        {
            Car2 c = new Car2(0, 0, 0, 0, 0, 0, i);
            c.setFree();
            cars.add(c);
        }
    }

    private void checkWhoIsClose()
    {
        minimalDistance = 100000000;
        for (int i = 0; i < rides.size(); i++)
        {
            if (tick >= rides.get(i).start)
                checkForRide(i);
        }
    }

    private void checkForRide(int i)
    {
        int distX;
        int distY;
        for (Car2 x : cars)
        {
            distX = abs(rides.get(i).start_x - x.getStartInsertionX());
            distY = abs(rides.get(i).start_y - x.getStartInsertionY());
            int sum = distX + distY;
            if (sum < minimalDistance)
            {
                if (!x.getStatus())
                {
                    minimalDistance = sum;
                    whoIsMinimal = x.getId();
                    x.setTaken();
                    x.setRide(rides.get(i).id);
                    x.setDist(sum);
                } else if (!x.getRunning())
                {
                    if (sum > x.getDist())
                    {
                        int temp = x.getRide();
                        x.setRide(rides.get(i).id);
                        x.setDist(sum);
                        checkForRide(temp);
                    }
                }
            }
        }
    }

    private void runTicks()
    {
        checkWhoIsClose();

        for (tick = 0; tick < steps; tick++)
        {
            for (Car2 x : cars)
            {
                if (x.getStatus() && x.getRunning() && x.getFinish() >= tick)
                {
                    x.setWaiting();
                    x.setFree();
                    x.setFin(rides.get(x.getRide()).end_x, rides.get(x.getRide()).end_y);
                    rides.remove(x.getRide());
                }
            }

            checkWhoIsClose();
            for (Car2 x : cars)
            {
                if (x.getStatus() && !x.getRunning())
                {
                    x.setRunning(tick);

                }
            }
        }

    }

    public void saveSolution()
    {
        try
        {
            PrintWriter out = new PrintWriter("out.txt");
            for (Car2 c : cars)
            {
                System.out.println(c.getRides());
                out.println(c.getRides());
            }
            out.flush();
            out.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }


    }
}
