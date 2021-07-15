package Vaccine;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.*;
import java.awt.event.*;

public class SlotBooking extends JFrame implements ActionListener {

  public static void main(String[] args) {
    new SlotBooking("", "").setVisible(true);
  }

  String username;
  String aadharvalue;
  String yobvalue;
  String agevalue;
  int tempage;
  JTable table;
  int ageforslot;
  String statushead;
  String vaccinatefinal = "You are Vaccinated but dont forget to stay protected";
  JButton center1, center2, center3, center4, center5, selecthead;
  DefaultTableModel defaultTableModel;
  JLabel underage;

  public SlotBooking(String username, String aadharvalue) {

    this.username = username;
    this.aadharvalue = aadharvalue;

    userDetails(aadharvalue); // calling function

    // setting frame size
    setLayout(null);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setResizable(false);

    ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/slotBooking-bg.jpg"));
    Image backgroundimg = img.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
    ImageIcon setimg = new ImageIcon(backgroundimg);
    JLabel screen = new JLabel(setimg);
    screen.setBounds(0, 0, 1950, 1000);
    add(screen);

    // name fields (title)
    JLabel name = new JLabel("NAME:");
    name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
    name.setForeground(Color.black);
    name.setBackground(Color.orange);
    name.setBounds(150, 90, 300, 30);
    screen.add(name);

    // name field (textfield)
    JTextField nametext = new JTextField(username);
    nametext.setEnabled(false);
    nametext.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    nametext.setForeground(Color.white);
    nametext.setBackground(Color.black);
    nametext.setBounds(410, 90, 300, 30);
    screen.add(nametext);

    // year of birth field (title)
    JLabel yob = new JLabel("YEAR OF BIRTH :");
    yob.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
    yob.setBounds(150, 140, 300, 30);
    yob.setBackground(Color.orange);
    yob.setForeground(Color.black);
    screen.add(yob);

    // year of birth (textfield)
    JTextField yobtext = new JTextField(yobvalue);
    yobtext.setEnabled(false);
    yobtext.setForeground(Color.white);
    yobtext.setBackground(Color.black);
    yobtext.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    yobtext.setBounds(410, 140, 300, 30);
    screen.add(yobtext);

    // age field (title)
    JLabel age = new JLabel("AGE :");
    age.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
    age.setBounds(150, 190, 300, 30);
    age.setForeground(Color.black);
    age.setBackground(Color.black);
    screen.add(age);

    // age field (textfield)
    JTextField agetext = new JTextField(agevalue);
    agetext.setEnabled(false);
    agetext.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    agetext.setForeground(Color.white);
    agetext.setBackground(Color.black);
    agetext.setBounds(410, 190, 300, 30);
    screen.add(agetext);

    this.ageforslot = Integer.valueOf(agevalue);

    // table for displaying center and slot details
    defaultTableModel = new DefaultTableModel();
    table = new JTable(defaultTableModel);
    table.setBounds(300, 180, 470, 370);
    table.setRowHeight(47);
    table.setFont(new Font("Tahoma", Font.BOLD, 15));
    table.setEnabled(false);

    JTableHeader header = table.getTableHeader();
    header.setForeground(Color.WHITE);
    header.setBackground(Color.black);
    header.setFont(new Font("Tahoma", Font.BOLD, 35));

    JScrollPane sp = new JScrollPane(table);
    sp.setBounds(300, 270, 700, 290);
    screen.add(sp);

    defaultTableModel.addColumn("CENTER");
    defaultTableModel.addColumn("SLOT");
    int agegroup = calcAgeGroup(tempage);
    try {
      Conn conn = new Conn();

      String sql = "SELECT * FROM vaccineslot WHERE age='" + agegroup + "'";
      PreparedStatement st = conn.c.prepareStatement(sql);
      ResultSet rs = st.executeQuery();
      while (rs.next()) {

        String center = rs.getString(3);
        String slot = String.valueOf(rs.getInt(5));
        String[] tbdata = { center, slot };
        // JOptionPane.showMessageDialog(null,tbdata);

        DefaultTableModel abc = (DefaultTableModel) table.getModel();
        abc.addRow(tbdata);

      }
    } catch (Exception e) {

    }

    // buttons
    selecthead = new JButton("SELECT");
    selecthead.setBounds(1000, 270, 290, 47);
    selecthead.setBackground(Color.black);
    selecthead.setForeground(Color.white);
    selecthead.setFont(new Font("Tahoma", Font.BOLD, 35));
    screen.add(selecthead);

    center1 = new JButton("SELECT");
    center1.setBounds(1000, 320, 290, 47);
    center1.setBackground(Color.red);
    center1.setForeground(Color.black);
    center1.addActionListener(this);
    screen.add(center1);

    center2 = new JButton("SELECT");
    center2.setBounds(1000, 367, 290, 47);
    // center2.setBounds(0,0,290,47);
    center2.setBackground(Color.red);
    center2.setForeground(Color.black);
    center2.addActionListener(this);

    screen.add(center2);

    center3 = new JButton("SELECT");
    center3.setBounds(1000, 418, 290, 47);
    center3.setBackground(Color.red);
    center3.setForeground(Color.black);
    center3.addActionListener(this);
    screen.add(center3);

    center4 = new JButton("SELECT");
    center4.setBounds(1000, 465, 290, 47);
    center4.setBackground(Color.red);
    center4.setForeground(Color.black);
    center4.addActionListener(this);
    screen.add(center4);

    center5 = new JButton("SELECT");
    center5.setBounds(1000, 513, 290, 47);
    center5.setBackground(Color.red);
    center5.setForeground(Color.black);
    center5.addActionListener(this);
    screen.add(center5);

    JLabel vaccinate = new JLabel(statushead);
    vaccinate.setBounds(500, 550, 300, 30);
    vaccinate.setForeground(Color.black);

    try {
      Conn con = new Conn();
      String sql = "SELECT * FROM usersignup WHERE aadhar='" + aadharvalue + "'";
      PreparedStatement st = con.c.prepareStatement(sql);
      ResultSet rs = st.executeQuery();
      while (rs.next()) {
        int statusvalue = rs.getInt(6);

        if (statusvalue == 1) {
          this.statushead = vaccinatefinal;
        }
      }

    } catch (Exception e) {

    }

    underage = new JLabel();
    underage.setBounds(30, 600, 1700, 80);
    underage.setForeground(Color.orange);
    underage.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
    screen.add(underage);

    if (ageforslot < 18) {
      underage.setText("Slot are not available for those whose age is below 18");
    }
  }

