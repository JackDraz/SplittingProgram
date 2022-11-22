package jacksplit;

public class MainTimer {
    private long startTime;

    public MainTimer(long startTime) {
        this.startTime = startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public static long getStartTime(MainTimer timer){
        return timer.startTime;
    }

    public static long getTimeElapsed(MainTimer timer) {
        return System.currentTimeMillis() - getStartTime(timer);
    }
}

