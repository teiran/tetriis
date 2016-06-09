/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import tetriis.logiikka.Siirrot;
import grafiikka.LinesEx;


/**
 *
 * @author tiera
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lu = new Scanner(System.in);
        
        Siirrot peli = new Siirrot();

        boolean k = peli.lopetus();
        while (k) {
            System.out.println(peli);
            System.out.println("q,e,a,s,d");
            LinesEx ex = new LinesEx(peli.kartat());
            ex.setVisible(true);    
            String g = lu.nextLine();
            
            switch (g) {
                case "q": peli.kaannyvasemmalle();
                    break;
                case "e": peli.kaannyoikealle();
                    break;
                case "d": peli.liikuvasemmalle();
                    break;
                case "s": peli.liikualas();
                    break;
                case "a": peli.liikuoikealle();
                    break;
                default: peli.liikualas();
                    break;
            }
           
            k = peli.lopetus();
            
        }

    }

}
