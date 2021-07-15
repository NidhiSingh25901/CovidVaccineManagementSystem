
package Vaccine;
import java.awt.*;
import javax.swing.*;
public class Front_Page {

    public static void main(String[] args) {
       SplashFrame f1 = new SplashFrame();   //calling the SplashFrame
       f1.setVisible(true);          //Setting the visibility of the splashframe to true
       int i; 
       int x=1;            
       //Resizing of SplashFrame from the center
       for (i =2; i<=600;i+=10,x+=7){
              f1.setLocation(750 - ((i + x) / 2), 400 - (i / 2));
              f1.setSize(i+x,i);
              try{
                 Thread.sleep(10);
              } catch ( Exception e) {

              }
       }
    }
}

class SplashFrame extends JFrame implements Runnable {

    Thread th;
  SplashFrame() {
      setLayout(new FlowLayout());
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Vaccine/Icons/service2.jpg"));
      Image i2 = i1.getImage().getScaledInstance(1030, 750, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
 
      JLabel l1 = new JLabel(i3);  //adding image to the Jlabel that is on Jframe
    
      add(l1); 
      setUndecorated(true);
      th = new Thread(this);
      th.start();

  } 

  public void run(){
      try {
        Thread.sleep(6000);
         this.setVisible(false);
         new ChoiceLogin().setVisible(true);
      } catch (Exception e){

      }
  }
}