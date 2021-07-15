package Vaccine;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.sql.*;

public class User_Login extends JFrame implements ActionListener {
  JButton userlogin;
  JButton resetpass;
  JButton signup;
  JTextField t1;
  JPasswordField t2;
  JLabel l1;
  String aadharvalue;

  public static void main(String[] args) {
    User_Login user = new User_Login();

    user.setVisible(true);
  }

  public User_Login() {

    // setting frame size
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setResizable(false);
    setTitle("User - Log In");

    // background image
    ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/login-bg.jpg"));
    Image i6 = background.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
    ImageIcon i7 = new ImageIcon(i6);
    l1 = new JLabel(i7);

    // black border
    Border blackline = BorderFactory.createLineBorder(Color.BLACK);
    JPanel p1 = new JPanel();
    p1.setBounds(600, 230, 330, 360);
    p1.setBorder(blackline);
    p1.setBackground(new Color(245, 220, 238, 125));

    // user login heading
    JLabel p2 = new JLabel("USER LOGIN");
    p2.setBounds(665, 230, 200, 100);
    p2.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
    l1.add(p2);

    // aadhar numebr-title
    JLabel p3 = new JLabel("Aadhar Number");
    p3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
    p3.setBounds(630, 280, 500, 100);
    l1.add(p3);

    // aadhar number textfield
    t1 = new JTextField();
    t1.setForeground(Color.BLACK);
    t1.setBounds(630, 350, 260, 30);
    l1.add(t1);

    // password-title
    JLabel p4 = new JLabel("Password");
    p4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
    p4.setBounds(630, 360, 100, 100);
    l1.add(p4);

    // password-textfield
    t2 = new JPasswordField();
    t2.setBounds(630, 430, 260, 30);
    l1.add(t2);
    userlogin = new JButton("LOG IN");
    userlogin.setBounds(630, 490, 260, 30);
    userlogin.setBackground(new Color(0, 199, 255, 200));
    userlogin.addActionListener(this);
    l1.add(userlogin);

    // user login icon
    ImageIcon i8 = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/service5.jpg"));
    Image i9 = i8.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
    ImageIcon i10 = new ImageIcon(i9);
    JLabel l5 = new JLabel(i10);
    l5.setBounds(740, 200, 50, 50);

    l1.add(l5);
    l1.add(p1);
    add(l1);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == userlogin) {
      Boolean status = false;
      try {
        Conn conn = new Conn();
        String sql = "SELECT * FROM usersignup WHERE aadhar=? AND password=?";
        PreparedStatement st = conn.c.prepareStatement(sql);

        st.setString(1, t1.getText());
        st.setString(2, t2.getText());

        ResultSet rs = st.executeQuery();

        if (rs.next()) {
          this.setVisible(false);
          aadharvalue = rs.getString(4);
          new User_afterloading(rs.getString(2), aadharvalue).setVisible(true);
        } else {

          JOptionPane.showMessageDialog(null, "Invalid Credentials");

        }
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
  }
}
