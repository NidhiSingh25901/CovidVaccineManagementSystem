package Vaccine; 

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.*;
import java.sql.*; 

public class Head_registereduser extends JFrame implements ActionListener{
    
    public static void main(String[] args) {
      new Head_registereduser().setVisible(true);
    }  

    JTable table;
    DefaultTableModel defaultTableModel;
    JButton okbutton;
    JTextField numbertext;

    public Head_registereduser() {

        //frame sizing and styling
        setBounds(500,150,760,600);
        setResizable(false);
        setUndecorated(true);
        setBackground(new Color(50,57,64,250));
        setLayout(null); 

        //heading
        JLabel registereduser = new JLabel("<html><u>Registered User In CVMS</u></html>");
        registereduser.setBounds(220,90,550,30);
        registereduser.setForeground(Color.white);
        registereduser.setFont(new Font("Tahoma", Font.BOLD,28));
        add(registereduser);

        //table that displays data from the database
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setBounds(100,180,470,370);
        table.setRowHeight(25);
        table.setFont(new Font("Thaoma",Font.BOLD,21));
        table.setEnabled(false); 

        JTableHeader header = table.getTableHeader();
        header.setForeground(Color.white);
        header.setBackground(Color.black);
        header.setFont(new Font("Tahoma", Font.BOLD,21));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(100,150,570,200);
        add(sp);

        defaultTableModel.addColumn("Username");
        defaultTableModel.addColumn("Aadhar No.");
        defaultTableModel.addColumn("Phone No."); 

        try {
            Conn con = new Conn();
            String sql = "SELECT * FROM usersignup"; 
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String name = rs.getString(2);
                String aadhar = rs.getString(4);
                String phone = rs.getString(3);
                String[] tbdata = {name,aadhar,phone};
                DefaultTableModel defaultable = (DefaultTableModel)table.getModel();
                defaultable.addRow(tbdata);
            }
        } catch (Exception e) {

        } 

        //number of registered user title
        JLabel number = new JLabel("Number of Registered User");
        number.setBounds(100,440,500,30);
        number.setForeground(Color.white);
        number.setFont(new Font("Tahoma", Font.BOLD,20));
        add(number);

        //number textfield that displays number to be displayed from the database
        numbertext = new JTextField();
        numbertext.setBounds(250,480,200,30);
        numbertext.setForeground(Color.white);
        numbertext.setBackground(new Color(50,57,64,250)); 
        numbertext.setFont(new Font("Tahoma", Font.BOLD,20));
        add(numbertext);

        //ok button
        okbutton = new JButton("OK");
        okbutton.setBounds(300,520,70,30);
        okbutton.setForeground(Color.white);
        okbutton.setBackground(Color.blue);
        okbutton.setFont(new Font("TAHOMA",Font.BOLD,20));
        okbutton.addActionListener(this);
        add(okbutton);

        try{
            Conn con = new Conn(); 
            PreparedStatement st = null;
            ResultSet rs  = null;
            String sql = "SELECT count(*) FROM usersignup";
            st = con.c.prepareStatement(sql);
            rs = st.executeQuery();
            rs.next();
            int registeredno = rs.getInt(1);
            numbertext.setText(String.valueOf(registeredno));      
        } catch (Exception e1) {

        }

    }  

    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == okbutton) {
               this.setVisible(false);
            }
    }

}