  void userDetails(String aadharvalue) {
    try {
      Conn conn = new Conn();
      String sql = "SELECT * FROM usersignup WHERE aadhar='" + aadharvalue + "'";
      PreparedStatement st = conn.c.prepareStatement(sql);

      ResultSet rs = st.executeQuery();
      while (rs.next()) {
        yobvalue = rs.getString(5);
        int tempyob = Integer.valueOf(yobvalue);
        tempage = 2021 - tempyob;
        agevalue = String.valueOf(tempage);
        this.ageforslot = tempage;
      }
    } catch (Exception e1) {
      e1.printStackTrace();
    }
  }

  // function to calculate age group
  int calcAgeGroup(int age) {
    int agegroup = 0;
    if (age >= 18 && age < 45)
      agegroup = 18;
    else if (age >= 45)
      agegroup = 45;
    return agegroup;
  }

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == center1) {

      if (ageforslot >= 18 && ageforslot < 45) {

        // JOptionPane.showMessageDialog(null,"Booking Slot");
        try {
          Conn con = new Conn();
          String sql = "SELECT * FROM vaccineslot WHERE id='1'";
          PreparedStatement st = con.c.prepareStatement(sql);
          ResultSet rs = st.executeQuery();
          while (rs.next()) {
           int slotvalue = rs.getInt(4);
            String address = rs.getString(3);
            if (slotvalue > 0) {
              int status = 1;
              int slotno = rs.getInt(4);
              slotno=slotno-1;
             // slotvalue=slotvalue-1; 
              // JOptionPane.showMessageDialog(null,slotvalue);
              con.s.executeUpdate("UPDATE vaccineslot SET slot='" + slotno + "' WHERE id='1'");
              con.s.executeUpdate("UPDATE usersignup SET status='" + status + "' WHERE aadhar='" + aadharvalue + "'");
              con.s.executeUpdate("UPDATE usersignup SET address='" + address + "' WHERE aadhar='" + aadharvalue + "'");
              JOptionPane.showMessageDialog(null,
                  "Your vaccine slot has been booked, you can go to your center to receive your vaccine");
              this.setVisible(false);
            } else {
              JOptionPane.showMessageDialog(null, "Select another slot or book on some other day");
            }
          }

        } catch (Exception se) {

        }
      }
      if (ageforslot > 45) {
        try {
          Conn con = new Conn();
          String sql = "SELECT * FROM vaccineslot WHERE id='6'";
          PreparedStatement st = con.c.prepareStatement(sql);
          ResultSet rs = st.executeQuery();
          while (rs.next()) {
            int slotvalue = rs.getInt(4);
            String address = rs.getString(3);
            if (slotvalue > 0) {
              int status = 1;
              slotvalue--;
              // JOptionPane.showMessageDialog(null,slotvalue);
              con.s.executeUpdate("UPDATE vaccineslot SET slot='" + slotvalue + "' WHERE id='6'");
              con.s.executeUpdate("UPDATE usersignup SET status='" + status + "' WHERE aadhar='" + aadharvalue + "'");
              con.s.executeUpdate("UPDATE usersignup SET address='" + address + "' WHERE aadhar='" + aadharvalue + "'");
              JOptionPane.showMessageDialog(null,
                  "Your vaccine slot has been booked, you can go to your center to receive your vaccine");
              this.setVisible(false);
            } else {
              JOptionPane.showMessageDialog(null, "Select another slot or book on some other day");
            }
          }

        } catch (Exception se) {

        }
      }

      if (ageforslot < 18) {
        JOptionPane.showMessageDialog(null,
            "Ther are no slots availabe for below 18 age...<br> We'll let you know soon..");
      }

    } // center

    if (e.getSource() == center2) {

      if (ageforslot >= 18 && ageforslot < 45) {

        // JOptionPane.showMessageDialog(null,"Booking Slot");
        try {
          Conn con = new Conn();
          String sql = "SELECT * FROM vaccineslot WHERE id='2'";
          PreparedStatement st = con.c.prepareStatement(sql);
          ResultSet rs = st.executeQuery();
          while (rs.next()) {
            int slotvalue = rs.getInt(4);
            String address = rs.getString(3);
            if (slotvalue > 0) {
              int status = 1;
              slotvalue--;
              // JOptionPane.showMessageDialog(null,slotvalue);
              con.s.executeUpdate("UPDATE vaccineslot SET slot='" + slotvalue + "' WHERE id='2'");
              con.s.executeUpdate("UPDATE usersignup SET status='" + status + "' WHERE aadhar='" + aadharvalue + "'");
              con.s.executeUpdate("UPDATE usersignup SET address='" + address + "' WHERE aadhar='" + aadharvalue + "'");
              JOptionPane.showMessageDialog(null,
                  "Your vaccine slot has been booked, you can go to your center to receive your vaccine");
              this.setVisible(false);
            } else {
              JOptionPane.showMessageDialog(null, "Select another slot or book on some other day");
            }
          }

        } catch (Exception se) {

        }
      }
      if (ageforslot >= 45) {
        try {
          Conn con = new Conn();
          String sql = "SELECT * FROM vaccineslot WHERE id='7'";
          PreparedStatement st = con.c.prepareStatement(sql);
          ResultSet rs = st.executeQuery();
          while (rs.next()) {
            int slotvalue = rs.getInt(4);
            String address = rs.getString(3);
            if (slotvalue > 0) {
              int status = 1;
              slotvalue--;
              // JOptionPane.showMessageDialog(null,slotvalue);
              con.s.executeUpdate("UPDATE vaccineslot SET slot='" + slotvalue + "' WHERE id='7'");
              con.s.executeUpdate("UPDATE usersignup SET status='" + status + "' WHERE aadhar='" + aadharvalue + "'");
              con.s.executeUpdate("UPDATE usersignup SET address='" + address + "' WHERE aadhar='" + aadharvalue + "'");
              JOptionPane.showMessageDialog(null,
                  "Your vaccine slot has been booked, you can go to your center to receive your vaccine");
              this.setVisible(false);
            } else {
              JOptionPane.showMessageDialog(null, "Select another slot or book on some other day");
            }
          }

        } catch (Exception se) {

        }
      }
      if (ageforslot < 18) {
        JOptionPane.showMessageDialog(null,
            "There is no slots availabe for below 18 age...<br> We'll let you know soon...");
      }

    } // center2

    if (e.getSource() == center3) {

      if (ageforslot >= 18 && ageforslot < 45) {

        // JOptionPane.showMessageDialog(null,"Booking Slot");
        try {
          Conn con = new Conn();
          String sql = "SELECT * FROM vaccineslot WHERE id='3'";
          PreparedStatement st = con.c.prepareStatement(sql);
          ResultSet rs = st.executeQuery();
          while (rs.next()) {
            int slotvalue = rs.getInt(4);
            String address = rs.getString(3);
            if (slotvalue > 0) {
              int status = 1;
              slotvalue--;
              // JOptionPane.showMessageDialog(null,slotvalue);
              con.s.executeUpdate("UPDATE vaccineslot SET slot='" + slotvalue + "' WHERE id='3'");
              con.s.executeUpdate("UPDATE usersignup SET status='" + status + "' WHERE aadhar='" + aadharvalue + "'");
              con.s.executeUpdate("UPDATE usersignup SET address='" + address + "' WHERE aadhar='" + aadharvalue + "'");
              JOptionPane.showMessageDialog(null,
                  "Your vaccine slot has been booked, you can go to your center to receive your vaccine");
              this.setVisible(false);
            } else {
              JOptionPane.showMessageDialog(null, "Select another slot or book on some other day");
            }
          }

        } catch (Exception se) {

        }
      }
      if (ageforslot >= 45) {
        try {
          Conn con = new Conn();
          String sql = "SELECT * FROM vaccineslot WHERE id='8'";
          PreparedStatement st = con.c.prepareStatement(sql);
          ResultSet rs = st.executeQuery();
          while (rs.next()) {
            int slotvalue = rs.getInt(4);
            String address = rs.getString(3);
            if (slotvalue > 0) {
              int status = 1;
              slotvalue--;
              // JOptionPane.showMessageDialog(null,slotvalue);
              con.s.executeUpdate("UPDATE vaccineslot SET slot='" + slotvalue + "' WHERE id='8'");
              con.s.executeUpdate("UPDATE usersignup SET status='" + status + "' WHERE aadhar='" + aadharvalue + "'");
              con.s.executeUpdate("UPDATE usersignup SET address='" + address + "' WHERE aadhar='" + aadharvalue + "'");
              JOptionPane.showMessageDialog(null,
                  "Your vaccine slot has been booked, you can go to your center to receive your vaccine");
              this.setVisible(false);
            } else {
              JOptionPane.showMessageDialog(null, "Select another slot or book on some other day");
            }
          }

        } catch (Exception se) {

        }
      }
      if (ageforslot < 18) {
        JOptionPane.showMessageDialog(null, "There is no slots availabe for below 18 age... We'll let you know soon");
      }

    } // center3

    if (e.getSource() == center4) {

      if (ageforslot >= 18 && ageforslot < 45) {

        // JOptionPane.showMessageDialog(null,"Booking Slot");
        try {
          Conn con = new Conn();
          String sql = "SELECT * FROM vaccineslot WHERE id='4'";
          PreparedStatement st = con.c.prepareStatement(sql);
          ResultSet rs = st.executeQuery();
          while (rs.next()) {
            int slotvalue = rs.getInt(4);
            String address = rs.getString(3);
            if (slotvalue > 0) {
              int status = 1;
              slotvalue--;
              // JOptionPane.showMessageDialog(null,slotvalue);
              con.s.executeUpdate("UPDATE vaccineslot SET slot='" + slotvalue + "' WHERE id='4'");
              con.s.executeUpdate("UPDATE usersignup SET status='" + status + "' WHERE aadhar='" + aadharvalue + "'");
              con.s.executeUpdate("UPDATE usersignup SET address='" + address + "' WHERE aadhar='" + aadharvalue + "'");
              JOptionPane.showMessageDialog(null,
                  "Your vaccine slot has been booked, you can go to your center to receive your vaccine");
              this.setVisible(false);
            } else {
              JOptionPane.showMessageDialog(null, "Select another slot or book on some other day");
            }
          }

        } catch (Exception se) {

        }
      }
      if (ageforslot >= 45) {
        try {
          Conn con = new Conn();
          String sql = "SELECT * FROM vaccineslot WHERE id='9'";
          PreparedStatement st = con.c.prepareStatement(sql);
          ResultSet rs = st.executeQuery();
          while (rs.next()) {
            int slotvalue = rs.getInt(4);
            String address = rs.getString(3);
            if (slotvalue > 0) {
              int status = 1;
              slotvalue--;
              // JOptionPane.showMessageDialog(null,slotvalue);
              con.s.executeUpdate("UPDATE vaccineslot SET slot='" + slotvalue + "' WHERE id='9'");
              con.s.executeUpdate("UPDATE usersignup SET status='" + status + "' WHERE aadhar='" + aadharvalue + "'");
              con.s.executeUpdate("UPDATE usersignup SET address='" + address + "' WHERE aadhar='" + aadharvalue + "'");
              JOptionPane.showMessageDialog(null,
                  "Your vaccine slot has been booked, you can go to your center to receive your vaccine");
              this.setVisible(false);
            } else {
              JOptionPane.showMessageDialog(null, "Select another slot or book on some other day");
            }
          }

        } catch (Exception se) {

        }
      }

      if (ageforslot < 18) {
        JOptionPane.showMessageDialog(null, "There is no slots availabe for below 18 age... We'll let you know soon");
      }

    } // cenetr4

    if (e.getSource() == center5) {

      if (ageforslot >= 18 && ageforslot < 45) {

        // JOptionPane.showMessageDialog(null,"Booking Slot");
        try {
          Conn con = new Conn();
          String sql = "SELECT * FROM vaccineslot WHERE id='5'";
          PreparedStatement st = con.c.prepareStatement(sql);
          ResultSet rs = st.executeQuery();
          while (rs.next()) {
            int slotvalue = rs.getInt(4);
            String address = rs.getString(3);
            if (slotvalue > 0) {
              int status = 1;
              slotvalue--;
              // JOptionPane.showMessageDialog(null,slotvalue);
              con.s.executeUpdate("UPDATE vaccineslot SET slot='" + slotvalue + "' WHERE id='5'");
              con.s.executeUpdate("UPDATE usersignup SET status='" + status + "' WHERE aadhar='" + aadharvalue + "'");
              con.s.executeUpdate("UPDATE usersignup SET address='" + address + "' WHERE aadhar='" + aadharvalue + "'");
              JOptionPane.showMessageDialog(null,
                  "Your vaccine slot has been booked, you can go to your center to receive your vaccine");
              this.setVisible(false);
            } else {
              JOptionPane.showMessageDialog(null, "Select another slot or book on some other day");
            }
          }

        } catch (Exception se) {

        }
      }

      if (ageforslot >= 45) {
        try {
          Conn con = new Conn();
          String sql = "SELECT * FROM vaccineslot WHERE id='10'";
          PreparedStatement st = con.c.prepareStatement(sql);
          ResultSet rs = st.executeQuery();
          while (rs.next()) {
            int slotvalue = rs.getInt(4);
            String address = rs.getString(3);
            if (slotvalue > 0) {
              int status = 1;
              slotvalue--;
              // JOptionPane.showMessageDialog(null,slotvalue);
              con.s.executeUpdate("UPDATE vaccineslot SET slot='" + slotvalue + "' WHERE id='10'");
              con.s.executeUpdate("UPDATE usersignup SET status='" + status + "' WHERE aadhar='" + aadharvalue + "'");
              con.s.executeUpdate("UPDATE usersignup SET address='" + address + "' WHERE aadhar='" + aadharvalue + "'");
              JOptionPane.showMessageDialog(null,
                  "Your vaccine slot has been booked, you can go to your center to receive your vaccine");
              this.setVisible(false);
            } else {
              JOptionPane.showMessageDialog(null, "Select another slot or book on some other day");
            }
          }

        } catch (Exception se) {

        }
      }
      if (ageforslot < 18) {
        JOptionPane.showMessageDialog(null, "There is no slots availabe for below 18 age... We'll let you know soon");
      }

    }

  }

}
