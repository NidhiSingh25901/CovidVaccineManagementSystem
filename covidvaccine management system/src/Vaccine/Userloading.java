package Vaccine;

import java.awt.*;
import javax.swing.*;
public class Userloading extends JFrame implements Runnable{
    private JProgressBar progressBar;
    Thread th;
    int s=0;

    public static void main(String[] args){
        Loading l1 = new Loading();
        l1.setVisible(true);
    } 

    public void setUploading(){
        setVisible(true);
        th.start();
    } 

    public void run(){
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
                    new UserOption().setVisible(true);
                }
                Thread.sleep(200);
            }
        } catch (Exception e) {

        }
    } 

    public Userloading() {

      setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setResizable(false);
        th = new Thread((Runnable) this);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/choose2.jpg"));
      Image i2 = i1.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l1 = new JLabel(i3);

        JLabel l2 = new JLabel("Book your slot");
        l2.setForeground(Color.BLACK);
        l2.setBounds(490,140,400,50);
        l2.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        l1.add(l2);

        JLabel l12 = new JLabel("Get Vaccinated fast");
        l12.setForeground(Color.BLACK);
        l12.setBounds(430, 220, 800, 50);
        l12.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        l1.add(l12);

        JLabel l3 = new JLabel("Please Wait . . . .");
        l3.setForeground(Color.BLACK);
      //  l3.setBounds(350, 3800, 400, 50); 
       l3.setBounds(500,500,400,50);
        l3.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        l1.add(l3);

        JLabel l4 = new JLabel("Redirecting to User Panel");
        l4.setForeground(Color.BLACK);
        l4.setBackground(new Color(242, 192, 196));
       // l4.setBounds(290, 290, 400, 50); 
       l4.setBounds(420,560,700,50);
        l4.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        l1.add(l4);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        progressBar.setStringPainted(true);
      //  progressBar.setBounds(260, 340, 300, 25); 
        progressBar.setBounds(420,650,450,30);
        progressBar.setValue(0);
        l1.add(progressBar);
        setUndecorated(true);
        add(l1);
        setUploading();
        

    }


}
