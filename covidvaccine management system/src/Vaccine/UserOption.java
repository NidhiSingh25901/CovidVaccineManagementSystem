package Vaccine;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class UserOption extends JFrame implements ActionListener {

    JButton signupButton;
    JButton loginButton;

    public static void main(String[] args) {

        new UserOption().setVisible(true);

    }

    public UserOption() {

        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("User");

        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);

        // background image
        ImageIcon background_image = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/user-bg.jpg"));
        Image img = background_image.getImage().getScaledInstance(1550, 1500, Image.SCALE_DEFAULT);
        background_image = new ImageIcon(img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 1350, 1000);
        add(background);

        // signup panel
        JPanel signpanel = new JPanel();
        signpanel.setBounds(190, 200, 330, 350);
        signpanel.setBorder(blackBorder);
        signpanel.setBackground(new Color(174, 226, 234, 150));

        // sign paragraph
        String textsignup = "<html><p>Sign up is an action to register yourself for a newaccount.</br> If you havn't registerd yourself yet, please SIGN UP here...<p></html>";
        JLabel signupinfo = new JLabel(textsignup);
        signupinfo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        signupinfo.setBounds(230, 170, 295, 300);
        background.add(signupinfo);

        // signup redirecting button
        signupButton = new JButton("SIGN UP");
        signupButton.setBounds(250, 450, 100, 30);
        signupButton.setForeground(Color.BLACK);
        signupButton.setBackground(new Color(0, 199, 255, 200));
        signupButton.addActionListener(this);
        background.add(signupButton);

        // login panel
        JPanel loginpanel = new JPanel();
        loginpanel.setBounds(950, 200, 330, 350);
        loginpanel.setBorder(blackBorder);
        loginpanel.setBackground(new Color(191, 191, 191, 150));

        // login paragraph
        String textlogin = "<html><p>Log In is an action to get into the website using credentials.</br> If you have already registerd yourself, please LOG IN here...</p></html>";
        JLabel loginfo = new JLabel(textlogin);
        loginfo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        loginfo.setBounds(970, 170, 295, 300);
        background.add(loginfo);

        // logim redirecting button
        loginButton = new JButton("LOG IN");
        loginButton.setBounds(1065, 450, 100, 30);
        loginButton.setForeground(Color.BLACK);
        loginButton.setBackground(new Color(130, 130, 130, 200));
        loginButton.addActionListener(this);

        background.add(loginButton);
        background.add(signpanel);
        background.add(loginpanel);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            this.setVisible(false);
            new User_Signup().setVisible(true);
        } else if (e.getSource() == loginButton) {
            this.setVisible(false);
            new User_Login().setVisible(true);
        }
    }
}