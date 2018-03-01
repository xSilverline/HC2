package HashCode;

import java.util.ArrayList;

public class Car2
{
    private int startInsertionX;
    private int startInsertionY;
    private int finishInsertionX;
    private int finishInsertionY;
    private int start;
    private int finish;
    private int id;
    private boolean isTaken;
    private int whatRide;
    private int dist;
    private boolean running;
    private int numOfRides = 0;
    private ArrayList<Integer> rides = new ArrayList<>();


    public Car2(int a, int b, int x, int y, int s, int f,int id)
    {
        this.startInsertionX = a;
        this.startInsertionY = b;
        this.finishInsertionX = x;
        this.finishInsertionY = y;
        this.start = s;
        this.finish = f;
        this.id = id;
    }
    void setRunning(int s)
    {
        running = true;
        this.start = s;
        finish = s+dist;
        numOfRides++;
        rides.add(whatRide);

    }
    void setFin(int x, int y)
    {
        this.finishInsertionX=x;
        this.finishInsertionY=y;
    }
    void setWaiting()
    {
        running = false;
    }
    boolean getRunning()
    {
        return running;
    }
    void setRide(int r)
    {
        this.whatRide=r;
    }
    void setDist(int d)
    {
        this.dist=d;
    }
    void setTaken()
    {
        isTaken = true;
    }
    void setFree()
    {
        isTaken = false;
    }
    int getDist()
    {
        return dist;
    }

    int getStart()
    {
        return start;
    }
    int getFinish()
    {
        return finish;
    }

    int getStartInsertionX()
    {
        return startInsertionX;
    }
    int getStartInsertionY()
    {
        return startInsertionY;
    }
    int getFinishInsertionX()
    {
        return finishInsertionX;
    }
    int getFinishInsertionY()
    {
        return finishInsertionY;
    }
    int getId()
    {
        return id;
    }
    boolean getStatus()
    {
        return isTaken;
    }
    int getRide()
    {
        return whatRide;
    }
    String getRides()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.numOfRides + " ");
        for(Integer r: rides)
        {
            sb.append(r + " ");
        }
        return sb.toString();

    }


}
