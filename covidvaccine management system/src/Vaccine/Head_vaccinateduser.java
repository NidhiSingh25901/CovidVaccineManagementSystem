package Vaccine;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.sql.PreparedStatement;
import java.awt.event.*;
import java.sql.ResultSet;

public class Head_vaccinateduser extends JFrame implements ActionListener {

    public static void main(String[] args) {

        new Head_vaccinateduser().setVisible(true);
    }

    JTable table;
    DefaultTableModel defaultTableModel;
    JTextField numbertext;
    JButton okbutton;

    public Head_vaccinateduser() {

        // frame sizing and styling
        setBounds(500, 150, 760, 600);
        setResizable(false);
        setUndecorated(true);
        setBackground(new Color(50, 57, 64, 250));
        setLayout(null);

        // heading
        JLabel vaccinateduserlist = new JLabel("<html><strong><u>Vaccinated User List</u></strong></html>");
        vaccinateduserlist.setBounds(220, 90, 550, 30);
        vaccinateduserlist.setForeground(Color.white);
        vaccinateduserlist.setFont(new Font("Thaoma", Font.BOLD, 28));
        add(vaccinateduserlist);

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

        defaultTableModel.addColumn("BENEFICIARY NAME");
        defaultTableModel.addColumn("AADHAR NUMBER");

        try {

            Conn con = new Conn();
            String sql = "SELECT * FROM usersignup WHERE dose='1'";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                String aadhar = rs.getString(4);
                String[] tbdata = { name, aadhar };
                DefaultTableModel defaultable = (DefaultTableModel) table.getModel();
                defaultable.addRow(tbdata);
            }

        } catch (Exception e) {

        }

        // vaccinated user title
        JLabel number = new JLabel("NUMBER OF VACCINATED USERS:");
        number.setBounds(200, 390, 400, 25);
        number.setForeground(Color.white);
        number.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(number);

        // vaccinated user fetched data from the database
        numbertext = new JTextField();
        numbertext.setBounds(300, 450, 80, 25);
        numbertext.setForeground(Color.white);
        numbertext.setBackground(new Color(50, 57, 64, 250));
        numbertext.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(numbertext);

        // ok button
        okbutton = new JButton("OK");
        okbutton.setBounds(300, 500, 130, 30);
        okbutton.setForeground(Color.white);
        okbutton.setBackground(Color.blue);
        okbutton.addActionListener(this);
        add(okbutton);

        try {
            Conn con = new Conn();
            PreparedStatement st = null;
            ResultSet rs = null;
            int a = 1;
            String vaccusersql = "SELECT count(*) FROM usersignup WHERE dose='" + a + "'";
            st = con.c.prepareStatement(vaccusersql);
            rs = st.executeQuery();
            rs.next();
            int vaccinateduser = rs.getInt(1);
            numbertext.setText(String.valueOf(vaccinateduser));
        } catch (Exception e) {

        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okbutton) {
            this.setVisible(false);
        }
    }

}
