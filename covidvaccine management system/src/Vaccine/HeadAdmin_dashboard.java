package Vaccine;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class HeadAdmin_dashboard extends JFrame implements ActionListener {
  public static void main(String[] args) {
    new HeadAdmin_dashboard("").setVisible(true);
  }

  JButton statistics;
  JButton slotupdate;
  JButton addadmin;
  JButton vaccinateduser;
  JButton unvaccinateduser;
  String username, password;
  JButton logout;
  JButton qcenter;
  String headadminid;
  JButton quarantinecenter;
  JButton registereduser;

  public HeadAdmin_dashboard(String adminid) {

    this.headadminid = adminid;

    // setting frame size and style
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setResizable(false);
    setTitle("Head Admin - Dashboard");

    try {
      Conn con = new Conn();
      String sql = "SELECT * FROM headadminlogin WHERE adminid='" + headadminid + "'";

      ResultSet rs = con.s.executeQuery(sql);
      while (rs.next()) {
        username = rs.getString(2);
        password = rs.getString(3);
      }

    } catch (Exception e) {

    }

    // head part
    JPanel tophead = new JPanel();
    tophead.setBounds(0, 0, 1950, 80);
    tophead.setLayout(null);
    tophead.setBackground(new Color(50, 57, 64));
    add(tophead);

    // settiing admin icon at the top left corner
    ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/usericon.jpg"));
    Image imgicon = imageicon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    ImageIcon setimgicon = new ImageIcon(imgicon);
    JLabel headicon = new JLabel(setimgicon);
    headicon.setBounds(0, 0, 75, 75);
    tophead.add(headicon);

    // displaying admin actual name from database at the top left corner
    JLabel usernamehead = new JLabel(headadminid);
    usernamehead.setForeground(Color.white);
    usernamehead.setBounds(90, 8, 1000, 60);
    usernamehead.setFont(new Font("Tahoma", Font.BOLD, 20));
    tophead.add(usernamehead);

    // side bar
    JPanel sidebar = new JPanel();
    sidebar.setLayout(null);
    sidebar.setBounds(0, 80, 300, 1000);
    sidebar.setBackground(new Color(50, 57, 64));
    add(sidebar);

    // home
    JButton home = new JButton("HOME");
    home.setBackground(new Color(50, 57, 64));
    home.setForeground(Color.white);
    home.setFont(new Font("Tahoma", Font.BOLD, 20));
    home.setBounds(0, 0, 300, 80);
    sidebar.add(home);

    // statistics
    statistics = new JButton("STATISTICS");
    statistics.setBackground(new Color(50, 57, 64));
    statistics.setForeground(Color.white);
    statistics.setFont(new Font("Tahoma", Font.BOLD, 20));
    statistics.setBounds(0, 80, 300, 80);
    statistics.addActionListener(this);
    sidebar.add(statistics);

    // add asmin
    addadmin = new JButton("ADD ADMIN");
    addadmin.setBackground(new Color(50, 57, 64));
    addadmin.setForeground(Color.white);
    addadmin.setFont(new Font("Tahoma", Font.BOLD, 20));
    addadmin.setBounds(0, 160, 300, 80);
    addadmin.addActionListener(this);
    sidebar.add(addadmin);

    // slot update
    slotupdate = new JButton("EDIT SLOT CENTER");
    slotupdate.setBackground(new Color(50, 57, 64));
    slotupdate.setForeground(Color.white);
    slotupdate.setFont(new Font("Tahoma", Font.BOLD, 20));
    slotupdate.setBounds(0, 240, 300, 80);
    slotupdate.addActionListener(this);
    sidebar.add(slotupdate);

    // quarantine center
    quarantinecenter = new JButton("EDIT QUARANTINE CENTER");
    quarantinecenter.setBackground(new Color(50, 57, 64));
    quarantinecenter.setForeground(Color.white);
    quarantinecenter.setFont(new Font("Tahoma", Font.BOLD, 17));
    quarantinecenter.setBounds(0, 320, 300, 80);
    quarantinecenter.addActionListener(this);
    sidebar.add(quarantinecenter);

    // vaccinated user
    vaccinateduser = new JButton("VACCINATED USER");
    vaccinateduser.setBackground(new Color(50, 57, 64));
    vaccinateduser.setForeground(Color.white);
    vaccinateduser.setFont(new Font("Tahoma", Font.BOLD, 20));
    vaccinateduser.setBounds(0, 400, 300, 80);
    vaccinateduser.addActionListener(this);
    sidebar.add(vaccinateduser);

    // registered user
    registereduser = new JButton("REGISTERED USER");
    registereduser.setBackground(new Color(50, 57, 64));
    registereduser.setForeground(Color.white);
    registereduser.setFont(new Font("Tahoma", Font.BOLD, 20));
    registereduser.setBounds(0, 480, 300, 80);
    registereduser.addActionListener(this);
    sidebar.add(registereduser);

    // unvaccinated user
    unvaccinateduser = new JButton("UNVACINATED USER");
    unvaccinateduser.setBackground(new Color(50, 57, 64));
    unvaccinateduser.setForeground(Color.white);
    unvaccinateduser.setFont(new Font("Tahoma", Font.BOLD, 20));
    unvaccinateduser.setBounds(0, 560, 300, 80);
    unvaccinateduser.addActionListener(this);
    sidebar.add(unvaccinateduser);

    // logout
    logout = new JButton("LOGOUT");
    logout.setBackground(new Color(50, 57, 64));
    logout.setForeground(Color.white);
    logout.setFont(new Font("Tahoma", Font.BOLD, 20));
    logout.setBounds(0, 640, 300, 80);
    logout.addActionListener(this);
    sidebar.add(logout);

    // background image of the dashboard
    ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/headadmindash-bg.jpg"));
    Image img = image.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
    ImageIcon setimg = new ImageIcon(img);
    JLabel mainlabel = new JLabel(setimg);
    add(mainlabel);

  }

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == statistics) {
      new Head_Statistics().setVisible(true);
    }
    if (e.getSource() == addadmin) {
      new Head_addAdmin().setVisible(true);
    }

    if (e.getSource() == slotupdate) {
      new Head_displayslotcenter().setVisible(true);
    }

    if (e.getSource() == quarantinecenter) {
      new Head_quarantinecenter().setVisible(true);
    }
    if (e.getSource() == vaccinateduser) {
      new Head_vaccinateduser().setVisible(true);
    }
    if (e.getSource() == registereduser) {
      new Head_registereduser().setVisible(true);
    }
    if (e.getSource() == unvaccinateduser) {
      new Head_unvaccinateduser().setVisible(true);
    }
    if (e.getSource() == logout) {

      int logoutvalue = JOptionPane.showConfirmDialog(null, "Are you sure to logout ?");
      if (logoutvalue == JOptionPane.YES_OPTION) {
        this.setVisible(false);
        new ChoiceLogin().setVisible(true);

      } else {
        this.setVisible(true);
      }

    }
  }
}
