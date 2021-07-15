package Vaccine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Admin_instruction extends JFrame implements ActionListener{
    public static void main(String[] args) {
          new Admin_instruction().setVisible(true);
    } 
    JButton okbutton;
    public Admin_instruction() { 

        // frame size and style
        setBounds(500, 150, 760, 600);
        setResizable(false);
        setUndecorated(true);
        setBackground(new Color(153, 51, 83, 250));
        setLayout(null);  


        //instruction heading
        JLabel instructionhead = new JLabel("<html><u>INSTRUCTIONS</u></html>");
        instructionhead.setBounds(250, 70, 550, 30);
        instructionhead.setForeground(Color.white);
        instructionhead.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(instructionhead);


        //instruction provided to the admin
        JLabel list = new JLabel(
                "<html><ul><li>Read the instruction carefully to get rid of unecessary hastle.</li><br><li>Click on the Book Slot option in the side bar.</li><br><li> A page will be displayed.</li><br><li>It will display your birth year provided by you at the time registeration.</li><br><li>Your calculated age will be displayed automatically</li><br><li>Enter the date when you want to take your vaccine</li><br><li>If slots are available,<br></li> you will booked and a secret code will be given.</li><br><br><li>If slots are unavailable, you will be asked to select another date and<br> will be given a secret code.</li><br><li>Keep the secret code with you and show it at the vaccination center.</li><br><li>For any grievance, you can call us at our helpline number.</li></ul></html>");
        list.setBounds(50, 0, 800, 650);
        list.setFont(new Font("Tahoma", Font.BOLD, 15));
        list.setForeground(Color.white);
        add(list); 

 
        // ok button
        okbutton = new JButton("OK");
        okbutton.setBounds(300, 550, 70, 26);
        okbutton.setBackground(new Color(153, 51, 83,60));
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
