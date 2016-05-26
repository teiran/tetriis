package tetriis.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author tiera
 */
public class Tetrispalikka {
    private int[][] tetrispalikka;

    public Tetrispalikka() {
        tetrispalikka = luopalikka();
    }
    
    public int[][] luopalikka(){
        int t = (int)(Math.random()*6);
        int[][] k = new int[2][5];
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 5; y++) {
                k[x][y] = 0;
            }
        }
            switch (t) {
            case 0:  //neliö 
                    k[0][0]= 1;
                    k[0][1]= 1;
                    k[1][0]= 1;
                    k[1][1]= 1;
                    break;
            case 1: //salama oikealle
                    k[0][0]= 1;
                    k[0][1]= 1;
                    k[1][1]= 1;
                    k[1][2]= 1;
                    break;
            case 2:  // suora
                    for (int y = 0; y < 5; y++) {
                        k[0][y] = 1;
                    }
                    break;
            case 3:  // l:llä oikealle
                    for (int y = 0; y < 3; y++) {
                        k[0][y] = 1;
                    }
                    k[1][2] = 1;
                    break;
            case 4:  // t palikka 
                    for (int i = 0; i < 3; i++) {
                        k[0][i] = 1;
                    }
                    k[1][1]= 1;
                    break;
            case 5:   
                    for (int i = 0; i < 3; i++) {
                        k[1][i] = 1;
                    }
                    k[0][2] = 1;
                    break;
            case 6:   
                    k[0][1]= 1;
                    k[1][0]= 1;
                    k[1][1]= 1;
                    k[0][2]= 1;
                    break;
        }
        return k;
    }

    public int[][] getTetrispalikka() {
        return tetrispalikka;
    }
    
    
}
