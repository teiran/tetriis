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
        Siirrot k = new Siirrot();
        k.luosuusipalikka();
        System.out.println(k);
        k.liikualas();
        System.out.println(k);
        k.liikuvasemmalle();
        k.liikuvasemmalle();
        k.liikuvasemmalle();
        k.liikuvasemmalle();
        k.liikuvasemmalle();
        k.kaannyvasemmalle();
        System.out.println(k);
        
        
    }
    
}
