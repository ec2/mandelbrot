import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Launcher extends JApplet{
  public void init(){
    JButton b = new JButton("Launch The Mandelbrot Set");
    
    b.addActionListener(new ActionListener()  {   /* anonymous class not found */
      public void  actionPerformed(ActionEvent ae){
        new MandelbrotColor();
      }
    });
   
    JButton b1 = new JButton("Launch The Mandelbrot Calculator");
    
    b1.addActionListener(new ActionListener()  {   /* anonymous class not found */
      public void  actionPerformed(ActionEvent ae){
        Main i = new Main();

      }
    });
    setLayout(new FlowLayout());
    add(b);
    add(b1);
  }
}