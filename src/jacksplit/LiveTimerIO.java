package jacksplit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.lang.String.format;

public abstract class LiveTimerIO implements ActionListener, WindowListener{

    public static void main(String[] args) {
        JFrame f = new JFrame("Draft Window");
        f.setSize(400, 1000);
        f.setVisible(true);
        f.setLayout(null);

        final TextField tf = new TextField();
        tf.setBounds(0, 0, 400, 100);
//        tf.addKeyListener(this);
        f.add(tf);

        JButton b = new JButton("TOUCH HERE");
        b.setBounds(50, 100, 120, 20);
        f.add(b);
        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                tf.setText("You have pressed \"" + e.getKeyChar() +"\"");
                System.out.println(f.getWidth());
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f.dispose();
            }
        });
    }

    public void importSplits(SplitTime[] numSplits, JFrame mainWindow){
        for (SplitTime split : numSplits) {


        }

    }
}