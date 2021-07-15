package Vaccine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Userdashboard extends JFrame implements ActionListener {
   public static void main(String[] args) {
      new Userdashboard("", "").setVisible(true);
   }

   JButton instruction;
   JButton helpline;
   JButton guideline;
   JButton profile;
   JButton implinks;
   String aadharnumber;
   String username;
   JButton logout;
   JButton qcenter;
   JButton password;
   JButton bookslot;

   public Userdashboard(String username, String aadharvalue) {
      this.aadharnumber = aadharvalue;
      this.username = username;

      // setting frame size
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setResizable(false);
      setTitle("User - Dashboard");

      // top panel of blue color
      JPanel tophead = new JPanel();
      tophead.setBounds(0, 0, 1950, 80);
      tophead.setLayout(null);
      tophead.setBackground(new Color(22, 53, 140));
      add(tophead);

      // user icon at the top left corder
      ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/usericon.jpg"));
      Image imgicon = imageicon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
      ImageIcon setimgicon = new ImageIcon(imgicon);
      JLabel headicon = new JLabel(setimgicon);
      headicon.setBounds(0, 0, 75, 75);
      tophead.add(headicon);

      // username to be displayed at the top left corner
      JLabel usernamehead = new JLabel(username);
      usernamehead.setForeground(Color.white);
      usernamehead.setBounds(90, 8, 1000, 60);
      usernamehead.setFont(new Font("Tahoma", Font.BOLD, 20));
      tophead.add(usernamehead);

      // sidebar panel
      JPanel sidebar = new JPanel();
      sidebar.setLayout(null);
      sidebar.setBounds(0, 80, 300, 1000);
      sidebar.setBackground(new Color(89, 26, 46));
      add(sidebar);

      // home
      JButton home = new JButton("HOME");
      home.setBackground(new Color(0, 0, 102));
      home.setForeground(Color.white);
      home.setFont(new Font("Tahoma", Font.BOLD, 20));
      home.setBounds(0, 0, 300, 70);
      sidebar.add(home);

      // instruction
      instruction = new JButton("INSTRUCTION");
      instruction.setBackground(new Color(0, 0, 102));
      instruction.setForeground(Color.white);
      instruction.setFont(new Font("Tahoma", Font.BOLD, 20));
      instruction.setBounds(0, 70, 300, 70);
      instruction.addActionListener(this);
      sidebar.add(instruction);

      // book slot
      bookslot = new JButton("BOOK SLOT");
      bookslot.setBackground(new Color(0, 0, 102));
      bookslot.setForeground(Color.white);
      bookslot.setFont(new Font("Tahoma", Font.BOLD, 20));
      bookslot.setBounds(0, 140, 300, 70);
      bookslot.addActionListener(this);
      sidebar.add(bookslot);

      // profile
      profile = new JButton("PROFILE");
      profile.setBackground(new Color(0, 0, 102));
      profile.setForeground(Color.white);
      profile.setFont(new Font("Tahoma", Font.BOLD, 20));
      profile.setBounds(0, 210, 300, 70);
      profile.addActionListener(this);
      sidebar.add(profile);

      // important link
      implinks = new JButton("IMPORTANT LINKS");
      implinks.setBackground(new Color(0, 0, 102));
      implinks.setForeground(Color.white);
      implinks.setFont(new Font("Tahoma", Font.BOLD, 20));
      implinks.setBounds(0, 280, 300, 70);
      implinks.addActionListener(this);
      sidebar.add(implinks);

      // helpline
      helpline = new JButton("HELPLINE");
      helpline.setBackground(new Color(0, 0, 102));
      helpline.setForeground(Color.white);
      helpline.setFont(new Font("Tahoma", Font.BOLD, 20));
      helpline.setBounds(0, 350, 300, 70);
      helpline.addActionListener(this);
      sidebar.add(helpline);

      // qarantine center
      qcenter = new JButton("QUARANTINE CENTER");
      qcenter.setBackground(new Color(0, 0, 102));
      qcenter.setForeground(Color.white);
      qcenter.setFont(new Font("Tahoma", Font.BOLD, 20));
      qcenter.setBounds(0, 420, 300, 70);
      qcenter.addActionListener(this);
      sidebar.add(qcenter);

      // guidelines
      guideline = new JButton("GUIDELINES");
      guideline.setBackground(new Color(0, 0, 102));
      guideline.setForeground(Color.white);
      guideline.setFont(new Font("Tahoma", Font.BOLD, 20));
      guideline.setBounds(0, 490, 300, 70);
      guideline.addActionListener(this);
      sidebar.add(guideline);

      // update password
      password = new JButton("UPDATE PASSWORD");
      password.setBackground(new Color(0, 0, 102));
      password.setForeground(Color.white);
      password.setFont(new Font("Tahoma", Font.BOLD, 20));
      password.setBounds(0, 560, 300, 70);
      password.addActionListener(this);
      sidebar.add(password);

      // logout
      logout = new JButton("LOGOUT");
      logout.setBackground(new Color(0, 0, 102));
      logout.setForeground(Color.white);
      logout.setFont(new Font("Tahoma", Font.BOLD, 20));
      logout.setBounds(0, 630, 300, 120);
      logout.addActionListener(this);
      sidebar.add(logout);

      // background imagw
      ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/userdashboard.jpg"));
      Image img = image.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
      ImageIcon setimg = new ImageIcon(img);
      JLabel mainlabel = new JLabel(setimg);
      add(mainlabel);
   }

   public void actionPerformed(ActionEvent e) {

      if (e.getSource() == instruction) {
         new User_instruction().setVisible(true);
         new User_helpline().setVisible(false);
         new User_guidelines().setVisible(false);
         new Userlink().setVisible(false);
         new User_profile(aadharnumber).setVisible(false);
      }

      if (e.getSource() == bookslot) {
         new SlotBooking(username, aadharnumber).setVisible(true);
      }
      if (e.getSource() == helpline) {
         new User_helpline().setVisible(true);
         new User_instruction().setVisible(false);
         new User_guidelines().setVisible(false);
         new Userlink().setVisible(false);
         new User_profile(aadharnumber).setVisible(false);
      }
      if (e.getSource() == implinks) {
         new Userlink().setVisible(true);
         new User_instruction().setVisible(false);
         new User_helpline().setVisible(false);
         new User_guidelines().setVisible(false);
         new User_profile(aadharnumber).setVisible(false);

      }

      if (e.getSource() == guideline) {
         new User_guidelines().setVisible(true);
         new Userlink().setVisible(false);
         new User_instruction().setVisible(false);
         new User_helpline().setVisible(false);
         new User_profile(aadharnumber).setVisible(false);
      }

      if (e.getSource() == profile) {
         new User_profile(aadharnumber).setVisible(true);
      }
      if (e.getSource() == qcenter) {
         new User_quarantinecenter().setVisible(true);
      }
      if (e.getSource() == password) {
         new User_changepassword(aadharnumber).setVisible(true);
      }
      if (e.getSource() == logout) {

         int logoutvalue = JOptionPane.showConfirmDialog(null, "Are you sure to logout ?");

         if (logoutvalue == JOptionPane.YES_OPTION) {
            SwingUtilities.windowForComponent((Component) e.getSource()).dispose();
            new ChoiceLogin().setVisible(true);

         } else {
            this.setVisible(true);
         }

      }

   }
}
