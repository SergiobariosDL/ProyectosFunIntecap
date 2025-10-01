/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.BorderLayout;


/**
 *
 * @author Usuario
 */
public class Paint extends JPanel{
    BufferedImage image;
    Graphics2D g2d;
    
    public Paint(){
        super();
        init();
        
    }
    
    private void init(){
       
       
        
        image = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
        
        g2d = image.createGraphics();
        g2d.setBackground(Color.WHITE);
        g2d.fillRect(0, 0, image.getWidth(), image.getHeight());
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        
        MouseAdapter mouseHandler = new MouseAdapter(){
            private Point curPoint = new Point();
            @Override
            public void mousePressed(MouseEvent e){
              curPoint.setLocation(e.getPoint());
            }
            @Override
            public void mouseDragged(MouseEvent e){
             g2d.drawLine(curPoint.x, curPoint.y, e.getX(), e.getY());
             curPoint.setLocation(e.getPoint());
             repaint();
            }
        };
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }
    @Override
     public Dimension getPreferredSize(){
         return new Dimension(640, 480);
     }
    
    
    
    @Override
    protected void paintComponent(Graphics g){
      super.paintComponent(g);
             g.drawImage(image, 0, 0, null);
    }
    
    
    public static void main(String[] args) {
     SwingUtilities.invokeLater(()-> {
         JFrame frame = new JFrame("paint");
         //frame.setMinimumSize(new Dimension(640, 480));
         frame.setResizable(false);
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         //frame.setContentPane(new Paint());
         frame.add(new Paint(), BorderLayout.CENTER);
         
         frame.add(new ColorPalette(), BorderLayout.EAST);
         frame.getContentPane().setBackground(Color.GRAY);
         
         BorderLayout layout = (BorderLayout) frame.getContentPane().getLayout();
         layout.setHgap(6);
         
         frame.pack();
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
     });   
    }
}
