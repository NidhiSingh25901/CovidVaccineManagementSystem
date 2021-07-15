package Vaccine;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    private JProgressBar progressBar;
    Thread th;
    int s = 0;

    public static void main(String[] args) {
        Loading l1 = new Loading();
        l1.setVisible(true);
    }

    public void setUploading() {
        setVisible(true);
        th.start();
    }

    public void run() {
        try {

            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);

                } else {
                    i = 201;
                    setVisible(false);
                    new Admin_Login().setVisible(true);
                }
                Thread.sleep(200);
            }
        } catch (Exception e) {

        }
    }

    public Loading() {

        // setting frame size
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        th = new Thread((Runnable) this);

        // setting background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/service3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1590, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l1 = new JLabel(i3);

        // slogan line 1
        JLabel l2 = new JLabel("Our Motto");
        l2.setForeground(Color.BLACK);
        l2.setBounds(630, 180, 400, 50);
        l2.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        l1.add(l2);

        // slogan line 2
        JLabel l12 = new JLabel("To make India Covid Free");
        l12.setForeground(Color.BLACK);
        l12.setBounds(510, 250, 700, 50);
        l12.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        l1.add(l12);

        // last second line
        JLabel l3 = new JLabel("Please Wait . . . .");
        l3.setForeground(Color.BLACK);
        l3.setBounds(700, 570, 400, 50);
        l3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        l1.add(l3);

        // last line
        JLabel l4 = new JLabel("Redirecting to Admin Panel");
        l4.setForeground(Color.BLACK);
        l4.setBackground(new Color(242, 192, 196));
        l4.setBounds(650, 620, 400, 50);
        l4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        l1.add(l4);

        // progress bar
        progressBar = new JProgressBar();
        progressBar.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(580, 680, 400, 25);
        progressBar.setValue(0);
        l1.add(progressBar);

        add(l1);
        setUndecorated(true);
        setUploading();

    }
}
