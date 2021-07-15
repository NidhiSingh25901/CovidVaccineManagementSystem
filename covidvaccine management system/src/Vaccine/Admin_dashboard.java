package Vaccine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Admin_dashboard extends JFrame implements ActionListener {

  public static void main(String[] args) {

    new Admin_dashboard("").setVisible(true);

  }

  JButton instruction;
  JButton slotupdate;
  JButton validate;
  JButton vaccinateduser;
  JButton changepassword;
  String username,password;
  JButton logout;
  JButton qcenter; 
  String adminidvalue;
  
  public Admin_dashboard(String adminid) {
   
    this.adminidvalue = adminid;
  
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setResizable(false);
    setTitle("Admin - Dashboard");
     
    //Fetching username and password from the database
   try { 
     Conn con = new Conn();
     String sql ="SELECT * FROM adminlogin WHERE adminid='"+adminid+"'";

     ResultSet rs = con.s.executeQuery(sql);
     while(rs.next()) {
       username = rs.getString(3);
       password = rs.getString(4);
     }

   } catch( Exception e) {

   } 


    // top section that is of red color having icon in it
    JPanel tophead = new JPanel();
    tophead.setBounds(0, 0, 1950, 80);
    tophead.setLayout(null);
    tophead.setBackground(new Color(153, 51, 83));
    add(tophead); 


    // admin icon at the top left corner
    ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/usericon.jpg"));
    Image imgicon = imageicon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
    ImageIcon setimgicon = new ImageIcon(imgicon);
    JLabel headicon = new JLabel(setimgicon);
    headicon.setBounds(0, 0, 75, 75);
    tophead.add(headicon); 


    // admin name to be displayed at the top left corner
    JLabel usernamehead = new JLabel(username);
    usernamehead.setForeground(Color.white);
    usernamehead.setBounds(90, 8, 1000, 60);
    usernamehead.setFont(new Font("Tahoma", Font.BOLD, 20));
    tophead.add(usernamehead);


    // side bar that has list of options for the admin
    JPanel sidebar = new JPanel();
    sidebar.setLayout(null);
    sidebar.setBounds(0, 80, 300, 1000);
    sidebar.setBackground(new Color(153, 51, 83));
    add(sidebar);

    // home that is the dsahboard itself
    JButton home = new JButton("HOME");
    home.setBackground(new Color(153, 51, 83));
    home.setForeground(Color.white);
    home.setFont(new Font("Tahoma", Font.BOLD, 20));
    home.setBounds(0, 0, 300, 110);
    sidebar.add(home);

    // instruction button 
    instruction = new JButton("INSTRUCTION");
    instruction.setBackground(new Color(153, 51, 83));
    instruction.setForeground(Color.white);
    instruction.setFont(new Font("Tahoma", Font.BOLD, 20));
    instruction.setBounds(0, 110, 300, 110);
    instruction.addActionListener(this);
    sidebar.add(instruction);

    // validate button to give vaccination to the beneficiary
    validate = new JButton("VALIDATE");
    validate.setBackground(new Color(153, 51, 83));
    validate.setForeground(Color.white);
    validate.setFont(new Font("Tahoma", Font.BOLD, 20));
    validate.setBounds(0, 220, 300, 110);
    validate.addActionListener(this);
    sidebar.add(validate);

    // slot update
    slotupdate = new JButton("SLOT UPDATE");
    slotupdate.setBackground(new Color(153, 51, 83));
    slotupdate.setForeground(Color.white);
    slotupdate.setFont(new Font("Tahoma", Font.BOLD, 20));
    slotupdate.setBounds(0, 330, 300, 110);
    slotupdate.addActionListener(this);
    sidebar.add(slotupdate);

    //vaccinated button to verify whether the user is vaccinated or not
    vaccinateduser = new JButton("VACCINATED USER");
    vaccinateduser.setBackground(new Color(153, 51, 83));
    vaccinateduser.setForeground(Color.white);
    vaccinateduser.setFont(new Font("Tahoma", Font.BOLD, 20));
    vaccinateduser.setBounds(0, 440, 300, 110);
    vaccinateduser.addActionListener(this);
    sidebar.add(vaccinateduser);

    // logout button for the admin
    logout = new JButton("LOGOUT");
    logout.setBackground(new Color(153, 51, 83));
    logout.setForeground(Color.white);
    logout.setFont(new Font("Tahoma", Font.BOLD, 20));
    logout.setBounds(0, 550, 300, 110);
    logout.addActionListener(this);
    sidebar.add(logout);

    // background image of the dashboard
    ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/adminmain.jpg"));
    Image img = image.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
    ImageIcon setimg = new ImageIcon(img);
    JLabel mainlabel = new JLabel(setimg);
    add(mainlabel);
    
  }

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == instruction) {
      new Admin_instruction().setVisible(true);
    }

    if(e.getSource() == slotupdate) {
      new Update_Slot(adminidvalue).setVisible(true);
    } 
    if(e.getSource() == validate) {
      new Validate_User(adminidvalue).setVisible(true);
    } 
    if(e.getSource() == vaccinateduser) {
      new Vaccinated_User(adminidvalue).setVisible(true);
    } 

    if(e.getSource() == changepassword) {
  new Change_Password_Admin(adminidvalue).setVisible(true);
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
