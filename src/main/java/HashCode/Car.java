package HashCode;

public class Car
{
    private int startInsertionX;
    private int startInsertionY;
    private int finishInsertionX;
    private int finishInsertionY;
    private int start;
    private int finish;

    public Car(int a, int b, int x, int y, int s, int f)
    {
        this.startInsertionX = a;
        this.startInsertionY = b;
        this.finishInsertionX = x;
        this.finishInsertionY = y;
        this.start = s;
        this.finish = f;
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


}
