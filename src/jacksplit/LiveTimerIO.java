package jacksplit;
import java.util.*;
import java.io.*;
import java.awt.event.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public abstract class LiveTimerIO implements ActionListener, WindowListener {

    public static void main(String[] args) {
        ArrayList<SplitTime> splitTimes = new ArrayList<>();
        String configFilePath = "..\\splits.txt";

        importSplits(splitTimes, configFilePath);
        System.out.println(splitTimes);
//        JFrame f = new JFrame("Draft Window");
//        f.setSize(400, 1000);
//        f.setVisible(true);
//        f.setLayout(null);
    }

    public void userSplit(MainTimer timer) {
        
    }

    public static void importSplits(ArrayList<SplitTime> splitTimes, String fileDir) {
        try {
            FileInputStream propsInput = new FileInputStream(fileDir);
            Properties prop = new Properties();
            prop.load(propsInput);
            int totalSplit = parseInt(prop.getProperty("TOTAL_SPLITS"));
            for (int i = 1; i <= totalSplit; i++) {
                SplitTime split = new SplitTime(prop.getProperty("SPLIT" + i + "_NAME"), parseDouble(prop.getProperty("SPLIT" + i + "_GOLD")));
                splitTimes.add(split);
            }
            double test = parseDouble(prop.getProperty("SPLIT1_GOLD"));
            System.out.println(test);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("sure");
        }
    }
}