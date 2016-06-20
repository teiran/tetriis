/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiikka;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


class Grafiikka extends JPanel {

    private int[][] kartta;
    private Graphics2D g2d;

    public Grafiikka(int[][] kartta) {
        this.kartta = kartta;
    }
    public void setkartta(int[][] k){
        this.kartta = k;
    }

    protected void doDrawing(Graphics g) {

        g2d = (Graphics2D)g;
        int x1 = 30;
        int y1 = 30;
        int x2 = 30 * 11;
        int y2 = 30;
        int r = 0;
        for (int i = 0; i < 31; i++) {
            g2d.drawLine(x1, y1, x2, y2);
            y1 += 30;
            y2 += 30;
        }
        x1 = 30;
        x2 = 30;
        y1 = 30;
        y2 = 30 * 31;
        for (int i = 0; i < 11; i++) {
            g2d.drawLine(x1, y1, x2, y2);
            x1 += 30;
            x2 += 30;
        }
        x1 = 30;
        x2 = 60;
        y1 = 30;
        y2 = 30;
        for (int[] is : kartta) {
            for (int i : is) {
                if (i == 1) {
                    for (int j = 0; j < 30; j++) {
                        for (int k = 0; k < 30; k++) {
                            g2d.drawLine(y1, x1, y2+k, x2+j);
                        }
                    }
                    
                }
                
                
                x1 += 30;
                x2 += 30;

            }
            x1= 30;
            x2= 30;
            y1 += 30;
            y2 += 30;
        }
    }
    


    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }


}
