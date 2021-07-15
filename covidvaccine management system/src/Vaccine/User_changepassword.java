package Vaccine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class User_changepassword extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new User_changepassword("").setVisible(true);
    }

    String aadharnumber;
    JPasswordField newpasstext;
    JPasswordField confirmpasstext;
    JButton okbutton,confirmbutton;

    public User_changepassword(String aadharnumber) {

        this.aadharnumber = aadharnumber;

        // setting frame zize and styling
        setBounds(500, 150, 760, 600);
        setResizable(false);
        setUndecorated(true);
        setBackground(new Color(34, 54, 86, 250));
        setLayout(null);

        // password title
        JLabel passwordhead = new JLabel("<html><u>UPDATE PASSWORD</u></html>");
        passwordhead.setBounds(250, 110, 550, 30);
        passwordhead.setForeground(Color.white);
        passwordhead.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(passwordhead);

        // new password title
        JLabel newpass = new JLabel("NEW PASSWORD");
        newpass.setBounds(200, 200, 550, 30);
        newpass.setForeground(Color.white);
        newpass.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(newpass);

        // new password textfield
        newpasstext = new JPasswordField();
        newpasstext.setBounds(200, 240, 300, 30);
        add(newpasstext);

        // confirm password
        JLabel confirmpass = new JLabel("CONFIRM PASSWORD");
        confirmpass.setBounds(200, 300, 550, 30);
        confirmpass.setFont(new Font("Tahoma", Font.BOLD, 25));
        confirmpass.setForeground(Color.white);
        add(confirmpass);

        // confirm password textfield
        confirmpasstext = new JPasswordField();
        confirmpasstext.setBounds(200, 340, 300, 30);
        add(confirmpasstext);

        // okbutton
        okbutton = new JButton("UPDATE");
        okbutton.setBounds(300, 400, 130, 26);
        okbutton.setBackground(Color.blue);
        okbutton.setForeground(Color.white);
        okbutton.addActionListener(this);
        add(okbutton);

        confirmbutton = new JButton("OK");
        confirmbutton.setBounds(300,500,130,26);
        confirmbutton.setForeground(Color.white);
        confirmbutton.setBackground(Color.blue);
        confirmbutton.addActionListener(this); 
        add(confirmbutton);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okbutton) {

            String password1 = newpasstext.getText();
            String password2 = confirmpasstext.getText();

            if (password1.equals("") || password2.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your password to update");
            } else {
                if (password1.equals(password2)) {

                    try {

                        Conn con = new Conn();
                        String sql = "UPDATE usersignup SET password='" + password1 + "' WHERE aadhar='" + aadharnumber
                                + "'";
                        con.s.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Password updated successfully");

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());

                    }

                } else

                {
                    JOptionPane.showMessageDialog(null, "Your password didn't match");
                    this.setVisible(false);
                }
            }
        } 

        if(e.getSource()==confirmbutton){
            this.setVisible(false);
        }
    }
}
