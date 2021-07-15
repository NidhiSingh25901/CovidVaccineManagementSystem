package Vaccine;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;

public class User_quarantinecenter extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new User_quarantinecenter();
    }

    JButton okbutton;
    JTable table;
    DefaultTableModel defaultTableModel;

    public User_quarantinecenter() {

        // frame size and styling
        setBounds(500, 150, 760, 600);
        setResizable(false);
        setUndecorated(true);
        setBackground(new Color(34, 54, 86, 250));
        setLayout(null);

        // vaccination center - title
        JLabel quarantinehead = new JLabel("<html><u>QUARANTINE CENTER</u></html>");
        quarantinehead.setBounds(250, 70, 550, 30);
        quarantinehead.setForeground(Color.white);
        quarantinehead.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(quarantinehead);

        // table that fetches data from the database
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setBounds(300, 100, 200, 390);
        table.setRowHeight(35);
        table.setFont(new Font("Tahoma", Font.BOLD, 15));
        table.setEnabled(false);

        JTableHeader header = table.getTableHeader();
        header.setForeground(Color.WHITE);
        header.setBackground(Color.black);
        header.setFont(new Font("Tahoma", Font.BOLD, 20));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(150, 150, 480, 360);
        add(sp);

        defaultTableModel.addColumn("Center");
        defaultTableModel.addColumn("Block");

        try {

            Conn con = new Conn();
            String sql = "SELECT * FROM quarantinecenter";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String centername = rs.getString(2);
                String block = rs.getString(3);
                String[] tbdata = { centername, block };
                DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
                defaultTableModel.addRow(tbdata);
            }

        } catch (Exception e) {

        }

        // ok button
        okbutton = new JButton("OK");
        okbutton.setBounds(300, 550, 70, 26);
        okbutton.setBackground(Color.blue);
        okbutton.setForeground(Color.white);
        okbutton.addActionListener(this);
        add(okbutton);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okbutton) {
            this.setVisible(false);
        }
    }
}
