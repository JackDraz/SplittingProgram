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
    public static void main(String[] args) throws InterruptedException {
        MainTimer maintimer = new MainTimer(System.currentTimeMillis());
        System.out.println(maintimer.startTime);
        Thread.sleep(2000);
        long newTime = getTimeElapsed(maintimer);
        System.out.println(newTime);
    }

}
