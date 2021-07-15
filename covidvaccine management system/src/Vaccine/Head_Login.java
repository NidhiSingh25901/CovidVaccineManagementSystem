package Vaccine;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.sql.*;

public class Head_Login extends JFrame implements ActionListener {
  public static void main(String[] args) {
    new Head_Login().setVisible(true);
  }

  JButton adminlogin;
  JButton resetpass;
  JButton signup;
  JTextField adminidtext;
  JPasswordField passwordtext;
  JLabel screen;
  String aadharvalue;

  public Head_Login() {

    // frame size and styling
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setResizable(false);
    setTitle("Administration Head - Log In");

    // setting background image
    ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/headadmin-bg.jpg"));
    Image setbg = background.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
    ImageIcon imgbg = new ImageIcon(setbg);
    screen = new JLabel(imgbg);

    // border for the panel
    Border blackline = BorderFactory.createLineBorder(Color.BLACK);
    JPanel panel1 = new JPanel();
    panel1.setBounds(570, 190, 330, 360);
    panel1.setBorder(blackline);
    panel1.setBackground(new Color(245, 220, 238, 125));

    // login heading
    JLabel loginhead = new JLabel("HEAD ADMIN LOGIN");
    loginhead.setBounds(630, 180, 200, 100);
    loginhead.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    screen.add(loginhead);

    // administrator id title
    JLabel adminid = new JLabel("Administration Id");
    adminid.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    adminid.setBounds(600, 250, 300, 100);
    screen.add(adminid);

    // administrator id textfield
    adminidtext = new JTextField();
    adminidtext.setForeground(Color.BLACK);
    adminidtext.setBounds(600, 320, 270, 30);
    screen.add(adminidtext);

    // administrator password title
    JLabel password = new JLabel("Password");
    password.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    password.setBounds(600, 340, 100, 100);
    screen.add(password);

    // administrator password textfield
    passwordtext = new JPasswordField();
    passwordtext.setBounds(600, 410, 270, 30);
    screen.add(passwordtext);

    // login button
    adminlogin = new JButton("LOG IN");
    adminlogin.setBounds(600, 470, 270, 30);
    adminlogin.setBackground(new Color(0, 199, 255, 200));
    adminlogin.addActionListener(this);
    screen.add(adminlogin);

    // admin icon for the panel
    ImageIcon i8 = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/service5.jpg"));
    Image i9 = i8.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
    ImageIcon i10 = new ImageIcon(i9);
    JLabel l5 = new JLabel(i10);
    l5.setBounds(700, 160, 50, 50);

    screen.add(l5);
    screen.add(panel1);
    add(screen);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == adminlogin) {
      try {
        Conn conn = new Conn();
        String sql = "SELECT * FROM headadminlogin WHERE headadminid=? AND password=?";
        PreparedStatement st = conn.c.prepareStatement(sql);

        st.setString(1, adminidtext.getText());
        st.setString(2, passwordtext.getText());

        ResultSet rs = st.executeQuery();

        if (rs.next()) {
          this.setVisible(false);
          new HeadAdmin_dashboard(rs.getString(2)).setVisible(true);

        } else {

          JOptionPane.showMessageDialog(null, "Invalid Credentials");

        }
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
  }

}
