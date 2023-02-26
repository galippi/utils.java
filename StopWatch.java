package lippiWare.utils;

public class StopWatch {
    long t0;
    long dt = -1;

    public StopWatch()
    {
        start();
    }

    public void start()
    {
        t0 = System.nanoTime();
        dt = -1;
    }

    public void stop()
    {
        dt = System.nanoTime() - t0;
    }

    public long elapsedTime_ns()
    {
        if (dt < 0)
            return System.nanoTime() - t0;
        else
            return dt;
    }

    public long elapsedTime_us()
    {
        return (elapsedTime_ns() + 500) / 1000;
    }

    public int elapsedTime_ms()
    {
        return (int)((elapsedTime_us() + 500) / 1000);
    }

    public double elapsedTime()
    { // in ms
        return elapsedTime_ns() / 1000000.0;
    }
}
