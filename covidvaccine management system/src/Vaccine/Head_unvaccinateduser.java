package Vaccine;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;

public class Head_unvaccinateduser extends JFrame implements ActionListener {

    public static void main(String[] args) {

        new Head_unvaccinateduser().setVisible(true);
    }

    JTable table;
    DefaultTableModel defaultTableModel;
    JTextField numbertext;
    JButton okbutton;

    public Head_unvaccinateduser() {

        // setting frame size and styling
        setBounds(500, 150, 760, 600);
        setResizable(false);
        setUndecorated(true);
        setBackground(new Color(50, 57, 64, 250));
        setLayout(null);

        // heading
        JLabel unvaccinatedlist = new JLabel("<html><u>Unvaccinated User</u></html>");
        unvaccinatedlist.setBounds(220, 90, 550, 30);
        unvaccinatedlist.setForeground(Color.white);
        unvaccinatedlist.setFont(new Font("Thaoma", Font.BOLD, 28));
        add(unvaccinatedlist);

        // table that displays data from the database
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setBounds(100, 180, 470, 370);
        table.setRowHeight(25);
        table.setFont(new Font("Tahoma", Font.BOLD, 21));
        table.setEnabled(false);

        JTableHeader header = table.getTableHeader();
        header.setForeground(Color.white);
        header.setBackground(Color.black);
        header.setFont(new Font("Tahoma", Font.BOLD, 21));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(100, 150, 570, 200);
        add(sp);

        defaultTableModel.addColumn("NAME");
        defaultTableModel.addColumn("Aadhar No.");
        defaultTableModel.addColumn("Mobile No.");

        try {

            Conn con = new Conn();
            int a = 0, b = 1;
            String sql = "SELECT * FROM usersignup WHERE dose='" + a + "' AND status='" + b + "'";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                String aadhar = rs.getString(4);
                String phone = rs.getString(3);
                String[] tbdata = { name, aadhar, phone };
                DefaultTableModel defaultable = (DefaultTableModel) table.getModel();
                defaultable.addRow(tbdata);

            }
        } catch (Exception e) {

        }

        // unvaccinated title
        JLabel unvaccinated = new JLabel("Number of Unvaccinated user who have booked the slot");
        unvaccinated.setBounds(120, 390, 700, 25);
        unvaccinated.setForeground(Color.white);
        unvaccinated.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(unvaccinated);

        JLabel unvaccinated1 = new JLabel("but haven't got vaccination.");
        unvaccinated1.setBounds(180, 420, 700, 25);
        unvaccinated1.setForeground(Color.white);
        unvaccinated1.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(unvaccinated1);

        // unvaccinated textfield that fetches from the dtabase and is displayed here
        numbertext = new JTextField();
        numbertext.setBounds(300, 470, 130, 25);
        numbertext.setForeground(Color.white);
        numbertext.setBackground(new Color(50, 57, 64, 250));
        numbertext.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(numbertext);

        // ok button
        okbutton = new JButton("OK");
        okbutton.setBounds(300, 520, 130, 30);
        okbutton.setForeground(Color.white);
        okbutton.setBackground(Color.blue);
        okbutton.addActionListener(this);
        add(okbutton);

        try {

            Conn con = new Conn();
            PreparedStatement st = null;
            ResultSet rs = null;
            int a = 0, b = 1;
            String unvacciantedsql = "SELECT count(*) FROM usersignup WHERE dose='" + a + "' AND status='" + b + "'";
            st = con.c.prepareStatement(unvacciantedsql);
            rs = st.executeQuery();
            rs.next();
            int unvaccinateduser = rs.getInt(1);
            numbertext.setText(String.valueOf(unvaccinateduser));
        } catch (Exception e) {

        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okbutton) {
            this.setVisible(false);
        }
    }
}