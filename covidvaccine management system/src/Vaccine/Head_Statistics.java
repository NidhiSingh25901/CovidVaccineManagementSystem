package Vaccine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;

public class Head_Statistics extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new Head_Statistics().setVisible(true);
    }

    JButton okbutton;

    public Head_Statistics() {

        // setting frame size and style
        setBounds(500, 150, 760, 600);
        setResizable(false);
        setUndecorated(true);
        setBackground(new Color(50, 57, 64, 250));
        setLayout(null);

        // statistic heading
        JLabel statistics = new JLabel("<html><u>STATISTICS</u></html>");
        statistics.setBounds(250, 110, 550, 30);
        statistics.setForeground(Color.white);
        statistics.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(statistics);

        // registered user title
        JLabel registereduser = new JLabel("Registered User");
        registereduser.setBounds(190, 170, 550, 28);
        registereduser.setForeground(Color.white);
        registereduser.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(registereduser);

        // registered number fetched from database
        JTextField registerednumber = new JTextField();
        registerednumber.setEditable(false);
        registerednumber.setBounds(400, 170, 100, 28);
        registerednumber.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(registerednumber);

        // vaccinated user title
        JLabel vaccinateduser = new JLabel("Vaccinateed User");
        vaccinateduser.setBounds(190, 230, 550, 28);
        vaccinateduser.setForeground(Color.white);
        vaccinateduser.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(vaccinateduser);

        // vaccinated user fetched from database
        JTextField vaccinatednumber = new JTextField();
        vaccinatednumber.setEditable(false);
        vaccinatednumber.setBounds(400, 230, 100, 28);
        vaccinatednumber.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(vaccinatednumber);

        // unvaccinated user title
        JLabel Unvaccinatedduser = new JLabel("Unvaccianted User");
        Unvaccinatedduser.setBounds(190, 290, 550, 28);
        Unvaccinatedduser.setForeground(Color.white);
        Unvaccinatedduser.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(Unvaccinatedduser);

        // unvaccinated user fetched from the database
        JTextField unvaccinatedno = new JTextField();
        unvaccinatedno.setEditable(false);
        unvaccinatedno.setBounds(400, 290, 100, 28);
        unvaccinatedno.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(unvaccinatedno);

        // vaccination center title
        JLabel vaccinationcenter = new JLabel("Vaccination Center");
        vaccinationcenter.setBounds(190, 350, 550, 28);
        vaccinationcenter.setForeground(Color.white);
        vaccinationcenter.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(vaccinationcenter);

        // vaccination center fetched from the database
        JTextField vaccinationcenterno = new JTextField();
        vaccinationcenterno.setEditable(false);
        vaccinationcenterno.setBounds(400, 350, 100, 28);
        vaccinationcenterno.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(vaccinationcenterno);

        // quarantine center title
        JLabel quarantinecenter = new JLabel("Quarantine Center");
        quarantinecenter.setBounds(190, 410, 550, 28);
        quarantinecenter.setForeground(Color.white);
        quarantinecenter.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(quarantinecenter);

        // quarantine center fetched from the database
        JTextField quarantinecenterno = new JTextField();
        quarantinecenterno.setEditable(false);
        quarantinecenterno.setBounds(400, 410, 100, 28);
        quarantinecenterno.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(quarantinecenterno);

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
            String sql = "SELECT count(*) FROM usersignup";
            st = con.c.prepareStatement(sql);
            rs = st.executeQuery();
            rs.next();
            int numberofrows = rs.getInt(1);
            registerednumber.setText(String.valueOf(numberofrows));

        } catch (Exception e) {

        }
        try {
            Conn con = new Conn();
            PreparedStatement st1 = null;
            ResultSet rs1 = null;
            int a = 1;
            String vaccusersql = "SELECT count(*) FROM usersignup WHERE dose='" + a + "'";
            st1 = con.c.prepareStatement(vaccusersql);
            rs1 = st1.executeQuery();
            rs1.next();
            int vaccinatedno = rs1.getInt(1);
            vaccinatednumber.setText(String.valueOf(vaccinatedno));
        } catch (Exception e) {

        }
        try {

            Conn con = new Conn();
            PreparedStatement st2 = null;
            ResultSet rs2 = null;
            int b = 1, c = 0;
            String regusersql = "SELECT count(*) FROM usersignup WHERE status='" + b + "' AND dose='" + c + "'";
            st2 = con.c.prepareStatement(regusersql);
            rs2 = st2.executeQuery();
            rs2.next();
            int unvaccinednno = rs2.getInt(1);
            unvaccinatedno.setText(String.valueOf(unvaccinednno));
        } catch (Exception e) {

        }

        try {

            Conn con = new Conn();
            PreparedStatement st = null;
            ResultSet rs = null;
            String sql = "SELECT count(*) FROM vaccineslot";
            st = con.c.prepareStatement(sql);
            rs = st.executeQuery();
            rs.next();
            int numberofrows = rs.getInt(1);
            vaccinationcenterno.setText(String.valueOf(numberofrows));

        } catch (Exception e) {

        }

        try {
            Conn con = new Conn();
            PreparedStatement st = null;
            ResultSet rs = null;
            String sql = "SELECT count(*) FROM quarantinecenter";
            st = con.c.prepareStatement(sql);
            rs = st.executeQuery();
            rs.next();
            int qcenter = rs.getInt(1);
            quarantinecenterno.setText(String.valueOf(qcenter));

        } catch (Exception e) {

        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okbutton) {
            this.setVisible(false);
        }
    }

}
