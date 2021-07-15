package Vaccine;

import javax.swing.*;
import java.awt.*; 
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.sql.*;
import java.awt.event.*;
public class Head_displayslotcenter extends JFrame implements ActionListener{
    
    public static void main(String[] args) {
     new Head_displayslotcenter().setVisible(true);
    } 

    JTable table;
    DefaultTableModel defaultTableModel;
    JButton editslotnumber,okbutton;
    JTextField slotnumber,slotname;
    

    public Head_displayslotcenter() {

        //setting frame size
        setBounds(500,150,760,600);
        setResizable(false);
        setUndecorated(true); 
        setBackground(new Color(50,57,64,250));
        setLayout(null); 

        //heading 
        JLabel slothead = new JLabel("<html><u>Vaccination Center</u></html>");
        slothead.setBounds(250,110,550,30);
        slothead.setForeground(Color.white);
        slothead.setFont(new Font("Tahoma",Font.BOLD,25));
        add(slothead); 

        //table that displays data from database
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setBounds(100,180,470,370);
        table.setRowHeight(25);
        table.setFont(new Font("Tahoma", Font.BOLD,15));
        table.setEnabled(false);

        JTableHeader header = table.getTableHeader();
        header.setForeground(Color.white);
        header.setBackground(Color.black);
        header.setFont(new Font("Tahoma", Font.BOLD,21));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(100,150,550,200);
        add(sp); 

        defaultTableModel.addColumn("CENTER ID");
        defaultTableModel.addColumn("CENTER NAME"); 
        defaultTableModel.addColumn("Age");
        defaultTableModel.addColumn("AVAILABILITY");

        try{
    
             Conn con =new Conn();
             String sql = "SELECT * FROM vaccineslot";
             PreparedStatement st = con.c.prepareCall(sql);
             ResultSet rs = st.executeQuery();
             while(rs.next()) { 
                 String slotid = rs.getString(2);
                 String slotname = rs.getString(3); 
                 String slotage = rs.getString(4);
                 String slotnumber = rs.getString(5);
                 String[] tbdata = {slotid,slotname,slotage,slotnumber};
                 DefaultTableModel defaulttable = (DefaultTableModel)table.getModel();
                 defaulttable.addRow(tbdata);
             }
        } catch(Exception e ) {

        } 


        //center id title for adding
        JLabel name = new JLabel("CENTER ID ");
        name.setBounds(100,400,400,20);
        name.setForeground(Color.white);
        name.setFont(new Font("Tahoma",Font.BOLD,25));
        add(name); 
 
   
        // center id textfield to be added
        slotname = new JTextField();
        slotname.setBounds(300,400,200,20);
        slotname.setForeground(Color.black);
        slotname.setFont(new Font("Tahoma",Font.BOLD,10));
        add(slotname);

         // slot title to be added
        JLabel slottitle = new JLabel("SLOT NUMBER"); 
        slottitle.setBounds(100,450,400,20);
        slottitle.setForeground(Color.white);
        slottitle.setFont(new Font("tahoma", Font.BOLD, 25));
        add(slottitle);

        //alot title textfield to be added
        slotnumber = new JTextField();
        slotnumber.setBounds(300,450,200,20);
        slotnumber.setForeground(Color.black);
        slotnumber.setFont(new Font("Tahoma", Font.BOLD,10));
        add(slotnumber);

        //edit slot center button
        editslotnumber = new JButton("EDIT");
        editslotnumber.setBounds(200,490,130,30);
        editslotnumber.setForeground(Color.white);
        editslotnumber.setBackground(Color.blue);
        editslotnumber.addActionListener(this);
        add(editslotnumber);

        //ok button
        okbutton = new JButton("OK");
        okbutton.setBounds(400,490,130,30);
        okbutton.setForeground(Color.white);
        okbutton.setBackground(Color.blue);
        okbutton.addActionListener(this);
        add(okbutton);
    } 

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == editslotnumber) {

            String name = slotname.getText();
            String number = slotnumber.getText();

            if(name.equals("") || number.equals("")) {
                JOptionPane.showMessageDialog(null,"Fill all the details properly");
            }  else {

                try {
                   Conn con = new Conn();
                   String centername = slotname.getText();
                   String centernumber = slotnumber.getText();

                   String fetchsql = "SELECT * FROM vaccineslot WHERE centerid='"+centername+"'";
                   PreparedStatement fetchst = con.c.prepareStatement(fetchsql);
                   ResultSet rs = fetchst.executeQuery(); 
                   if(rs.next()) { 

                          String sql = "UPDATE vaccineslot SET slot='"+centernumber+"' WHERE centerid='"+centername+"'";
                          con.s.executeUpdate(sql);
                          JOptionPane.showMessageDialog(null,"Slot number is updated successfully");
                          this.setVisible(false);
                          new Head_displayslotcenter().setVisible(true);
                        
                   }  else {
                       JOptionPane.showMessageDialog(null,"The center does not exists");
                   }
                } catch (Exception ex) {

                }

            }
        } 

        if(e.getSource()==okbutton) {
            this.setVisible(false);
        }
    }
}
