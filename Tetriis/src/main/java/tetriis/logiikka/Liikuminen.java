/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriis.logiikka;

/**
 *
 * @author tiera
 */
public class Liikuminen {

    private Kartta terriskartta;

    public Liikuminen(Kartta terriskartta) {
        this.terriskartta = terriskartta;
    }

    public Kartta getTerriskartta() {
        return terriskartta;
    }


    /* 
    * tutkii voiko liikua oikealle (private voikoliikuaoikealle) ja
    * jos voi niin muokkaa karttaa niin että palikat liikuneet oikealle
     */
    //liikuminen oikealle
    public void liikuoikealle() {
        if (voikoliikkuaoikealle()) {
            int[][] kartta2 = terriskartta.luouusikarrtta();
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 30; y++) {
                    if (terriskartta.getKartta()[x][y] == 1) {
                        kartta2[x - 1][y] = 1;
                    } else if (terriskartta.getKartta()[x][y] == 2) {
                        kartta2[x - 1][y] = 2;
                    }

                }
            }
            terriskartta.setKartta(kartta2);
        }
    }

    private boolean voikoliikkuaoikealle() {
        for (int x = 9; x >= 0; x--) { // käy alhaalta ylöspäin palikat läpi ja tutkii voidaanko liikkua
            for (int y = 29; y >= 0; y--) {
                if (x == 0 && (terriskartta.getKartta()[x][y] == 1 || terriskartta.getKartta()[x][y] == 2)) {
                    return false;
                } else if ((terriskartta.getKartta()[x][y] == 1 || terriskartta.getKartta()[x][y] == 2) && terriskartta.getVanhatpalkat()[x - 1][y] == 1) {
                    return false;
                }
            }

        }
        return true;
    }

    /* 
    * tutkii voiko liikua vasemmalle (private voikoliikuavasemmalle) ja
    * jos voi niin muokkaa karttaa niin että palikat liikuneet vasemmalle
     */
    //vasemalle liikuminen
    public void liikuvasemmalle() {
        if (voikoliikkuavasemmalle()) {
            int[][] kartta2 = terriskartta.luouusikarrtta();
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 30; y++) {
                    if (terriskartta.getKartta()[x][y] == 1) {
                        kartta2[x + 1][y] = 1;
                    } else if (terriskartta.getKartta()[x][y] == 2) {
                        kartta2[x + 1][y] = 2;
                    }

                }
            }
            terriskartta.setKartta(kartta2);
        }
    }

    
    
    private boolean voikoliikkuavasemmalle() {
        for (int x = 9; x >= 0; x--) { // käy alhaalta ylöspäin palikat läpi ja tutkii voidaanko liikkua 
            for (int y = 29; y >= 0; y--) {
                if (x == 9 && (terriskartta.getKartta()[x][y] == 1 || terriskartta.getKartta()[x][y] == 2)) {
                    return false;
                } else if ((terriskartta.getKartta()[x][y] == 1 || terriskartta.getKartta()[x][y] == 2) && terriskartta.getVanhatpalkat()[x + 1][y] == 1) {
                    return false;
                }

            }

        }
        return true;
    }

    
    /* 
    * tutkii voiko liikua alas (private voikoliikuaalas) ja
    * jos voi niin muokkaa karttaa niin että palikat liikuneet alas
    * jos ei vvoi liikkua alas niin tallentaa liikuvien palikoiden kartan 
    * liikumattomien palikoiden karttaan, luo uuden kartan liikuvien tilalle ja
    * ja tutkii täyttyykö lopetus ehdot.
     */

    public void liikualas() {
        if (voikoliikkualas()) {
            int[][] kartta2 = terriskartta.luouusikarrtta();
            for (int x = 0; x < 10; x++) { // luo uuden kartan jossa y on yhden suurempi kuin vanhassa
                for (int y = 0; y < 30; y++) {
                    if (terriskartta.getKartta()[x][y] == 1) {
                        kartta2[x][y + 1] = 1;
                    } else if (terriskartta.getKartta()[x][y] == 2) {
                        kartta2[x][y + 1] = 2;
                    }

                }
            }
            terriskartta.setKartta(kartta2);
        } else {
            terriskartta.tallennakartat();
            terriskartta.uusipalikka();
        }
    }

    private boolean voikoliikkualas() {
        for (int x = 9; x >= 0; x--) { // käy alhaalta ylöspäin palikat läpi ja tutkii voidaanko liikkua 
            for (int y = 29; y >= 0; y--) {
                if (y == 29 && (terriskartta.getKartta()[x][y] == 1 || terriskartta.getKartta()[x][y] == 2)) {
                    return false;
                } else if ((terriskartta.getKartta()[x][y] == 1 || terriskartta.getKartta()[x][y] == 2) && terriskartta.getVanhatpalkat()[x][y + 1] == 1) {
                    return false;
                }
            }

        }
        return true;
    }
}
