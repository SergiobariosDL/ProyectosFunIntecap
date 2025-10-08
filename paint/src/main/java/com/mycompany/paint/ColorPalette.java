/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.paint;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Usuario
 */
public class ColorPalette extends JPanel{
    private ColorPalette2 listener;
    
    public ColorPalette(ColorPalette2 listener){
        super();
        this.listener = listener;
        //setBackground(Color.GRAY);   
        init();
    }
    
    private void init(){
        setBackground(Color.GRAY);
        
    }
    
    private static Color getColor(int code){
        int rgb;
        if (code == 8){
           rgb =0x404040; 
            
        }else{
            int i = 0x7F;
              rgb = (((code & 4)* i)<<(16-2)) +
                    (((code & 2) *i)<<(8-1)) +
                    (((code & 1)* i));  
        }
        return new Color(rgb);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for (int n=0; n<16; n++){
            Color color = getColor(n);
            g.setColor(color);
            g.fillRect((n % 2)*32, (n/2)*32, 32,32);
        }
        
    }
    
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(64,480);
       
    }
    
}
