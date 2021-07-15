package Vaccine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.sql.*;

public class Update_Slot extends JFrame implements ActionListener {
  public static void main(String[] args) {
    new Update_Slot("").setVisible(true);
  }

  JButton backbutton, updatebutton, logout;
  String username, password, adminid;
  JTextField centercodetext, slotsavatext;
  String center[] = new String[10];
  String centerid[] = new String[10];
  String age[] = new String[10];
  String slot[] = new String[10];
  DefaultTableModel defaultTableModel;
  JTable table;

  public Update_Slot(String adminid) {

    this.adminid = adminid;

    //frame size 
    setBounds(500,150,860,600);
    setResizable(false); 
    setUndecorated(true);
    setTitle("Admin - Update Slots");

    // panel 
    JPanel panel = new JPanel();
    panel.setBounds(0, 0, 1950, 1000);
    panel.setSize(1950, 1000);
    panel.setLayout(null);
    panel.setBackground(new Color(153, 51, 83));
    add(panel);

    
    // table title
    JLabel tabletitle = new JLabel("UPDATE SLOT NUMBER");
    tabletitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
    tabletitle.setBounds(230, 80, 600, 30); 
    tabletitle.setForeground(Color.white);
    panel.add(tabletitle);

    // slot table
    defaultTableModel = new DefaultTableModel();
    table = new JTable(defaultTableModel);
    table.setBackground(Color.WHITE);
    table.setBounds(100, 180, 700, 370);
    table.setRowHeight(25);
    table.setFont(new Font("Tahoma", Font.BOLD, 15));
    table.setEnabled(false); 

 //   panel.add(table); 
    JTableHeader header = table.getTableHeader();
    header.setBackground(Color.black);
    header.setForeground(Color.white);
    header.setFont(new Font("Tahoma", Font.BOLD, 15));

    JScrollPane sp = new JScrollPane(table);
    sp.setBounds(50,150,750,200);
    panel.add(sp);

    defaultTableModel.addColumn("S. NO.");
    defaultTableModel.addColumn("CENTER ID");
    defaultTableModel.addColumn("CENTER");
    defaultTableModel.addColumn("AGE GROUP");
    defaultTableModel.addColumn("SLOTS"); 


    try {
      Conn conn = new Conn();
      String sql = "SELECT * FROM vaccineslot";
      PreparedStatement st = conn.c.prepareStatement(sql);
      ResultSet rs = st.executeQuery();
      int i = 1;
      while (rs.next()) {
        String count = String.valueOf(i);
        String centerid = rs.getString(2);
        String center = rs.getString(3);
        String age = rs.getString(4) + "+";
        String slot = String.valueOf(rs.getInt(5));
        String[] tbdata = { count, centerid, center, age, slot };
        DefaultTableModel abc = (DefaultTableModel) table.getModel();
        abc.addRow(tbdata);
        i++;
      }
    } catch (Exception e) {

    }

    // update title
    JLabel updatetitle = new JLabel("UPDATE FORM FOR SLOTS");
    updatetitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    panel.add(updatetitle);

    // center id (title)
    JLabel centercode = new JLabel("ENTER CENTER ID :"); 
    centercode.setForeground(Color.white);
    centercode.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    centercode.setBounds(110, 400, 800, 30);
    panel.add(centercode);

    // center id (textfield)
    centercodetext = new JTextField();
    centercodetext.setForeground(Color.BLACK);
    centercodetext.setBounds(380, 400, 300, 30);
    panel.add(centercodetext);

    // slots update -- title
    JLabel slotsava = new JLabel("UPDATE SLOT NUMBER :"); 
    slotsava.setForeground(Color.white);
    slotsava.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    slotsava.setBounds(110, 440, 300, 30);
    panel.add(slotsava);

    //slot update textfield
    slotsavatext = new JTextField();
    slotsavatext.setForeground(Color.BLACK);
    slotsavatext.setBounds(380, 440, 300, 30);
    panel.add(slotsavatext);

    // update button
    updatebutton = new JButton("UPDATE");
    updatebutton.setBackground(Color.WHITE);
    updatebutton.setFont(new Font("Tahoma", Font.BOLD, 13));
    updatebutton.setBounds(240, 490, 150, 30);
    updatebutton.addActionListener(this);
    panel.add(updatebutton);

    // back button
    backbutton = new JButton("OK");
    backbutton.setBackground(Color.WHITE);
    backbutton.setFont(new Font("Tahoma", Font.BOLD, 13));
    backbutton.setBounds(550, 490, 100, 30);
    backbutton.addActionListener(this);
    panel.add(backbutton);

    // logout button
    logout = new JButton("LOGOUT");
    logout.setBackground(Color.WHITE);
    logout.setFont(new Font("Tahoma", Font.BOLD, 13));
    logout.setBounds(800, 600, 200, 50);
    logout.addActionListener(this);
    panel.add(logout);
  }

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == backbutton) {
       this.setVisible(false);
    }

    if (e.getSource() == logout) {
      int logoutvalue = JOptionPane.showConfirmDialog(null, "Are you sure to logout ?");
      if (logoutvalue == JOptionPane.YES_OPTION) {
        dispose();
        new ChoiceLogin().setVisible(true);
      } else 
        this.setVisible(true);
    }
    if (e.getSource() == updatebutton) {
      try {
        Conn conn = new Conn();
        String sql = "SELECT * FROM vaccineslot WHERE centerid='" + centercodetext.getText() + "'";
        PreparedStatement st = conn.c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        if (rs.next()) {
          String sql2 = "UPDATE vaccineslot SET slot = '" + slotsavatext.getText() + "' WHERE centerid='" + centercodetext.getText() + "'";
          PreparedStatement st2 = conn.c.prepareStatement(sql2);
          st2.executeUpdate();
          ResultSet rs2 = st.executeQuery();
          if(rs2.next()) {
            JOptionPane.showMessageDialog(null, "SUCCESSFULLY UPDATED.");
            this.setVisible(false);
            new Update_Slot("").setVisible(true);
        }
          else{
            JOptionPane.showMessageDialog(null, "FAILED TO UPDATE."); 
             
              } 
        } else {
            JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID CENTER CODE."); 
        }
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
  }
}