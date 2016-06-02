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
public class Kartta {
    private int[][] kartta;
    private int[][] vanhatpalkat;
    private Tetrispalikka palikka;

    public Kartta() {
        kartta = luouusikarrtta();
        vanhatpalkat = luouusikarrtta();
    }
    
    
    public int[][] getKartta() {
        return kartta;
    }

    public int[][] getVanhatpalkat() {
        return vanhatpalkat;
    }

    public void setKartta(int[][] kartta) {
        this.kartta = kartta;
    }

    public void setVanhatpalkat(int[][] vanhatpalkat) {
        this.vanhatpalkat = vanhatpalkat;
    }

    public Tetrispalikka getPalikka() {
        return palikka;
    }

   
    

    
    
    public void tallennakartat() { // tallentaa uudenpalikan karttaan
        int[][] uusvanhakartta = luouusikarrtta();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 30; y++) {
                if (kartta[x][y] == 1 || vanhatpalkat[x][y] == 1 || kartta[x][y] == 2) { 
                    uusvanhakartta[x][y] = 1;
                } else {
                    uusvanhakartta[x][y] = 0;
                }
            }
        }
        vanhatpalkat = uusvanhakartta;
        onkotaysirivi();
    }

    private void onkotaysirivi(){
        int[][] k = luouusikarrtta();
        for (int x = 0; x < 10; x++) {
            boolean onkorivitaysi = true;
            for (int y = 0; y < 30; y++) {
                if (vanhatpalkat[x][y] == 0) {
                    onkorivitaysi = false;
                }
            }
            if (onkorivitaysi) {
                for (int y = 0; y < 30; y++) {
                    k[x][y] =  vanhatpalkat[x][y];
                }
            }
        }
        vanhatpalkat = k;
        
    }
    
  
    
    public int[][] luouusikarrtta() {// luo uuden kartan
        int[][] kartta2 = new int[10][30];
        for (int x = 0; x < 10; x++) { //luo uuden tyhjän kartan
            for (int y = 0; y < 30; y++) {
                kartta2[x][y] = 0;
            }
        }
        return kartta2;
    }

    public void uusipalikka() {
        palikka = new Tetrispalikka();
        int u[][] = palikka.getTetrispalikka();
        for (int x = 0; x < 2; x++) { //luo kartaan uudenpalikan
            for (int y = 0; y < 5; y++) {
                if (u[x][y] == 1) {
                    kartta[x + 4][y] = 1; //scaalaus oikeaksi
                } else if (u[x][y] == 2) {
                    kartta[x + 4][y] = 2; //kääntö piste
                }
            }
        }

    }

    @Override
    public String toString() {
        String g = "";
        for (int[] is : kartta) {
            for (int i : is) {
                g += i +"";
            }
            g += "\n";
        }
        return g;
    }
    
    
    
    
    
}
