import javax.swing.*;
import java.awt.*;
import java.math.*;
import java.awt.event.*;

public class Main extends JFrame
{
  
  
  public  Main()
  {

    
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    
    GridBagConstraints c = new GridBagConstraints();

    l1 = new JLabel ("C= ");
    l2 = new JLabel (" + ");
    l3 = new JLabel ("i");
    l4 = new JLabel ("n= ");
    
    
    tf1 = new JTextField (5);
    tf2 = new JTextField (5);
    tf3 = new JTextField (3);
    tf4 = new JTextField (5);
    calc = new JButton ("Calculate");
    calc.addActionListener(new ActionListener()  {   /* anonymous class not found */
      public void actionPerformed(ActionEvent ae){
        process();
      }
    });  
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 0;
    panel.add(l1, c);
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 0;
    panel.add(tf1, c);
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 2;
    c.gridy = 0;
    panel.add(l2,c);
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 3;
    c.gridy = 0;
    panel.add(tf2,c );
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx =4;
    c.gridy = 0;
    panel.add(l3, c);
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 1;
    panel.add(l4,c);
      
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 1;
    panel.add(tf3, c);
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridwidth = 4;
    c.gridx = 0;
    c.gridy = 2;
    panel.add(calc, c);
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridwidth = 4;
    c.gridx = 0;
    c.gridy = 3;
    panel.add(tf4,c);
    
    add(panel);
    
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
   setVisible(true);
  }
  
  public void process(){
    int iteration = Integer.parseInt(tf3.getText());
    double realIn = Double.parseDouble(tf1.getText());
    double compIn = Double.parseDouble(tf2.getText());
    double realOut = realIn;
    double compOut = compIn;
    double temp = 0;
    
    for(int a = 1 ; a < iteration ; a++){
      temp = realOut;
      realOut = temp * temp;
      realOut -= compOut*compOut;
      realOut += realIn;
      compOut = 2*(temp*compOut) + compIn;
    }
    tf4.setText(Double.toString(realOut) + " + " + Double.toString(compOut)+ "i" );
  }
  
  JTextField tf1;
  JTextField tf2;
  JTextField tf3;
  JTextField tf4;
  
  JLabel l1;
  JLabel l2;
  JLabel l3;
  JLabel l4;
  
  JButton calc;
  

}
