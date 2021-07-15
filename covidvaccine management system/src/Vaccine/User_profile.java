package Vaccine;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class User_profile extends JFrame implements ActionListener {
  public static void main(String[] args) {
    new User_profile("").setVisible(true);
  }

  String username, userdob, usermobile, useraadhar, display;
  JLabel vaccinated, centername, registercenter;
  int dose;
  String vaccinatevalue;
  JButton okbutton;

  public User_profile(String aadharnumber) {

    //setting frame size
    setBounds(500, 150, 760, 600);
    setResizable(false);
    setUndecorated(true);
    setBackground(new Color(34, 54, 86, 250));
    setLayout(null);

    try {
      Conn con = new Conn();
      String sql = "SELECT * FROM usersignup WHERE aadhar='" + aadharnumber + "'";
      ResultSet rs = con.s.executeQuery(sql);
      while (rs.next()) {
        username = rs.getString(2);
        userdob = rs.getString(3);
        usermobile = rs.getString(5);
        useraadhar = rs.getString(4);
        dose = rs.getInt(6);
      }
    } catch (Exception e) {

    } 

    //title
    JLabel profilehead = new JLabel("<html><u><strong>PROFILE</strong></u></html>");
    profilehead.setBounds(250, 70, 550, 30);
    profilehead.setForeground(Color.WHITE);
    profilehead.setFont(new Font("Thaoma", Font.BOLD, 20));
    add(profilehead);

    //name-title
    JLabel name = new JLabel("<html><u>NAME</u></html>");
    name.setBounds(200, 120, 550, 30);
    name.setForeground(Color.white);
    name.setFont(new Font("Tahoma", Font.BOLD, 18));
    add(name);

    //name-textield
    JLabel nametext = new JLabel(username);
    nametext.setBounds(200, 150, 300, 30);
    nametext.setForeground(Color.white);
    nametext.setFont(new Font("Tahoma", Font.BOLD, 20));
    add(nametext);

    //date of birth-title
    JLabel dob = new JLabel("<html><u>DATE OF BIRTH</u></html>");
    dob.setBounds(200, 200, 550, 30);
    dob.setForeground(Color.white);
    dob.setFont(new Font("Tahoma", Font.BOLD, 18));
    add(dob);

    //date of birht-textfield
    JLabel dobtext = new JLabel(userdob);
    dobtext.setBounds(200, 230, 300, 30);
    dobtext.setForeground(Color.white);
    dobtext.setFont(new Font("Tahoma", Font.BOLD, 20));
    add(dobtext);

    //mobile number-title
    JLabel mobile = new JLabel("<html><u>MOBILE NUMBER</u></html>");
    mobile.setBounds(200, 280, 550, 30);
    mobile.setForeground(Color.white);
    mobile.setFont(new Font("Tahoma", Font.BOLD, 18));
    add(mobile);

    //mobile number - textfield
    JLabel mobiletext = new JLabel(usermobile);
    mobiletext.setBounds(200, 310, 300, 30);
    mobiletext.setForeground(Color.white);
    mobiletext.setFont(new Font("Tahoma", Font.BOLD, 20));
    add(mobiletext);


    // aadhar number - title
    JLabel aadhar = new JLabel("<html><u>AADHAR NUMBER</u></html>");
    aadhar.setBounds(200, 360, 550, 30);
    aadhar.setForeground(Color.white);
    aadhar.setFont(new Font("Tahoma", Font.BOLD, 18));
    add(aadhar);

    // aadhar number textfield
    JLabel aadhartext = new JLabel(aadharnumber);
    aadhartext.setBounds(200, 390, 300, 30);
    aadhartext.setForeground(Color.white);
    aadhartext.setFont(new Font("Tahoma", Font.BOLD, 20));
    add(aadhartext);

    // vaccinated status
    vaccinated = new JLabel();
    vaccinated.setBounds(100, 450, 500, 30);
    vaccinated.setBackground(new Color(34, 54, 86));
    vaccinated.setForeground(Color.white);
    vaccinated.setFont(new Font("Thaoma", Font.BOLD, 20));
    add(vaccinated);

    try {
      Conn con = new Conn();
      int a = 1;
      String dosesql = "SELECT * FROM usersignup WHERE dose='" + a + "' AND aadhar='" + aadharnumber + "'";
      PreparedStatement dosest = con.c.prepareStatement(dosesql);
      ResultSet dosers = dosest.executeQuery();
      if (dosers.next()) {
        vaccinated.setText("You are vaccinated");
      } else {
        vaccinated.setText("Take your vaccination as soon as possible");
      }

    } catch (Exception e) {

    }

    okbutton = new JButton("OK");
    okbutton.setBounds(300, 550, 70, 26);
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
