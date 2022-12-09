package jacksplit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements KeyListener {
    private JFrame window;
    private JPanel panel;
    private JLabel textLabel;
    private Font font = new Font("Arial", Font.PLAIN, 12);

    public GUI() {
        window = new JFrame();
        window.setSize(200,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.white);
        window.setLayout(null);
        window.addKeyListener(this);

        panel = new JPanel();
        panel.setBounds(0, 0, 200, 100);
        panel.setBackground(Color.black);
        panel.setLayout(new GridLayout(2, 1));
        window.add(panel);

        textLabel = new JLabel("Yo!");
        textLabel.setBackground(Color.black);
        textLabel.setForeground(Color.white);
        textLabel.setFont(font);
        panel.add(textLabel);
//        window.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        textLabel.setText("You pressed " + e.getKeyCode());
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
