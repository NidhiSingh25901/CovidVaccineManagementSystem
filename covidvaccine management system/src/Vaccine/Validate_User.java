package Vaccine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Validate_User extends JFrame implements ActionListener {
  public static void main(String[] args) {
    new Validate_User("").setVisible(true);
  }

  JButton okbutton, vaccinatedbutton, logout;
  String username, password, adminid;
  JTextField nametext, aadhartext, secretcodetext;
  JLabel vaccinatedstatus;

  public Validate_User(String adminid) {

    this.adminid = adminid;

    // setting frame size
    setBounds(500, 150, 760, 600);
    setResizable(false);
    setUndecorated(true);
    setTitle("Admin - Validate Vaccinated User");

    JPanel panel = new JPanel();
    panel.setBounds(0, 0, 1950, 1000);
    panel.setSize(1950, 1000);
    panel.setLayout(null);
    panel.setBackground(new Color(153, 51, 83));
    add(panel);

    // enter the details
    JLabel title = new JLabel("<html><u>Enter the Details of the User Below.</u></html>");
    title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
    title.setForeground(Color.white);
    title.setBounds(150, 100, 800, 30);
    panel.add(title);

    // user name - title
    JLabel name = new JLabel("NAME :");
    name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    name.setBounds(150, 200, 300, 30);
    name.setForeground(Color.white);
    panel.add(name);

    // user name - textfield
    nametext = new JTextField();
    nametext.setForeground(Color.BLACK);
    nametext.setBounds(350, 200, 300, 30);
    panel.add(nametext);

    // aadhar number of user - name
    JLabel aadhar = new JLabel("AADHAR NUMBER :");
    aadhar.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    aadhar.setBounds(150, 300, 300, 30);
    aadhar.setForeground(Color.white);
    panel.add(aadhar);

    // aadhar name - textfield
    aadhartext = new JTextField();
    aadhartext.setForeground(Color.BLACK);
    aadhartext.setBounds(350, 300, 300, 30);
    panel.add(aadhartext);

    // vaccinated button
    vaccinatedbutton = new JButton("VACCINATED");
    vaccinatedbutton.setBackground(Color.WHITE);
    vaccinatedbutton.setFont(new Font("Tahoma", Font.BOLD, 18));
    vaccinatedbutton.setBounds(240, 400, 300, 50);
    vaccinatedbutton.addActionListener(this);
    panel.add(vaccinatedbutton);

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

    if (e.getSource() == vaccinatedbutton) {

      String aadharvalue = aadhartext.getText();
      if (aadharvalue.equals("")) {
        JOptionPane.showMessageDialog(null, "error");
      } else {
        try {
          Conn con = new Conn();
          int a = 1;
          String sql = "SELECT * FROM usersignup WHERE aadhar='" + aadharvalue + "' AND status='" + a + "'";
          PreparedStatement st = con.c.prepareStatement(sql);
          ResultSet rs = st.executeQuery();
          if (rs.next()) {
            con.s.executeUpdate("UPDATE usersignup SET dose='" + a + "' WHERE aadhar='" + aadharvalue + "'");
            JOptionPane.showMessageDialog(null,
                "<html>Beneficiary has recieved covid vaccination <br>Please verify in vaccinate section</html>");
          } else {
            JOptionPane.showMessageDialog(null,
                "<html>User is not registered<br>Or, beneficiary is below 18 years</html>");
          }
        } catch (Exception ee) {

        }
      }
    }

    if (e.getSource() == okbutton) {
      this.setVisible(false);
    }
  }
}