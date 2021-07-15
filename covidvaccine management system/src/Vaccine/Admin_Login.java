
package Vaccine;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.*;
public class Admin_Login extends JFrame implements ActionListener {
    
  JButton adminlogin;
  JPasswordField t2;
  JTextField t1;
  JLabel l1;

  public static void main(String[] args) {
    Admin_Login admin = new Admin_Login();

    admin.setVisible(true);
  }

  public Admin_Login() {
   
    //setting frame size
    setResizable(false);
    setTitle("Admin - Log In");
    setExtendedState(JFrame.MAXIMIZED_BOTH); 

    // background imagw
    ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/adminlogin.jpg"));
    Image i6 = i5.getImage().getScaledInstance(1590, 1000, Image.SCALE_DEFAULT);
    ImageIcon i7 = new ImageIcon(i6);
    l1 = new JLabel(i7);
    Border blackline = BorderFactory.createLineBorder(Color.black);
    JPanel p1 = new JPanel();
   
    //setting the size of tge panel
    p1.setBounds(490,250,500,350);
    p1.setBorder(blackline);
    p1.setBackground(new Color(245, 220, 238, 125));
    p1.setOpaque(true); 

    //admin heading
    JLabel p2 = new JLabel("ADMIN LOGIN");
    p2.setBounds(600, 100, 800, 100);
    p2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
    l1.add(p2); 

     
    // admin id heading
    JLabel p3 = new JLabel("Admin Id");
    p3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
    p3.setBounds(530,270,700,100);
    l1.add(p3); 

    // admin id textfield
    t1 = new JTextField();
    t1.setForeground(Color.BLACK);
    t1.setBounds(530,350,400,30);
    l1.add(t1); 

    //admin password heading
    JLabel p4 = new JLabel("Password");
    p4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
    p4.setBounds(530,380,700,100);
    l1.add(p4); 


    //admin id password textfield
    t2 = new JPasswordField();
    t2.setBounds(530,460,400,30);
    l1.add(t2); 

    //admin log in button
    adminlogin = new JButton("LOG IN");
    adminlogin.setBounds(530,520,400,30);
    adminlogin.setFont(new Font(Font.SANS_SERIF, Font.BOLD,15));
    adminlogin.setBackground(new Color(230, 120, 171));
    adminlogin.addActionListener(this);
    l1.add(adminlogin); 


    // admin login icon 
    ImageIcon i8 = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/service5.jpg"));
    Image i9 = i8.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
    ImageIcon i10 = new ImageIcon(i9);
    JLabel l5 = new JLabel(i10);
    l5.setBounds(690,220,90,70); 

    l1.add(l5);
    l1.add(p1);
    add(l1);
  }

public void actionPerformed(ActionEvent e) {
   
   try {
       Conn conn = new Conn();
       String sql = "SELECT * FROM adminlogin where adminid=? AND password=?";
       PreparedStatement st = conn.c.prepareStatement(sql);
       
       st.setString(1,t1.getText());
       st.setString(2,t2.getText());
       ResultSet rs = st.executeQuery();
       

         if(rs.next()) {
              this.setVisible(false);
              new Admin_dashboard(rs.getString(2)).setVisible(true);
       } else {
            JOptionPane.showMessageDialog(null,"Invalid Credentials");
       }
      

   } catch(Exception ex) {

   }

  }

}
