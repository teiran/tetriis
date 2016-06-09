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
public class Siirrot {
    private boolean lopetusehot;
    private Kartta terriskartta;
    
    /*
    * luo uuden kartan
    * kutsuu tälle uutta tetrispalikka
    * ja laitaa lopetusehdoksi true.
    */

    public Siirrot() {
        terriskartta = new Kartta();
        terriskartta.uusipalikka();
        lopetusehot = true;
    }

    @Override
    public String toString() {
        return terriskartta.toString();
    }
    
    public int[][] kartat(){
        return terriskartta.molemmatkartat();
    }
    
    /*
    * lopetus ehdon getteri
    */
    public boolean lopetus(){
        return lopetusehot;
    }
    
    private boolean lopetus2(){
        int[] h = terriskartta.lopetus();
        if (h[4]==1||h[5]==1) {
            return false;
        }
        return true;
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
    // voiko liikua oikealle
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
            lopetusehot = lopetus2();
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

    public void kaannyvasemmalle() {
        kaanny("vasen");
    }

    public void kaannyoikealle() {
        kaanny("");
    }
    /*
    * etsii tetrispalikan kääntymispiteen kääntää tämän, sovittaa paikalleen ja
    * jos palikka sopii niin muokkaa liikuvien palikoiden karttaa jos ei niin 
    * kääntää palikan takaisin ja ei tee mitään. (tähän liittyy myös monta private metodia)
    */
    // käänny   
    private void kaanny(String suunta) {
        Tetrispalikka palikka = terriskartta.getPalikka();
        int[][] uusikartta = terriskartta.luouusikarrtta();
        for (int xkartta = 0; xkartta < 10; xkartta++) { 
            for (int ykartta = 0; ykartta < 30; ykartta++) {
                if (terriskartta.getKartta()[xkartta][ykartta] == 2) {// etsii käänymispisteet tetris kartasta
                    kaanyvalitsesuunta(suunta, palikka); //kääntää tetrispalikasa olevan suunnan ja tetrispalikassa olevan matriisin
                    int[] a = etsikaatymispiste(palikka); // etsii käänymispisteen tetrispalikasta
                    int x = a[0];
                    int y = a[1];
                        
                    int xalaraja = xkartta - x;
                    int xylaraja = xkartta + (palikka.getX() - x);
                    int yalaraja = ykartta - y;
                    int yylaraja = ykartta + (palikka.getY() - y);

                    if (xalaraja < 0 || xylaraja > 9 || yalaraja < 0 || yylaraja > 29) { // tutkii ylärajat
                        kaanyvalitsesuuntatakas(suunta, palikka);
                        return;
                    } else {
                        int z = 0;
                        int k = 0;
                        for (int i = xalaraja; i < xylaraja; i++) {
                            for (int j = yalaraja; j < yylaraja; j++) {
                                uusikartta[i][j] = palikka.getTetrispalikka()[z][k];
                                k++;
                            }
                            z++;
                            k = 0;
                        }
                        for (int i = 0; i < 10; i++) { // tutkii ovatko palikat päällekkäin
                            for (int j = 0; j < 30; j++) {
                                if ((uusikartta[i][j] == 1 || uusikartta[i][j] == 1) && (terriskartta.getVanhatpalkat()[i][j] == 1 || terriskartta.getVanhatpalkat()[i][j] == 2)) {
                                    kaanyvalitsesuuntatakas(suunta, palikka);
                                    return;
                                }
                            }
                        }
                        terriskartta.setKartta(uusikartta); // kun tetris palikan pystyy kääntämään kääntää sen ja korvaa vanhan martiisin uudella.

                    }

                }

            }

        }

    }

    private void kaanyvalitsesuunta(String suunta, Tetrispalikka palikka) {
        if (suunta.equals("vasen")) {
            palikka.kaannavasemmalle();
        } else {
            palikka.kaannaoikealle();
        }

    }

    private void kaanyvalitsesuuntatakas(String suunta, Tetrispalikka palikka) {
        if (suunta.equals("vasen")) {
            palikka.kaannaoikealle();
        } else {
            palikka.kaannavasemmalle();
        }
    }

    private int[] etsikaatymispiste(Tetrispalikka palikka) {
        int[] k = new int[2]; 
        for (int xpalikka = 0; xpalikka < palikka.getX(); xpalikka++) {
            for (int ypalikka = 0; ypalikka < palikka.getY(); ypalikka++) {
                if (palikka.getTetrispalikka()[xpalikka][ypalikka] == 2) {
                    k[0] = xpalikka;
                    k[1] = ypalikka;
                }
            }
        }
        return k;
    }
}
