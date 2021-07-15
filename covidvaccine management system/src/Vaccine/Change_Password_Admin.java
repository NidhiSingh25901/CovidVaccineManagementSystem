package Vaccine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Change_Password_Admin extends JFrame implements ActionListener{

    public static void main(String[] args) {
     new Change_Password_Admin("").setVisible(true);
        } 

        String adminid;
        JPasswordField newpasstext;
        JPasswordField confirmpasstext;
        JButton okbutton;

    public Change_Password_Admin(String adminid) {
         this.adminid = adminid;

        setBounds(500, 150, 760, 600);
        setResizable(false);
        setUndecorated(true);

        // setBackground(new Color(129, 167, 188,290));
        setBackground(new Color(153, 51, 83,250));
        // setBackground(Color.blue);
        setLayout(null); 

        
        JLabel passwordhead = new JLabel("<html><u>UPDATE PASSWORD</u></html>");
        passwordhead.setBounds(250, 110, 550, 30);
        passwordhead.setForeground(Color.white);
        passwordhead.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(passwordhead);

       JLabel newpass = new JLabel("NEW PASSWORD");
       newpass.setBounds(200,200,550,30);
       newpass.setForeground(Color.white);
       newpass.setFont(new Font("Tahoma",Font.BOLD,25));
       add(newpass);

       newpasstext = new JPasswordField();
       newpasstext.setBounds(200,240,300,30);
       add(newpasstext); 

       JLabel confirmpass = new JLabel("CONFIRM PASSWORD");
       confirmpass.setBounds(200,300,550,30);
       confirmpass.setFont(new Font("Tahoma",Font.BOLD,25));
       confirmpass.setForeground(Color.white);
       add(confirmpass); 

       confirmpasstext = new JPasswordField();
       confirmpasstext.setBounds(200,340,300,30);
       add(confirmpasstext); 

       okbutton = new JButton("UPDATE");
       okbutton.setBounds(300, 400, 130, 26);
       okbutton.setBackground(Color.blue);
       okbutton.setForeground(Color.white);
       okbutton.addActionListener(this);
       add(okbutton);

        setVisible(true);

    } 

    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == okbutton) {
             
            String password1 = newpasstext.getText();
            String password2 = confirmpasstext.getText();
           if(password1.equals("") || password2.equals("")) {
               JOptionPane.showMessageDialog(null,"Please fill the password");
           }
            if(password1.equals(password2)) {
                  
                try {
                    
                    Conn con = new Conn();
                    String sql = "UPDATE adminid SET password='"+password1+"' WHERE adminid='"+adminid+"'";
                    con.s.executeUpdate(sql); 
                    JOptionPane.showMessageDialog(null,"Password Updated Successfully");
                    this.setVisible(false);                

                } catch (Exception ex){ 
                    System.out.println(ex.getMessage());

                } 
        
            } else {
                JOptionPane.showMessageDialog(null,"Your password didn't match");
            }
        }
    }
}