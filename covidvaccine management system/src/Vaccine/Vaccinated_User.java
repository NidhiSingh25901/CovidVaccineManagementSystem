package Vaccine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Vaccinated_User extends JFrame implements ActionListener {
  public static void main(String[] args) {
    new Vaccinated_User("").setVisible(true);
  }

  JButton okbutton, ckeckbutton, logout;
  String username, password, adminid;
  JTextField nametext, aadhartext, secretcodetext;

  public Vaccinated_User(String adminid) {

    this.adminid = adminid;

    // setting frame size and styling
    setBounds(500, 150, 760, 600);
    setUndecorated(true);
    setResizable(false);
    setTitle("Admin - Check Vaccinated User");

    // panel
    JPanel panel = new JPanel();
    panel.setBounds(0, 0, 1950, 1000);
    panel.setSize(1950, 1000);
    panel.setLayout(null);
    panel.setBackground(new Color(153, 51, 83));
    add(panel);

    // title
    JLabel title = new JLabel("Enter Details to check whether VACCINATED or not.");
    title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
    title.setBounds(110, 100, 800, 30);
    title.setForeground(Color.white);
    panel.add(title);

    // user - title
    JLabel name = new JLabel("NAME :");
    name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    name.setBounds(150, 200, 800, 30);
    name.setForeground(Color.white);
    panel.add(name);

    // user - textfield
    nametext = new JTextField();
    nametext.setForeground(Color.BLACK);
    nametext.setBounds(350, 200, 300, 30);
    panel.add(nametext);

    // aadhar - title
    JLabel aadhar = new JLabel("AADHAR NUMBER :");
    aadhar.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    aadhar.setBounds(150, 300, 300, 30);
    aadhar.setForeground(Color.white);
    panel.add(aadhar);

    // aadhar-textfield
    aadhartext = new JTextField();
    aadhartext.setForeground(Color.BLACK);
    aadhartext.setBounds(350, 300, 300, 30);
    panel.add(aadhartext);

    // vaccinated button
    ckeckbutton = new JButton("CHECK");
    ckeckbutton.setBackground(Color.WHITE);
    ckeckbutton.setFont(new Font("Tahoma", Font.BOLD, 18));
    ckeckbutton.setBounds(240, 400, 300, 50);
    ckeckbutton.addActionListener(this);
    panel.add(ckeckbutton);

    // back button
    okbutton = new JButton("OK");
    okbutton.setBackground(Color.WHITE);
    okbutton.setFont(new Font("Tahoma", Font.BOLD, 13));
    okbutton.setBounds(350, 480, 60, 30);
    okbutton.addActionListener(this);
    panel.add(okbutton);

    // logout button
    logout = new JButton("LOGOUT");
    logout.setBackground(Color.WHITE);
    logout.setFont(new Font("Tahoma", Font.BOLD, 13));
    logout.setBounds(100, 600, 200, 50);
    logout.addActionListener(this);
    panel.add(logout);
  }

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == okbutton) {
      this.setVisible(false);
    }

    if (e.getSource() == logout) {
      int logoutvalue = JOptionPane.showConfirmDialog(null, "Are you sure to logout ?");
      if (logoutvalue == JOptionPane.YES_OPTION) {
        dispose();
        new ChoiceLogin().setVisible(true);
      } else {
        this.setVisible(true);
      }
    }
    if (e.getSource() == ckeckbutton) {
      try {
        Conn conn = new Conn();
        String sql = "SELECT * FROM usersignup WHERE aadhar='" + aadhartext.getText() + "'";
        PreparedStatement st = conn.c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        if (rs.next()) {
          if (rs.getInt(8) == 1)
            JOptionPane.showMessageDialog(null, "VACCINATED.");
          else
            JOptionPane.showMessageDialog(null, "NOT VACCINATED.");
        } else
          JOptionPane.showMessageDialog(null, "Aadhar number do not exist.");
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }

  }
}