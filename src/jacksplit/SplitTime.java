package jacksplit;

public class SplitTime {
    private String splitName;
    private double splitTime;
    private double bestTime;

    public SplitTime (String splitName, double bestTime) {
        this.splitName = splitName;
        this.bestTime = bestTime;
    }

    @Override
    public String toString() {
        return splitName + "," + bestTime;
    }

    public java.lang.String getSplitName() {
        return splitName;
    }

    public void setSplitName(java.lang.String splitName) {
        this.splitName = splitName;
    }

    public double getSplitTime() {
        return splitTime;
    }

    public void setSplitTime(double splitTime) {
        this.splitTime = splitTime;
    }

    public double getBestTime() {
        return bestTime;
    }

    public void setBestTime(double bestTime) {
        this.bestTime = bestTime;
    }
}