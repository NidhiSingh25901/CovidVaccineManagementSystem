package Vaccine;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;

public class User_Signup extends JFrame implements ActionListener {
  public static void main(String[] args) {
    new User_Signup();
  }

  JTextField nametext;
  JTextField aadhartext;
  JTextField dobtext;
  JTextField phntext;
  JPasswordField passwordtext;
  JButton signupButton;
  JButton instruction;

  User_Signup() {

    // FRAME
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setLayout(null);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("User - Sign Up");

    // black border
    Border blackline = BorderFactory.createLineBorder(Color.BLACK);

    // background
    ImageIcon background_image = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/signup-bg.jpg"));
    Image img = background_image.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
    background_image = new ImageIcon(img);
    JLabel background = new JLabel("", background_image, JLabel.CENTER);
    background.setBounds(0, 0, 1550, 1000);
    add(background);

    // signup panel
    JPanel signup = new JPanel();
    signup.setLayout(null);
    signup.setSize(400, 380);
    signup.setBackground(new Color(174, 226, 234, 60));
    signup.setBounds(480, 150, 400, 550);
    signup.setBorder(blackline);

    // pannel icon
    ImageIcon initial_panelIcon = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/signupIcon.jpeg"));
    Image temp_panelIcon = initial_panelIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
    ImageIcon final_panelIcon = new ImageIcon(temp_panelIcon);
    JLabel panelIcon = new JLabel(final_panelIcon);
    panelIcon.setBounds(650, 130, 50, 50);
    background.add(panelIcon);

    // text fields in signup panel
    // panel heading
    JLabel heading = new JLabel("USER SIGN UP");
    heading.setLayout(null);
    heading.setBounds(130, 1, 300, 100);
    heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
    signup.add(heading);

    instruction = new JButton("i");
    instruction.setBackground(new Color(0, 199, 255, 200));
    instruction.setBounds(40, 30, 40, 30);
    instruction.addActionListener(this);
    signup.add(instruction);

    // name input
    JLabel name = new JLabel("NAME");
    name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
    name.setBounds(40, 50, 100, 100);
    signup.add(name);

    nametext = new JTextField();
    nametext.setForeground(Color.BLACK);
    nametext.setBounds(40, 110, 300, 30);
    signup.add(nametext);

    // validating textfield to accept only characters
    nametext.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke) {
        char ch = ke.getKeyChar();
        if (!Character.isDigit(ch)) {
          nametext.setEditable(true);
        } else {
          nametext.setEditable(false);
          JOptionPane.showMessageDialog(null, "Only Chracters are allowed");
        }
      }
    });

    // aadhar number input
    JLabel aadhar = new JLabel("AADHAR NUMBER");
    aadhar.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
    aadhar.setBounds(40, 130, 300, 100);
    signup.add(aadhar);

    aadhartext = new JTextField();
    aadhartext.setForeground(Color.BLACK);
    aadhartext.setBounds(40, 190, 300, 30);
    signup.add(aadhartext);

    // validating aadharfield to accept 12 digit number
    aadhartext.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke) {
        String value = aadhartext.getText();
        int l = value.length();
        try {
          if (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_DELETE) {

            value = value.substring(0, l - 1);
            l = value.length();
            aadhartext.setText(value);
          }
        } catch (Exception e) {

        }
        try {
          if (l < 12) {

            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
              aadhartext.setEditable(true);
            } else {
              aadhartext.setEditable(false);

            }

          } else {
            aadhartext.setEditable(false);
            JOptionPane.showMessageDialog(null, "only 12 digits are allowed");
          }
          // close of if loop
        } catch (Exception e) {

        }
      }
    });

    // dob input
    JLabel dob = new JLabel("YEAR OF BIRTH");
    dob.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
    dob.setBounds(40, 210, 500, 100);
    signup.add(dob);

    dobtext = new JTextField();
    dobtext.setForeground(Color.BLACK);
    dobtext.setBounds(40, 270, 300, 30);
    signup.add(dobtext);
    dobtext.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke) {
        char key = ke.getKeyChar();
        String val = dobtext.getText();
        int len = val.length();
        try {
          if (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_DELETE) {
            dobtext.setEditable(true);
            val = val.substring(0, len - 1);
            len = val.length();
            dobtext.setText(val);
          }
        } catch (Exception e) {

        }
        try {
          int i = len;
          while (i != 3) {
            if (Character.isDigit(key)) {
              dobtext.setEditable(true);
            } else {
              dobtext.setEditable(false);
            }
            i++;
          }
        } catch (Exception e) {

        }
      }

    });
    // phone number
    JLabel phn = new JLabel("PHONE NUMBER");
    phn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
    phn.setBounds(40, 290, 300, 100);
    signup.add(phn);

    phntext = new JTextField();
    phntext.setForeground(Color.BLACK);
    phntext.setBounds(40, 350, 300, 30);
    signup.add(phntext);

    // validating phone number to accept 10 digit number
    phntext.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke) {
        char key = ke.getKeyChar();
        String val = phntext.getText();
        int len = val.length();
        try {
          if (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_DELETE) {
            phntext.setEditable(true);
            val = val.substring(0, len - 1);
            len = val.length();
            phntext.setText(val);
          }
        } catch (Exception e) {

        }
        try {
          if (len < 10) {
            if (Character.isDigit(key)) {
              phntext.setEditable(true);
            } else {
              phntext.setEditable(false);
            }
          } else {
            phntext.setEditable(false);
            JOptionPane.showMessageDialog(null, "only 10 digits are allowed");
          }
        } catch (Exception e) {

        }

      }
    }

    );

    // password
    JLabel password = new JLabel("PASSWORD");
    password.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
    password.setBounds(40, 370, 300, 100);
    signup.add(password);

    passwordtext = new JPasswordField();
    passwordtext.setForeground(Color.BLACK);
    passwordtext.setBounds(40, 430, 300, 30);
    signup.add(passwordtext);

    // signup button
    signupButton = new JButton("SIGN UP");
    signupButton.setBounds(40, 487, 300, 30);
    signupButton.setBackground(new Color(0, 199, 255, 200));
    signupButton.addActionListener(this);
    signup.add(signupButton);

    background.add(signup);
    add(background);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == signupButton) {
      // Validating passwor field
      String namevalue = nametext.getText();
      String aadharvalue = aadhartext.getText();
      String dobvalue = dobtext.getText();
      String phnvalue = phntext.getText();
      String passwordvalue = passwordtext.getText();

      if (namevalue.equals("") || aadharvalue.equals("") || dobvalue.equals("") || phnvalue.equals("")
          || passwordvalue.equals("")) {
        JOptionPane.showMessageDialog(null, "Enter the required field");
      } else {

        String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(passwordvalue);
        if (m.matches()) {
          passwordtext.setEnabled(true);

          Conn con = new Conn();

          try {
            String aadharvalues = aadhartext.getText();
            String fetchsql = "SELECT * FROM usersignup WHERE aadhar='" + aadharvalues + "' ";
            PreparedStatement fetchst = con.c.prepareStatement(fetchsql);
            ResultSet fetchrs = fetchst.executeQuery(fetchsql);
            if (fetchrs.next()) {
              JOptionPane.showMessageDialog(null, "Aadhar already exists");
            } else {

              String sql = "INSERT INTO usersignup(name,phone,aadhar,dob,password,dose,status,address) VALUES(?,?,?,?,?,0,0,0)";
              PreparedStatement st = con.c.prepareStatement(sql);
              st.setString(1, nametext.getText());
              st.setString(2, phntext.getText());
              st.setString(3, aadhartext.getText());
              st.setString(4, dobtext.getText());
              st.setString(5, passwordtext.getText());

              int i = st.executeUpdate();

              if (i > 0) {
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                this.setVisible(false);
                new User_Login().setVisible(true);
              }

              nametext.setText("");
              phntext.setText("");
              aadhartext.setText("");
              dobtext.setText("");
              passwordtext.setText("");

            }
          } catch (Exception re) {

          }
        } else {
          JOptionPane.showMessageDialog(null,
              "<html>Please read the instruction provided at the top left corner<br> That is, 'i' button</html>");
        }

      }
    }

    if (e.getSource() == instruction) {
      JOptionPane.showMessageDialog(null,
          "<html><ul><li>Name must have only alphabets.</li><li>Aadhar number must be of 12 digit number.</li><li>In year of birth, enter 4 digit of year. eg.- 2001</li><li>In Phone Number, enter 10 digit phone number</li><li>In password, enter a capital letter, special character, numbers and can be of any length</li></ul></html>");
    }
  }
}
