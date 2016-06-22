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
public class Luotetrispalikka {

    private int[][] palikka;
    private int x;
    private int y;

    public Luotetrispalikka(int x, int y) {
        this.x = x;
        this.y = y;
        palikka = luopalikka();
    }

    public int[][] getPalikka() {
        return palikka;
    }

    public int[][] luopalikka() {
        int t = (int) (Math.random() * 7 - 1); //keksin jostain myöhemmin paremman random muutujan
        int[][] k = new int[x][y];
        for (int x1 = 0; x1 < x; x1++) {
            for (int y1 = 0; y1 < y; y1++) {
                k[x1][y1] = 0;
            }
        }
        luoPalikka2(t, k);

        return k;
    }

    private void luoPalikka2(int x, int[][] k) {
        switch (x) {
            case 0:  //neliö 
                k[0][0] = 1;
                k[0][1] = 1;
                k[1][0] = 1;
                k[1][1] = 1;
                break;
            case 1: //salama oikealle
                k[0][0] = 1;
                k[0][1] = 2;
                k[1][1] = 1;
                k[1][2] = 1;
                break;
            case 2:  // suora
                for (int y = 0; y < 4; y++) {
                    k[0][y] = 1;
                }
                k[0][1] = 2;
                break;
            case 3:  // l:llä oikealle
                for (int y = 0; y < 3; y++) {
                    k[0][y] = 1;
                }
                k[1][2] = 1;
                k[0][1] = 2;
                break;
            case 4:  // t palikka 
                for (int i = 0; i < 3; i++) {
                    k[0][i] = 1;
                }
                k[1][1] = 1;
                k[0][1] = 2;
                break;
            case 5:   //l:llä vasemmalle
                for (int i = 0; i < 3; i++) {
                    k[1][i] = 1;
                }
                k[0][2] = 1;
                k[1][1] = 2;
                break;
            case 6:
                k[0][1] = 1;
                k[1][0] = 1;
                k[1][1] = 2;
                k[0][2] = 1;
                break;
        }

    }
}
