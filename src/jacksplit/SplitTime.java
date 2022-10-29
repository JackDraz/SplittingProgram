package jacksplit;

import java.awt.*;

public class SplitTime {
    private TextField textField = new TextField();
    private String splitName;
    private double splitTime;

    public SplitTime (TextField textField, String splitName, double splitTime) {
        this.splitName = splitName;
        this.textField = textField;
        this.splitTime = splitTime;
    }
}
