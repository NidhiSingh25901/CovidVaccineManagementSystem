package Vaccine;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class User_helpline extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new User_helpline().setVisible(true);
    }

    JButton okbutton;

    public User_helpline() {

        // setting frame size and styling
        setBounds(500, 150, 760, 600);
        setResizable(false);
        setUndecorated(true);
        setBackground(new Color(34, 54, 86, 250));
        setLayout(null);

        // title
        JLabel helplinehead = new JLabel("<html><u>HELPLINE</u></html>");
        helplinehead.setBounds(270, 70, 550, 30);
        helplinehead.setForeground(Color.white);
        helplinehead.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(helplinehead);

        // iamge
        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/User_phone.jpg"));
        Image imgicon = imageicon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon setimgicon = new ImageIcon(imgicon);
        JLabel headicon = new JLabel(setimgicon);
        headicon.setBounds(130, 170, 40, 40);
        add(headicon);

        // number title
        JLabel phnnumberhead = new JLabel("Number :");
        phnnumberhead.setForeground(Color.white);
        phnnumberhead.setBounds(220, 160, 500, 30);
        phnnumberhead.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(phnnumberhead);

        // number title view
        JLabel phnnumber = new JLabel("91-11-23978046");
        phnnumber.setForeground(Color.white);
        phnnumber.setBounds(220, 185, 500, 30);
        phnnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(phnnumber);

        // image
        ImageIcon imagehealthicon = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/User_health.jpg"));
        Image imghealthicon = imagehealthicon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon setimghealthicon = new ImageIcon(imghealthicon);
        JLabel headhealthicon = new JLabel(setimghealthicon);
        headhealthicon.setBounds(540, 250, 40, 40);
        add(headhealthicon);

        // health ministry title
        JLabel healthministry = new JLabel("Health Ministry:");
        healthministry.setForeground(Color.white);
        healthministry.setBounds(370, 240, 500, 30);
        healthministry.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(healthministry);

        // health minstry title view
        JLabel ministrynumber = new JLabel("1075");
        ministrynumber.setForeground(Color.white);
        ministrynumber.setBounds(370, 265, 500, 30);
        ministrynumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(ministrynumber);

        // iamge
        ImageIcon imagechildicon = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/User_child.jpg"));
        Image imgchildicon = imagechildicon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon setimgchildicon = new ImageIcon(imgchildicon);
        JLabel headchildicon = new JLabel(setimgchildicon);
        headchildicon.setBounds(130, 310, 40, 40);
        add(headchildicon);

        // child title
        JLabel child = new JLabel("Child :");
        child.setForeground(Color.white);
        child.setBounds(220, 310, 500, 30);
        child.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(child);

        // child helpline number title
        JLabel childnumber = new JLabel("1098");
        childnumber.setForeground(Color.white);
        childnumber.setBounds(220, 330, 500, 30);
        childnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(childnumber);

        // image
        ImageIcon imagesenioricon = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/User_senior.jpg"));
        Image imgsenioricon = imagesenioricon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon setimgsenioricon = new ImageIcon(imgsenioricon);
        JLabel headsenioricon = new JLabel(setimgsenioricon);
        headsenioricon.setBounds(540, 380, 40, 40);
        add(headsenioricon);

        // senior title
        JLabel senior = new JLabel("Senior :");
        senior.setForeground(Color.white);
        senior.setBounds(370, 380, 500, 30);
        senior.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(senior);

        // senior title view
        JLabel seniornumber = new JLabel("14567");
        seniornumber.setForeground(Color.white);
        seniornumber.setBounds(370, 405, 500, 30);
        seniornumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(seniornumber);

        // ok button
        okbutton = new JButton("OK");
        okbutton.setBounds(300, 500, 70, 26);
        okbutton.setBackground(Color.blue);
        okbutton.setForeground(Color.white);
        okbutton.addActionListener(this);
        add(okbutton);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okbutton) {
            this.setVisible(false);

        }
    }

}
