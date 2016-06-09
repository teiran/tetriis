/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiikka;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;
import javax.swing.JPanel;
import tetriis.logiikka.Siirrot;

class Surface extends JPanel {

    private Siirrot kartta;



    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
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
        
        Scanner lu = new Scanner(System.in);
        
        Siirrot peli = new Siirrot();
        boolean k = peli.lopetus();
        while (k) {
            System.out.println(peli);
            System.out.println("q,e,a,s,d");
           
            String f = lu.nextLine();
            
            switch (f) {
                case "q": peli.kaannyvasemmalle();
                    break;
                case "e": peli.kaannyoikealle();
                    break;
                case "a": peli.liikuvasemmalle();
                    break;
                case "s": peli.liikualas();
                    break;
                case "d": peli.liikuoikealle();
                    break;
                default: peli.liikualas();
                    break;
            }
            update(g2d);
            k = peli.lopetus();
            
        }
        
        
        
        

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
    
    private void update(Graphics2D g2d){
        int x1 = 30;
        int x2 = 60;
        int y1 = 30;
        int y2 = 30;
        for (int[] is : kartta.kartat()) {
            for (int i : is) {
                if (i == 1) {
                    for (int j = 0; j < 30; j++) {
                        for (int k = 0; k < 30; k++) {
                            g2d.drawLine(y1, x1, y2+k, x2+j);
                        }
                    }
                    
                } else {
                    g2d.clearRect(y1+1, x1+1, 28, 28);
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
}
