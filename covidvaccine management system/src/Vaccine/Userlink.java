package Vaccine;

import javax.swing.*;

// jdk.internal.org.jline.terminal.MouseEvent;
import java.net.URI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.event.*;
public class Userlink extends JFrame implements ActionListener{
    public static void main(String[] args){
       new Userlink().setVisible(true);
    }

    JButton okbutton;

    public Userlink() {

        // setting frame size and styling
        setBounds(500, 150, 760, 600);
        setResizable(false);
        setUndecorated(true);
        setBackground(new Color(34, 54, 86, 250));
        setLayout(null);

         // important links heading
        JLabel implinkhead = new JLabel("<html><u>Important Links</u></html>");
        implinkhead.setBounds(250, 70, 550, 30);
        implinkhead.setForeground(Color.white);
        implinkhead.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(implinkhead);
         
        // details sub heading
        JLabel linkinst = new JLabel("Following are the list of prevailing services that are offered to needy at the time of covid.");
        linkinst.setBounds(50,120,1000,20);
        linkinst.setFont(new Font("Tahoma", Font.BOLD,15));
        linkinst.setForeground(Color.white);
        add(linkinst);

        // all the important links
        JLabel link1 = new JLabel("<html><u>Covid Vaccine Details</u></html>");
        link1.setForeground(Color.white);
        link1.setBounds(200,200,500,50);
        link1.setFont(new Font("Tahoma", Font.BOLD,20));
        link1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        link1.addMouseListener(new MouseAdapter() {

               @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/covid_vaccination/vaccination/index.html"));
                    } catch(IOException | URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                }

        });
      add(link1); 


      JLabel vaccinebenefit = new JLabel("<html><u>Covid Vaccine Benefits</u></html>");
       vaccinebenefit.setForeground(Color.white);
       vaccinebenefit.setBounds(200,240,500,50);
       vaccinebenefit.setFont(new Font("Tahoma", Font.BOLD,20));

       vaccinebenefit.setCursor(new Cursor(Cursor.HAND_CURSOR));
       vaccinebenefit.addMouseListener(new MouseAdapter() {

             @Override
              public void mouseClicked(MouseEvent e) {
                  try {
                  Desktop.getDesktop().browse(new URI("https://www.cdc.gov/coronavirus/2019-ncov/vaccines/vaccine-benefits.html"));
                  } catch(IOException | URISyntaxException e1) {
                      e1.printStackTrace();
                  }
              }
      });
    add(vaccinebenefit);


   // 

   JLabel mygovcovid = new JLabel("<html><u>Covid Details by MyGov</u></html>");
   mygovcovid.setForeground(Color.white);
   mygovcovid.setFont(new Font("Tahoma", Font.BOLD,20));

   mygovcovid.setBounds(200,280,500,50);
   mygovcovid.setCursor(new Cursor(Cursor.HAND_CURSOR));
   mygovcovid.addMouseListener(new MouseAdapter() {

         @Override
          public void mouseClicked(MouseEvent e) {
              try {
              Desktop.getDesktop().browse(new URI(" https://www.mygov.in/covid-19/"));
              } catch(IOException | URISyntaxException e1) {
                  e1.printStackTrace();
              }
          }
  });
add(mygovcovid);



JLabel ukcovid = new JLabel("<html><u>Covid Details by UK govt.</u></html>");
ukcovid.setForeground(Color.white);
ukcovid.setFont(new Font("Tahoma", Font.BOLD,20));

ukcovid.setBounds(200,320,500,50);
ukcovid.setCursor(new Cursor(Cursor.HAND_CURSOR));
ukcovid.addMouseListener(new MouseAdapter() {

      @Override
       public void mouseClicked(MouseEvent e) {
           try {
           Desktop.getDesktop().browse(new URI("https://www.gov.uk/coronavirus"));
           } catch(IOException | URISyntaxException e1) {
               e1.printStackTrace();
           }
       }
});
add(ukcovid);


JLabel icmr = new JLabel("<html><u>ICMR - details about covid tests and hospitals</u></html>");
icmr.setForeground(Color.white);
icmr.setFont(new Font("Tahoma", Font.BOLD,20));
icmr.setBounds(200,360,500,50);
icmr.setCursor(new Cursor(Cursor.HAND_CURSOR));
icmr.addMouseListener(new MouseAdapter() {

      @Override
       public void mouseClicked(MouseEvent e) {
           try {
           Desktop.getDesktop().browse(new URI("https://www.icmr.gov.in/"));
           } catch(IOException | URISyntaxException e1) {
               e1.printStackTrace();
           }
       }
});
add(icmr);




JLabel isolate = new JLabel("<html><u>Benefits given by Jharkhand govt. Go through</u></html>");
isolate.setForeground(Color.white);
isolate.setFont(new Font("Tahoma", Font.BOLD,20));
isolate.setBounds(200,400,500,50);
isolate.setCursor(new Cursor(Cursor.HAND_CURSOR));
isolate.addMouseListener(new MouseAdapter() {

      @Override
       public void mouseClicked(MouseEvent e) {
           try {
           Desktop.getDesktop().browse(new URI("https://jamshedpur.nic.in/covid-19/"));
           } catch(IOException | URISyntaxException e1) {
               e1.printStackTrace();
           }
       }
});
add(isolate);


okbutton = new JButton("OK");
okbutton.setBounds(300, 550, 70, 26);
okbutton.setBackground(Color.blue);
okbutton.setForeground(Color.white);
okbutton.addActionListener(this);
add(okbutton);


    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == okbutton) {
            this.setVisible(false);            
        }
    }
}
