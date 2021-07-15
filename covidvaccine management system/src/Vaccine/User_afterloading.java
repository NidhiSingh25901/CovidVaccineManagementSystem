package Vaccine;

import java.awt.*;
// import java.sql.PreparedStatement;

import javax.swing.*;

// import com.mysql.cj.xdevapi.PreparableStatement;

public class User_afterloading extends JFrame implements Runnable {

    private JProgressBar progressBar;
    Thread th;
    int s = 0;
    String username;
    String aadharvalue;

    public static void main(String[] args) {
        new User_afterloading("", "").setVisible(true);
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

                    new Userdashboard(username, aadharvalue).setVisible(true);

                }
                Thread.sleep(200);
            }
        } catch (Exception e) {

        }
    }

    public User_afterloading(String username, String aadharvalue) {

        this.aadharvalue = aadharvalue;
        this.username = username;

        // frame size and styling
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        th = new Thread((Runnable) this);

        // setting background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/userafterloading.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l1 = new JLabel(i3);

        // slogan line 1
        JLabel l2 = new JLabel("Welcome to your dashboard");
        l2.setForeground(Color.BLACK);
        l2.setBounds(390, 150, 600, 50);
        l2.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        l1.add(l2);

        // alogan line 2
        JLabel l12 = new JLabel(username);
        l12.setForeground(Color.BLACK);
        l12.setBounds(550, 230, 800, 50);
        l12.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        l1.add(l12);

        // last second line
        JLabel l3 = new JLabel("Please Wait . . . .");
        l3.setForeground(Color.BLACK);
        l3.setBounds(510, 450, 400, 50);
        l3.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        l1.add(l3);

        // last line
        JLabel l4 = new JLabel("To book your slot");
        l4.setForeground(Color.BLACK);
        l4.setBounds(490, 510, 400, 50);
        l4.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        l1.add(l4);

        // progress bar
        progressBar = new JProgressBar();
        progressBar.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(440, 580, 400, 30);
        progressBar.setValue(0);
        l1.add(progressBar);

        setUndecorated(true);
        add(l1);
        setUploading();
    }
}
