package Vaccine;

import javax.swing.*; 
import java.awt.*; 
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.sql.*;
import java.awt.event.*;
public class Head_quarantinecenter extends JFrame implements ActionListener{
   
    public static void main(String[] args) {
          new Head_quarantinecenter().setVisible(true);
    }  
 
    JTable table; 
    DefaultTableModel defaultTableModel; 
    JTextField centernametext,centerblocktext;
    JButton addcenter,removecenter,okbutton;

    public Head_quarantinecenter() {

        //frame sizing and styling
        setBounds(500,150,760,600);
        setResizable(false);
        setUndecorated(true);
        setBackground(new Color(50,57,64,250));
        setLayout(null);

        //heading title
        JLabel qcenterhead = new JLabel("<html><u>QUARANTINE CENTER</u></html>");
        qcenterhead.setBounds(200,110,550,30);
        qcenterhead.setForeground(Color.white);
        qcenterhead.setFont(new Font("Tahoma",Font.BOLD,25));
        add(qcenterhead); 

        //table for displaying data from the database
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setBounds(100,180,470,370);
        table.setRowHeight(25);
        table.setFont(new Font("Thaoma",Font.BOLD,15));
        table.setEnabled(false);

        JTableHeader header = table.getTableHeader();
        header.setForeground(Color.white);
        header.setBackground(Color.black);
        header.setFont(new Font("Tahoma", Font.BOLD,21));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(100,150,570,200);
        add(sp);

        defaultTableModel.addColumn("Center");
        defaultTableModel.addColumn("Block");

        try { 

            Conn con = new Conn();
            String sql = "SELECT * FROM quarantinecenter";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String centername = rs.getString(2);
                String block = rs.getString(3);
                String[] tbdata = {centername,block};
                DefaultTableModel defaulttable = (DefaultTableModel)table.getModel();
                defaulttable.addRow(tbdata);
            }
        } catch(Exception e) {

        }

        // center name title to be added
        JLabel centernamehead = new JLabel("CENTER NAME");
        centernamehead.setBounds(100,400,400,20);
        centernamehead.setForeground(Color.white);
        centernamehead.setFont(new Font("tahoma", Font.BOLD,25));
        add(centernamehead);

        // center name textfield to be added
        centernametext = new JTextField();
        centernametext.setBounds(300,400,360,21);
        centernametext.setForeground(Color.black);
        centernametext.setFont(new Font("Tahoma", Font.BOLD,10));
        add(centernametext);

        // block title to be added
        JLabel blockhead = new JLabel("BLOCK");
        blockhead.setBounds(100,450,400,20);
        blockhead.setForeground(Color.white);
        blockhead.setFont(new Font("Tahoma",Font.BOLD,25));
        add(blockhead);

        //block textfield to be added
        centerblocktext = new JTextField();
        centerblocktext.setBounds(300,450,360,20);
        centerblocktext.setFont(new Font("Tahoma",Font.BOLD,10));
        add(centerblocktext); 

        //add center button
        addcenter = new JButton("ADD CENTER");
        addcenter.setBounds(100,500,130,30);
        addcenter.setForeground(Color.white);
        addcenter.setBackground(Color.blue);
        addcenter.addActionListener(this);
        add(addcenter);

        //remove center button
        removecenter = new JButton("REMOVE CENETR");
        removecenter.setBounds(300,500,130,30);
        removecenter.setForeground(Color.white);
        removecenter.setBackground(Color.blue);
        removecenter.setFont(new Font("Tahoma",Font.BOLD,10));
        removecenter.addActionListener(this);
        add(removecenter); 

        //ok button
        okbutton = new JButton("OK");
        okbutton.setBounds(500,500,130,30);
        okbutton.setForeground(Color.white);
        okbutton.setBackground(Color.blue);
        okbutton.addActionListener(this);
        add(okbutton);
    } 

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addcenter) { 
            String name = centernametext.getText();
            String block = centerblocktext.getText();

            if(name.equals("") || block.equals("")) {
                JOptionPane.showMessageDialog(null,"Enter details to proceed");
            } else {
            try {
             Conn con = new Conn();
             String centername = centernametext.getText();
             String blockname = centerblocktext.getText();
            String fetchsql = "SELECT * FROM quarantinecenter WHERE name='"+centername+"' AND block='"+blockname+"'";
            PreparedStatement fetchst = con.c.prepareStatement(fetchsql);
            ResultSet fetchrs = fetchst.executeQuery();
            if(fetchrs.next()) {
                JOptionPane.showMessageDialog(null,"Center is already added");
            } else {
                String sql = "INSERT INTO quarantinecenter(name,block) VALUES(?,?)";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1,centernametext.getText());
                st.setString(2,centerblocktext.getText()); 
                int i = st.executeUpdate();
                if(i>0) {
                    JOptionPane.showMessageDialog(null,"Center has been added successfully");
                    this.setVisible(false);
                    new Head_quarantinecenter().setVisible(true);
                } 
                centernametext.setText("");
                centerblocktext.setText("");
            }
            } catch(Exception e1) {

            } 
        }
        } 

        if(e.getSource()==removecenter) {
            String name = centernametext.getText();
            String block = centerblocktext.getText();

            if(name.equals("") || block.equals("")) {
                JOptionPane.showMessageDialog(null,"Please enter all the fields");
            } else { 
                try { 
                     
                    Conn con = new Conn();
                    String centername = centernametext.getText();
                    String blockname = centerblocktext.getText(); 
                    String sql1 = "SELECT * FROM quarantinecenter WHERE name='"+centername+"' AND block='"+blockname+"'";
                    PreparedStatement st1 = con.c.prepareStatement(sql1);
                    ResultSet rs = st1.executeQuery();
                    if(rs.next()) {
                    String sql = "DELETE FROM quarantinecenter WHERE name='"+centername+"' AND block='"+blockname+"'";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Center has been removed successfully");
                    this.setVisible(false);
                    new Head_quarantinecenter().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null,"Check your center name and block name");
                    }
                } catch (Exception e1) {

                }
            } 


        }  

        if(e.getSource() == okbutton) {
            this.setVisible(false);
        }
        
    }
}
