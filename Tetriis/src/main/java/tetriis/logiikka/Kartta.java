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
        for (int y1 = 0; y1 < 30; y1++) {
            boolean onkorivitaysi = true;
            for (int x = 0; x < 10; x++) {
                if (vanhatpalkat[x][y1] == 0) {
                    onkorivitaysi = false;
                    break;
                }
            }
            if (onkorivitaysi) {
                for (int x = 0; x < 10; x++) {
                     vanhatpalkat[x][y1] = 0;
                }
            }
        }
        ;
        
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
