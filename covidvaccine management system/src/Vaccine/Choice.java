package Vaccine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Choice {
    public static void main(String[] args) {

        // calling constructor
        ChoiceLogin choice = new ChoiceLogin();

        // setting the object of the constructor to be visible
        choice.setVisible(true);
    }

    public void setVisible(boolean b) {
    }
}

class ChoiceLogin extends JFrame implements ActionListener {

    private JPanel panel;

    private JButton adminbutton, loginbutton, administratorbutton, exitbutton;

    ChoiceLogin() {

        // setting the size of the frame
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Log In As - Vaccine");

        // setting the panel
        panel = new JPanel();
        panel.setBackground(new Color(27, 193, 222));
        setContentPane(panel);
        panel.setLayout(null);

        // login as heading
        JLabel choicehead = new JLabel("<html><strong><u><bold><b1>Log In As</u></bold></strong></html>");
        choicehead.setBounds(1100, 130, 200, 80);
        choicehead.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        panel.add(choicehead);

        // slogan
        JLabel slogan1 = new JLabel("Please Don't Wait !!!");
        slogan1.setBounds(300, 330, 2000, 80);
        slogan1.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
        slogan1.setForeground(Color.white);
        panel.add(slogan1);

        // slogan
        JLabel slogan2 = new JLabel("Get Vaccinated !!!");
        slogan2.setBounds(300, 400, 2000, 80);
        slogan2.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        slogan2.setForeground(Color.white);
        panel.add(slogan2);

        // setting the three image at the left hand side corner
        ImageIcon imgone = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/userdashbackground.jpg"));
        Image setimgone = imgone.getImage().getScaledInstance(190, 333, Image.SCALE_FAST);
        ImageIcon setimgfinal = new ImageIcon(setimgone);
        JLabel lableimg1 = new JLabel(setimgfinal);

        lableimg1.setPreferredSize(new Dimension(800, 100));
        lableimg1.setLocation(0, 0);
        lableimg1.setSize(160, 289);
        lableimg1.setBackground(new Color(100, 20, 70));
        add(lableimg1);

        ImageIcon img2 = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/choice2.jpg"));
        Image setimg2 = img2.getImage().getScaledInstance(190, 333, Image.SCALE_FAST);
        ImageIcon setimg2final = new ImageIcon(setimg2);

        JLabel labelimg2 = new JLabel(setimg2final);
        labelimg2.setPreferredSize(new Dimension(800, 100));
        labelimg2.setLocation(0, 290);
        labelimg2.setSize(160, 263);
        labelimg2.setBackground(new Color(100, 20, 70));
        add(labelimg2);

        ImageIcon img3 = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/adminmain.jpg"));
        Image setimg3 = img3.getImage().getScaledInstance(190, 343, Image.SCALE_FAST);
        ImageIcon setimg3final = new ImageIcon(setimg3);

        JLabel labelimg3 = new JLabel(setimg3final);
        labelimg3.setPreferredSize(new Dimension(800, 110));
        labelimg3.setLocation(0, 550);
        labelimg3.setSize(160, 295);
        labelimg3.setBackground(new Color(100, 20, 70));
        add(labelimg3);

        // admin button at the right hand side
        adminbutton = new JButton("Admin");
        adminbutton.addActionListener(this);
        adminbutton.setForeground(new Color(46, 139, 87));
        adminbutton.setBackground(new Color(176, 224, 230));
        adminbutton.setFont(new Font("Verdana", Font.BOLD, 14));
        adminbutton.setBounds(1110, 300, 156, 50);
        panel.add(adminbutton);

        // hover effect in the button
        adminbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adminbutton.setBackground(new Color(55, 114, 88));
                adminbutton.setForeground(Color.WHITE);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                adminbutton.setForeground(new Color(46, 139, 87));
                adminbutton.setBackground(new Color(176, 224, 230));
            }
        });

        // login button
        loginbutton = new JButton("User");
        loginbutton.setForeground(new Color(139, 69, 19));
        loginbutton.setBackground(new Color(255, 235, 205));
        loginbutton.setBounds(1110, 370, 156, 50);

        loginbutton.setFont(new Font("Verdana", Font.BOLD, 14));
        loginbutton.addActionListener(this);
        panel.add(loginbutton);

        // hover effect in the login button
        loginbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginbutton.setBackground(new Color(82, 20, 20));

                loginbutton.setForeground(Color.WHITE);

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {

                loginbutton.setForeground(new Color(139, 69, 19));
                loginbutton.setBackground(new Color(255, 235, 205));
            }
        });

        administratorbutton = new JButton("Admistrator");
        administratorbutton.setBounds(1110, 450, 156, 50);
        administratorbutton.setBackground(new Color(50, 57, 64));
        administratorbutton.setForeground(Color.white);
        administratorbutton.setFont(new Font("Verdana", Font.BOLD, 10));
        administratorbutton.addActionListener(this);
        panel.add(administratorbutton);

        // hover effect in the login button
        administratorbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                administratorbutton.setBackground(new Color(15, 62, 46));

                administratorbutton.setForeground(Color.WHITE);

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {

                administratorbutton.setForeground(Color.white);
                administratorbutton.setBackground(new Color(50, 57, 64));
            }
        });

        exitbutton = new JButton("EXIT");
        exitbutton.setBounds(1110, 530, 156, 50);
        exitbutton.setBackground(new Color(169, 10, 10));
        exitbutton.setForeground(Color.white);
        exitbutton.setFont(new Font("Verdana", Font.BOLD, 10));
        exitbutton.addActionListener(this);
        panel.add(exitbutton);

        // hover effect in the login button
        exitbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitbutton.setBackground(new Color(59, 9, 9));

                exitbutton.setForeground(Color.WHITE);

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {

                exitbutton.setForeground(Color.white);
                exitbutton.setBackground(new Color(169, 10, 10));
            }
        });

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(239, 221, 93));
        panel2.setBounds(900, 0, 700, 1000);
        panel.add(panel2);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminbutton) {
            this.setVisible(false);
            new Loading().setVisible(true);
        } else if (e.getSource() == loginbutton) {
            this.setVisible(false);
            new Userloading().setVisible(true);
        } else if (e.getSource() == administratorbutton) {
            this.setVisible(false);
            new Head_adminloading().setVisible(true);
        } else {
            System.exit(0);
        }
    }

}
