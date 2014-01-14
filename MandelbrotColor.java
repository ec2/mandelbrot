import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

//public class MandelbrotColor extends JPanel implements MouseWheelListener{
public class MandelbrotColor extends JPanel{
  int zoom = 1;
  double x_cen = 0;
  double y_cen = 0;
  int max =100;
  boolean axis = false;

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    Graphics2D g2d = (Graphics2D) g;

    int width = 1280, height = 600;
    int black = 0;
    int[] colors = new int[max];
    for (int i = 0; i<max; i++) {
      colors[i] = Color.HSBtoRGB(i/256f, 1, i/(i+8f));
    }
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        double c_re = (col - width/2)*4.0/(width*zoom)+x_cen;
        double c_im = (row - height/2)*4.0/(width*zoom)-y_cen;
        double x = 0, y = 0;
        double r2;
        int iteration = 0;
        while (x*x+y*y < 4 && iteration < max) {
          double x_new = x*x-y*y+c_re;
          y = 2*x*y+c_im;
          x = x_new;
          iteration++;
        } 
        if (iteration < max){ g2d.setColor(new Color(colors[iteration]));g2d.drawLine(col,row,col,row);}
        else{g2d.setColor(Color.BLACK);g2d.drawLine(col,row,col,row);}
      }
    }
    if(axis == true){
      g2d.setColor(Color.YELLOW);
      g2d.drawLine(0,height/2, width, height/2);
      g2d.drawLine(width/2, 0, width/2, height);
    }
  }
  public MandelbrotColor(){
    JFrame j = new JFrame();
    j.setSize(1280,600);
    j.setResizable(false);
    j.add(this);
    j.setVisible(true);
    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JFrame j1 = new JFrame();
    j1.setLayout(new FlowLayout());
    //addMouseWheelListener(this);
    
    JButton jb = new JButton("Calculate");
    final  JTextField t [] = {new JTextField("0",3),new JTextField("0",3),new JTextField("1",3),new JTextField("100",3)};
    JLabel l [] = {new JLabel("Center x: "),new JLabel("Center y: "),new JLabel("Zoom: "),new JLabel("Iterations: ")};
    jb.addActionListener(new ActionListener()  {   /* anonymous class not found */
      public void actionPerformed(ActionEvent ae){
        x_cen = Double.parseDouble(t[0].getText()) ;
        y_cen = Double.parseDouble(t[1].getText());
        zoom = Integer.parseInt(t[2].getText());
        max = Integer.parseInt(t[3].getText());
        repaint();
      }
    });
    JCheckBox cb = new JCheckBox("Show Axis");
    cb.addItemListener(new ItemListener(){
      public void itemStateChanged(ItemEvent e){
        if(e.getStateChange() == ItemEvent.SELECTED){
          axis = true;
          paintImmediately(0,600/2,1280,1);
          paintImmediately(1280/2,0,1280/2,600);
        }
        else{
          axis = false;
          paintImmediately(0,600/2,1280,1);
          paintImmediately(1280/2,0,1280/2,600);
        }
      }
    });
    
    j1.add(jb);
    j1.add(l[0]);
    j1.add(t[0]);
    j1.add(l[1]);
    j1.add(t[1]);
    j1.add(l[2]);
    j1.add(t[2]);
    j1.add(l[3]);
    j1.add(t[3]);
    j1.add(cb);
    j1.pack();
    // j1.setResizable(false);
    j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    j1.setVisible(true);
    
    //j.setFocus(true);
    
  }

}