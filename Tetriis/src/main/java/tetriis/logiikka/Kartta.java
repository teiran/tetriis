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
public class Kartta {

    private int[][] liikuvatpalikat;
    private int[][] liikumattomatpalikat;
    private Tetrispalikka palikka;

    /* 
    * Pitää tetriksen kartoista huolta, kartta on pallikalle joka vielä liikkuu 
    * ja vanhatpalikat palikoille jotka jo asettuneet paikoilleen.
    * Näiden erottelu helpottaa liikuvan palan liikuttelua (muuten kartat tyhjä
    * matriiseja(10*30). 
     */
    public Kartta() {
        liikuvatpalikat = luouusikarrtta();
        liikumattomatpalikat = luouusikarrtta();
    }

    public int[][] getKartta() {
        return liikuvatpalikat;
    }

    public int[][] getVanhatpalkat() {
        return liikumattomatpalikat;
    }

    public void setKartta(int[][] kartta) {
        this.liikuvatpalikat = kartta;
    }

    public void setVanhatpalkat(int[][] vanhatpalkat) {
        this.liikumattomatpalikat = vanhatpalkat;
    }

    public Tetrispalikka getPalikka() {
        return palikka;
    }

    //molemmant kartat
    /* 
    *yhdistää mollemmat kartat grafiikalle
    *
    * @return molemmat kartat yhdessä matriisiisa
     */
    public int[][] molemmatkartat() {
        int[][] uusvanhakartta = luouusikarrtta();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 30; y++) {
                if (liikuvatpalikat[x][y] == 1 || liikumattomatpalikat[x][y] == 1 || liikuvatpalikat[x][y] == 2) {
                    uusvanhakartta[x][y] = 1;
                } else {
                    uusvanhakartta[x][y] = 0;
                }
            }
        }
        return uusvanhakartta;
    }


    /*
    * tallennakartat tallentaa liikumattomien palikoiden karttaan liikuvan kartan
    * (toisen kartan) tarkistaa myös onko rivi täynnä (tetriksen säännöt)
     */
    public void tallennakartat() { // tallentaa uudenpalikan karttaan
        int[][] uusvanhakartta = molemmatkartat();
        liikumattomatpalikat = uusvanhakartta;
        onkotaysirivi();
    }

    private void onkotaysirivi() {
        for (int y1 = 0; y1 < 30; y1++) {
            boolean onkorivitaysi = true;
            for (int x = 0; x < 10; x++) {
                if (liikumattomatpalikat[x][y1] == 0) {
                    onkorivitaysi = false;
                    break;
                }
            }
            if (onkorivitaysi) {
                for (int x = 0; x < 10; x++) {
                    liikumattomatpalikat[x][y1] = 0;
                }
                onkotaysirivi2();
            }
        }

    }

    private void onkotaysirivi2() {

        boolean t2 = true;
        int ylaraja = 0;
        for (int y = 0; y < 30; y++) {
            boolean t = false;
            if (t2) {
                for (int x = 0; x < 10; x++) {
                    if (liikumattomatpalikat[x][y] == 1) { //löydetään ensimmäinen ruutu joka sisältää tetris palikan
                        t2 = false;
                        ylaraja = y;
                        break;
                    }
                }
            }
            if (!t2) {
                for (int x = 0; x < 10; x++) {
                    if (liikumattomatpalikat[x][y] == 1) {
                        t = true;
                        break;
                    } 
                }
                if (!t) {
                    for (int y1 = y; y1 >= ylaraja; y1--) {
                        for (int x1 = 0; x1 < 10; x1++) {
                            if (y1 == 0) {
                                liikumattomatpalikat[x1][y1] = 0;
                            } else {
                                liikumattomatpalikat[x1][y1] = liikumattomatpalikat[x1][y1 - 1];
                            }

                        }
                    }
                }

            }

        }
    }

    /*
    * lopetus tutkii onko ehdotta täyttynyt joilla sarake on täynnä eikä pysty
    * laittamaan uutta tetris palkikkaa karttaan.
    * @return palauttaa ne sarakkeet jotaka on täynnä.
     */
    public int[] lopetus() {
        int[] taydetsarakkeet = new int[10];
        for (int i = 0; i < 10; i++) {
            if (liikumattomatpalikat[i][0] == 1) {
                taydetsarakkeet[i] = 1;
            }
        }
        return taydetsarakkeet;
    }

    /*
    * luo uuden 10*30 kokoisen kartan (matriisiin) joka on tyhjä (pelkkiä nollia)
    *
    * @return 10*30 martriisin joka on tyhkä
     */
    public int[][] luouusikarrtta() {// luo uuden kartan
        int[][] kartta2 = new int[10][30];
        for (int x = 0; x < 10; x++) { //luo uuden tyhjän kartan
            for (int y = 0; y < 30; y++) {
                kartta2[x][y] = 0;
            }
        }
        return kartta2;
    }

    /*
    * luo uuden tetrispalikan jonka tallettaa (kääntämistä varten) ja
    * laittaa sen karttaan.
     */
    public void uusipalikka() {
        liikuvatpalikat = luouusikarrtta();
        palikka = new Tetrispalikka();
        int u[][] = palikka.getTetrispalikka();
        for (int x = 0; x < 2; x++) { //luo kartaan uudenpalikan
            for (int y = 0; y < 5; y++) {
                if (u[x][y] == 1) {
                    liikuvatpalikat[x + 4][y] = 1; //scaalaus oikeaksi
                } else if (u[x][y] == 2) {
                    liikuvatpalikat[x + 4][y] = 2; //kääntö piste
                }
            }
        }

    }

    /*
    * turha metrodi jolla tutkin toimiiko peli
     */
    @Override
    public String toString() {
        int[][] k = molemmatkartat();
        String g = "";
        for (int[] is : k) {
            for (int i : is) {
                g += i + "";
            }
            g += "\n";
        }
        return g;
    }

}
