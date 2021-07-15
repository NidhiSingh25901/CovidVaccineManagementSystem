package Vaccine;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.sql.*;
import java.awt.event.*;

public class Head_addAdmin extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Head_addAdmin().setVisible(true);
    }

    JTable table;
    DefaultTableModel defaultTableModel;
    JButton addadmin, removeadmin, okbutton;
    JTextField adminidtext;
    JTextField nametext;
    JTextField passtext;

    public Head_addAdmin() {

        //setting frame size
        setBounds(500, 150, 760, 600);
        setResizable(false);
        setUndecorated(true);
        setBackground(new Color(50, 57, 64, 250));
        setLayout(null); 

        //add admin title
        JLabel passwordhead = new JLabel("<html><u>Add Admin</u></html>");
        passwordhead.setBounds(250, 110, 550, 30);
        passwordhead.setForeground(Color.white);
        passwordhead.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(passwordhead);

        //creating table for fetching data from database and displaying it in the table
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setBounds(100, 180, 470, 370);
        table.setRowHeight(25);
        table.setFont(new Font("Tahoma", Font.BOLD, 15));
        table.setEnabled(false);

        JTableHeader header = table.getTableHeader();
        header.setForeground(Color.white);
        header.setBackground(Color.black);
        header.setFont(new Font("Tahoma", Font.BOLD, 21));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(100, 150, 550, 200);
        add(sp);

        defaultTableModel.addColumn("ADMINID");
        defaultTableModel.addColumn("NAME");
        defaultTableModel.addColumn("PASSWORD");
 
        //fetching data from database and passing it to the defaulttable
        try {

            Conn con = new Conn();
            String sql = "SELECT * FROM adminlogin";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String adminid = rs.getString(2);
                String name = rs.getString(3);
                String password = rs.getString(4);
                String[] tbdata = { adminid, name, password };
                DefaultTableModel defaulttable = (DefaultTableModel) table.getModel();
                defaulttable.addRow(tbdata);
            }
        } catch (Exception e) {

        } 


        //admin id title to be added
        JLabel adminidhead = new JLabel("ADMIN ID");
        adminidhead.setBounds(100, 400, 400, 20);
        adminidhead.setForeground(Color.white);
        adminidhead.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(adminidhead);

        //admin id textfield to be added
        adminidtext = new JTextField();
        adminidtext.setBounds(300, 400, 200, 20);
        adminidtext.setForeground(Color.black);
        adminidtext.setFont(new Font("Tahoma", Font.BOLD, 10));
        add(adminidtext);

        //admin name title to be added
        JLabel namehead = new JLabel("ADMIN NAME");
        namehead.setBounds(100, 450, 400, 20);
        namehead.setForeground(Color.white);
        namehead.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(namehead);

        //admin name textfield to be added
        nametext = new JTextField();
        nametext.setBounds(300, 450, 200, 20);
        nametext.setForeground(Color.black);
        add(nametext);

        //admin password title to be added
        JLabel passhead = new JLabel("PASSWORD");
        passhead.setBounds(100, 500, 400, 20);
        passhead.setForeground(Color.white);
        passhead.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(passhead);

        //admin password to be added
        passtext = new JTextField();
        passtext.setBounds(300, 500, 200, 20);
        passtext.setForeground(Color.black);
        add(passtext);

        //add admin button
        addadmin = new JButton("ADD ADMIN");
        addadmin.setBounds(530, 460, 130, 30);
        addadmin.setForeground(Color.white);
        addadmin.setBackground(Color.blue);
        addadmin.addActionListener(this);
        add(addadmin);

        //remove admin button
/* removeadmin = new JButton("REMOVE ADMIN");
        removeadmin.setBounds(530, 420, 130, 30);
        removeadmin.setForeground(Color.white);
        removeadmin.setBackground(Color.blue);
        removeadmin.setFont(new Font("Tahoma", Font.BOLD, 10));
        removeadmin.addActionListener(this);
        add(removeadmin); */

        //ok button
        okbutton = new JButton("OK");
        okbutton.setBounds(530, 500, 130, 30);
        okbutton.setForeground(Color.white);
        okbutton.setBackground(Color.blue);
        okbutton.addActionListener(this);
        add(okbutton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addadmin) {

            String admintextvalue = adminidtext.getText();
            String nametextvalue = nametext.getText();
            String passtextvalue = passtext.getText();

            if (admintextvalue.equals("") || nametextvalue.equals("") || passtextvalue.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter all the fields");
            } else {
                try {
                    Conn con = new Conn();
                    String adminidvalue = adminidtext.getText();
                    String fetchsql = "SELECT * FROM adminlogin WHERE adminid='" + adminidvalue + "'";
                    PreparedStatement fetchst = con.c.prepareStatement(fetchsql);
                    ResultSet fetchrs = fetchst.executeQuery();
                    if (fetchrs.next()) {
                        JOptionPane.showMessageDialog(null, "Admin is already added");
                    } else {
                        String sql = "INSERT INTO adminlogin(adminid,name,password) VALUES(?,?,?)";
                        PreparedStatement st = con.c.prepareStatement(sql);
                        st.setString(1, adminidtext.getText());
                        st.setString(2, nametext.getText());
                        st.setString(3, passtext.getText());

                        int i = st.executeUpdate();

                        if (i > 0) {
                            JOptionPane.showMessageDialog(null, "Admin has been added to your database");
                            this.setVisible(false);
                            new Head_addAdmin().setVisible(true);
                        }
                        adminidtext.setText("");
                        nametext.setText("");
                        passtext.setText("");
                    }

                } catch (Exception excep) {

                }
            } 
        }

            /*if (e.getSource() == removeadmin) {  

             String adminidvalue = adminidtext.getText();
             if(adminidvalue.equals("")) {
                 JOptionPane.showMessageDialog(null,"Please enter adminid to delete the admin from database"); 
             } else {
                   try{
                      Conn con = new Conn(); 
                      String sql1 ="SELECT * FROM adminlogin WHERE adminid='"+adminidvalue+"'";
                      PreparedStatement st1 = con.c.prepareStatement(sql1); 
                      ResultSet rs = st1.executeQuery();
                      if(rs.next()){
                      String sql = "DELETE FROM adminlogin WHERE adminid='"+adminidvalue+"'";
                      PreparedStatement st = con.c.prepareStatement(sql);
                      st.executeUpdate();
                      JOptionPane.showMessageDialog(null,"User is deleted succeefully");
                      this.setVisible(false);
                      
                      
                      } else {
                          JOptionPane.showMessageDialog(null,"Admin id doesn't exists");
                      }
                      
                   } catch(Exception ee) {

                   }
             }
        
        } */

        if (e.getSource() == okbutton) {
            this.setVisible(false);
        } 
    }
}
