/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriis.logiikka;
import tetriis.logiikka.Tetrispalikka;

/**
 *
 * @author tiera
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Siirrot likeet = new Siirrot();
        likeet.luosuusipalikka(new Tetrispalikka());
        System.out.println(likeet);
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < 4; i++) {
            likeet.liikuvasemmalle();
            System.out.println("");
            System.out.println("");
            System.out.println(likeet);
        }    
    }
    
}
