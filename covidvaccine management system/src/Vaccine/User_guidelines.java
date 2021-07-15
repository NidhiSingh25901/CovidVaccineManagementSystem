package Vaccine;

import javax.swing.*;

// import jdk.jfr.events.ActiveRecordingEvent;

import java.awt.*;
import java.net.URI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.event.*;

public class User_guidelines extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new User_guidelines().setVisible(true);
    }

    JButton okbutton;

    public User_guidelines() {

        // setting frame size and styling
        setBounds(500, 150, 760, 600);
        setResizable(false);
        setUndecorated(true);
        setBackground(new Color(34, 54, 86, 250));
        setLayout(null);

        // heading
        JLabel implinkhead = new JLabel("<html><u>Covid Guidelines</u></html>");
        implinkhead.setBounds(250, 70, 550, 30);
        implinkhead.setForeground(Color.white);
        implinkhead.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(implinkhead);

        // line 1
        JLabel guideline = new JLabel("Stay Home Stay Safe, Let us unite together and win covid");
        guideline.setForeground(Color.white);
        guideline.setFont(new Font("Tahoma", Font.BOLD, 17));
        guideline.setBounds(130, 130, 550, 30);
        add(guideline);

        // image
        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/wash.jpg"));
        Image imgicon = imageicon.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
        ImageIcon setimgicon = new ImageIcon(imgicon);
        JLabel headicon = new JLabel(setimgicon);
        headicon.setBounds(140, 180, 130, 130);
        add(headicon);

        // image
        ImageIcon washhand = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/sanitizer.jpg"));
        Image handicon = washhand.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
        ImageIcon washhandicon = new ImageIcon(handicon);
        JLabel washhandsicon = new JLabel(washhandicon);
        washhandsicon.setBounds(300, 180, 130, 130);
        add(washhandsicon);

        // image
        ImageIcon home = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/stayhome.jpg"));
        Image homeicon = home.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
        ImageIcon stayhomeicon = new ImageIcon(homeicon);
        JLabel safeicon = new JLabel(stayhomeicon);
        safeicon.setBounds(470, 180, 130, 130);
        add(safeicon);

        // instructions
        JLabel instr1 = new JLabel("Try to be at home , go out if very necessary");
        instr1.setForeground(Color.white);
        instr1.setFont(new Font("Tahoma", Font.BOLD, 16));
        instr1.setBounds(190, 330, 700, 18);
        add(instr1);

        JLabel instr2 = new JLabel("Use sanitizer regularly and don't forget to wear your masks");
        instr2.setForeground(Color.white);
        instr2.setFont(new Font("Tahoma", Font.BOLD, 16));
        instr2.setBounds(150, 350, 700, 18);
        add(instr2);

        JLabel instr3 = new JLabel("Wash you hands regularly and maintain social distance in crowd");
        instr3.setForeground(Color.white);
        instr3.setFont(new Font("Tahoma", Font.BOLD, 16));
        instr3.setBounds(130, 370, 700, 18);
        add(instr3);

        JLabel download = new JLabel("Click the below link to read the complete covid19 guidelines. ");
        download.setForeground(Color.white);
        download.setFont(new Font("Tahoma", Font.BOLD, 16));
        download.setBounds(130, 432, 700, 18);
        add(download);

        // covid guidelines pdf
        JLabel ukcovid = new JLabel("<html><u>Important guidelines to be followed.</u></html>");
        ukcovid.setForeground(Color.white);
        ukcovid.setFont(new Font("Tahoma", Font.BOLD, 17));
        ukcovid.setBounds(200, 460, 500, 50);
        ukcovid.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ukcovid.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(
                            new URI("https://www.mohfw.gov.in/pdf/FinalGuidanceonMangaementofCovidcasesversion2.pdf"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });
        add(ukcovid);

        okbutton = new JButton("OK");
        okbutton.setBounds(300, 550, 70, 26);
        okbutton.setBackground(Color.blue);
        okbutton.setForeground(Color.white);
        okbutton.addActionListener(this);
        add(okbutton);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okbutton) {
            this.setVisible(false);
        }
    }
}
