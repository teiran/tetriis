/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriis.logiikka;

import tetriis.logiikka.Kartta;
import tetriis.logiikka.Tetrispalikka;

/**
 *
 * @author tiera
 */
public class Siirrot {
    private Kartta terriskartta;


    public Siirrot() {
        terriskartta = new Kartta();
    }
    
    public void luosuusipalikka(Tetrispalikka t){
        terriskartta.uusipalikka(t);
    }

    @Override
    public String toString() {
        return terriskartta.toString();
    }



//oikealle liikuminen
    public void liikuoikealle() {
        if (voikoliikkuaoikealle()) {
            int[][] kartta2 = terriskartta.luouusikarrtta();
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 30; y++) {
                    if (terriskartta.getKartta()[x][y] == 1) {
                        kartta2[x - 1][y] = 1;
                    }
                    
                }
            }
            terriskartta.setKartta(kartta2);
        }
    }

    private boolean voikoliikkuaoikealle() {
        for (int x = 9; x >= 0; x--) { // käy alhaalta ylöspäin palikat läpi ja tutkii voidaanko liikkua
            for (int y = 29; y >= 0; y--) {
                if (x == 0 && terriskartta.getKartta()[x][y] == 1) {
                    return false;
                } else if (terriskartta.getKartta()[x][y] == 1 && terriskartta.getVanhatpalkat()[x-1][y] == 1) {
                    return false;
                }
            } 
                    

        }
        return true;
    }

//vasemalle liikuminen
    public void liikuvasemmalle() {
        if (voikoliikkuavasemmalle()) {
            int[][] kartta2 = terriskartta.luouusikarrtta();
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 30; y++) {
                    if (terriskartta.getKartta()[x][y] == 1) {
                        kartta2[x + 1][y] = 1;
                    }
                    
                }
            }
            terriskartta.setKartta(kartta2);
        }
    }

    private boolean voikoliikkuavasemmalle() {
        for (int x = 9; x >= 0; x--) { // käy alhaalta ylöspäin palikat läpi ja tutkii voidaanko liikkua 
            for (int y = 29; y >= 0; y--) {
                if (x + 1 == 10 && terriskartta.getKartta()[x][y] == 1) {
                    return false;
                }else if (terriskartta.getKartta()[x][y] == 1 && terriskartta.getVanhatpalkat()[x + 1][y] == 1) {
                    return false;
                }
                
            }
                    
        }
        return true;
    }

    // voiko liikua oikealle
    public void liikualas() {
        if (voikoliikkualas()) {
            int[][] kartta2 = terriskartta.luouusikarrtta();
            for (int x = 0; x < 10; x++) { // luo uuden kartan jossa y on yhden suurempi kuin vanhassa
                for (int y = 0; y < 30; y++) {
                    if (terriskartta.getKartta()[x][y] == 1) {
                        kartta2[x][y + 1] = 1;
                    }
                    
                }
            }
            terriskartta.setKartta(kartta2); 
        } else {
            terriskartta.tallennakartat();
        }
    }

    private boolean voikoliikkualas() {
        for (int x = 9; x >= 0; x--) { // käy alhaalta ylöspäin palikat läpi ja tutkii voidaanko liikkua 
            for (int y = 29; y >= 0; y--) {
                if (y + 1 == 30 && terriskartta.getKartta()[x][y] == 1) {
                    return false;
                } else if (terriskartta.getKartta()[x][y] == 1 && terriskartta.getVanhatpalkat()[x][y + 1] == 1) {
                    return false;
                }
            }

        }
        return true;
    }

}
