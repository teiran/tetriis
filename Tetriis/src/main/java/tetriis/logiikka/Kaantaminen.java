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
public class Kaantaminen {

    private Kartta terriskartta;

    private int xalaraja;
    private int xylaraja;
    private int yalaraja;
    private int yylaraja;

    private int xkarttakaantymispite;
    private int ykarttakaanymispiste;

    private int xpalikkakaanymispiste;
    private int ypalikkakaanyumispiste;

    private String suunta;

    public Kaantaminen(Kartta terriskartta) {
        this.terriskartta = terriskartta;
    }

    /*
    * etsii tetrispalikan kääntymispiteen kääntää tämän, sovittaa paikalleen ja
    * jos palikka sopii niin muokkaa liikuvien palikoiden karttaa jos ei niin 
    * kääntää palikan takaisin ja ei tee mitään. (tähän liittyy myös monta private metodia)
     */
    // käänny  
    
    public Kartta kaanny(String suunta) {
        this.suunta = suunta;
        Tetrispalikka palikka = terriskartta.getPalikka();
        etsikaanytmispistekartta();
        if (xkarttakaantymispite != -1 && ykarttakaanymispiste != -1) {// etsii käänymispisteet tetris kartasta
            kaanyvalitsesuunta(suunta, palikka); //kääntää tetrispalikasa olevan suunnan ja tetrispalikassa olevan matriisin
            etsikaatymispiste(palikka); // etsii käänymispisteen tetrispalikasta
            ylajaalrajat(palikka);
            voikokaanyta(palikka);

        }
        return terriskartta;

    }

    private void voikokaanyta(Tetrispalikka palikka) {
        int[][] uusikartta = terriskartta.luouusikarrtta();
        if (xalaraja < 0 || xylaraja > 9 || yalaraja < 0 || yylaraja > 29) { // tutkii ylärajat
            kaanyvalitsesuuntatakas(suunta, palikka);
            System.out.println("sadadas");
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
            
            System.out.println("lolololol");
            for (int i = 0; i < 10; i++) { // tutkii ovatko palikat päällekkäin
                for (int j = 0; j < 30; j++) {
                    if ((uusikartta[i][j] == 1 || uusikartta[i][j] == 1) && (terriskartta.getVanhatpalkat()[i][j] == 1 || terriskartta.getVanhatpalkat()[i][j] == 2)) {
                        kaanyvalitsesuuntatakas(suunta, palikka);
                        System.out.println("lol");
                        return;
                    }
                }
            }
            
            terriskartta.setKartta(uusikartta); // kun tetris palikan pystyy kääntämään kääntää sen ja korvaa vanhan martiisin uudella.
        }
    }
    

    private void etsikaanytmispistekartta() {
        for (int xkartta1 = 0; xkartta1 < 10; xkartta1++) {
            for (int ykartta1 = 0; ykartta1 < 30; ykartta1++) {
                if (terriskartta.getKartta()[xkartta1][ykartta1] == 2) {
                    this.ykarttakaanymispiste = ykartta1;
                    this.xkarttakaantymispite = xkartta1;
                    return;
                }
            }
        }
        this.ykarttakaanymispiste = -1; //neliölle jolla ei ole kaanytmispitettä
        this.xkarttakaantymispite = -1;

    }

    private void ylajaalrajat(Tetrispalikka palikka) {

        this.xalaraja = xkarttakaantymispite - xpalikkakaanymispiste;
        this.xylaraja = xkarttakaantymispite + (palikka.getX() - xpalikkakaanymispiste);
        this.yalaraja = ykarttakaanymispiste - ypalikkakaanyumispiste;
        this.yylaraja = ykarttakaanymispiste + (palikka.getY() - ypalikkakaanyumispiste);
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

    private void etsikaatymispiste(Tetrispalikka palikka) {
        for (int xpalikka = 0; xpalikka < palikka.getX(); xpalikka++) {
            for (int ypalikka = 0; ypalikka < palikka.getY(); ypalikka++) {
                if (palikka.getTetrispalikka()[xpalikka][ypalikka] == 2) {
                    this.xpalikkakaanymispiste = xpalikka;
                    this.ypalikkakaanyumispiste = ypalikka;
                }
            }
        }

    }
}
