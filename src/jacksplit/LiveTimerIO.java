package jacksplit;
import java.util.*;
import java.io.*;
import java.awt.event.*;

import static jacksplit.MainTimer.getStartTime;
import static jacksplit.MainTimer.getTimeElapsed;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public abstract class LiveTimerIO implements ActionListener, WindowListener {

    public static void main(String[] args) throws InterruptedException {
        //creating split objects
        String configFilePath = "..\\splits.txt";
        ArrayList<SplitTime> splitTimes = new ArrayList<>();
        int totalSplit = importSplits(splitTimes, configFilePath);

//        System.out.println(splitTimes);
//        System.out.println(System.currentTimeMillis());

        MainTimer timer = new MainTimer((short) totalSplit);
        //from this point below, key listener is needed.
        //first split
        startSplit(timer);

        //continuation
        while (timer.getCurrentSplit() < timer.getSplitAmount()) {
            Scanner user = new Scanner(System.in);
            System.out.println(splitTimes.get(timer.getCurrentSplit()));
            System.out.println("enter");
            if (user.next().equals("a")) {
                timer.setCurrentSplit((short) userSplit(timer, splitTimes, timer.getCurrentSplit()));
            }
        }
        System.out.println(splitTimes.get(0).getSplitTime());
        System.out.println(splitTimes.get(0).getBestTime());
    }


    public static void startSplit(MainTimer timer) {
        timer.setStartTime(System.currentTimeMillis());
        timer.setCurrentTime(System.currentTimeMillis());
        timer.setCurrentSplit((short) (timer.getCurrentSplit() + 1));
    }

    public static int userSplit(MainTimer timer, ArrayList<SplitTime> splitTimes, int splitNum) {
        timer.setCurrentTime(System.currentTimeMillis());

        SplitTime currentSplit = splitTimes.get(splitNum);
        double splitLiveTime = ((double) getTimeElapsed(timer)) / 1000;
        currentSplit.setSplitTime(splitLiveTime);

        // gold check
        if (splitLiveTime < currentSplit.getBestTime()) {
            currentSplit.setBestTime(splitLiveTime);
        }

        return splitNum+1;
    }

    public static int importSplits(ArrayList<SplitTime> splitTimes, String fileDir) {
        try {
            FileInputStream propsInput = new FileInputStream(fileDir);
            Properties prop = new Properties();
            prop.load(propsInput);
            int totalSplit = parseInt(prop.getProperty("TOTAL_SPLITS"));
            for (int i = 1; i <= totalSplit; i++) {
                SplitTime split = new SplitTime(prop.getProperty("SPLIT" + i + "_NAME"), parseDouble(prop.getProperty("SPLIT" + i + "_GOLD")));
                splitTimes.add(split);
            }
            return totalSplit;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("sure");
        }
        return -1;
    }
}