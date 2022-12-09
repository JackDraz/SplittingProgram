package jacksplit;

public class MainTimer {
    private long startTime;
    private long currentTime;
    private short currentSplit = -1;
    private short splitAmount;

    public MainTimer(short splitAmount) {
        this.splitAmount = splitAmount;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public static long getStartTime(MainTimer timer){
        return timer.startTime;
    }

    public short getSplitAmount() {
        return splitAmount;
    }

    public void setSplitAmount(short splitAmount) {
        this.splitAmount = splitAmount;
    }

    public short getCurrentSplit() {
        return currentSplit;
    }

    public void setCurrentSplit(short currentSplit) {
        this.currentSplit = currentSplit;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public static long getTimeElapsed(MainTimer timer) {
        return timer.getCurrentTime()- getStartTime(timer);
    }
}

