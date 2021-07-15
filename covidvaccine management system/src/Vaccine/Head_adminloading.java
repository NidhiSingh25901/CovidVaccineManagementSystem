package Vaccine;


import javax.swing.*; 
import java.awt.*;
public class Head_adminloading extends JFrame implements Runnable {

    private JProgressBar progressBar;
    Thread th;
    int s = 0;
    public static void main(String[] args) {
          new Head_adminloading().setVisible(true);
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
                    new Head_Login().setVisible(true);
                }
                Thread.sleep(200);
            }
        } catch (Exception e) {

        }
    }

    public Head_adminloading() {

       
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setResizable(false);
        th = new Thread((Runnable) this);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/head-loading.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel l1 = new JLabel(i3);

        JLabel l2 = new JLabel("Our Motto");
        l2.setForeground(Color.BLACK);
        l2.setBounds(540, 140, 400, 50);
        l2.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        l1.add(l2);

        JLabel l12 = new JLabel("WIN AGAINST COVID-19");
        l12.setForeground(Color.BLACK);
        l12.setBounds(450, 190, 800, 50);
        l12.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        l1.add(l12);

        JLabel l3 = new JLabel("Please Wait . . . .");
        l3.setForeground(Color.BLACK);
        l3.setBounds(525, 440, 400, 50);
        l3.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        l1.add(l3);

        JLabel l4 = new JLabel("Opening administration panel");
        l4.setForeground(Color.BLACK);
        l4.setBackground(new Color(242, 192, 196));
        l4.setBounds(460, 490, 700, 50);
        l4.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        l1.add(l4);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(440, 550, 430, 30);
        progressBar.setValue(0);
        l1.add(progressBar);

        add(l1);
        setUndecorated(true);
        setUploading();

    }
}
