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
    private String suunta;
    private int x;
    private int y;
    /*
    * luo 2*5 matriisiin joka kuvaa tetris palikkaa.
    * arpoo tälle sopivista muodoista muodon (private metodi)
    * antaa tälle palikalle myös suunnan (kaikki palikat aluksi alaspäin)
    */
    public Tetrispalikka() {
        x = 2;
        y = 5;
        tetrispalikka = luopalikka();
        suunta = "a";
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    /*
    * kääntää palikan oikealle (private kaannav() kääntää myös matriisin)
    */
    
    public void kaannaoikealle(){
        if (suunta.equals("a")) {
            kaannao();
            suunta = "o";
        } else if (suunta.equals("o")) {
            kaannao();
            suunta = "y";
        } else if (suunta.equals("y")) {
            kaannao();
            suunta = "v";
        } else {
            kaannao();
            suunta = "a";
        }
    }
    private void kaannav(){
        switch (suunta) {
            case "a":
                {
                    x = 5;
                    y = 2;
                    int[][] k = new int[x][y];
                    for (int x1 = 0; x1 < 2; x1++) {
                        for (int y1 = 0; y1 < 5; y1++) {
                            k[y1][x1] = tetrispalikka[x1][y1];
                        }
                    }       tetrispalikka = k;
                    break;
                }
            case "o":
                {
                    x = 2;
                    y = 5;
                    int[][] k = new int[x][y];
                    for (int x1 = 0; x1 < 2; x1++) {
                        for (int y1 = 0; y1 < 5; y1++) {
                            k[x1][4 - y1] = tetrispalikka[y1][x1];
                        }
                    }       tetrispalikka = k;
                    break;
                }
            case "y":
                {
                    x = 5;
                    y = 2;
                    int[][] k = new int[x][y];
                    for (int x1 = 0; x1 < 2; x1++) {
                        for (int y1 = 0; y1 < 5; y1++) {
                            k[y1][x1] = tetrispalikka[x1][y1];
                        }
                    }       tetrispalikka = k;
                    break;
                }
            default:
                {
                    x = 2;
                    y = 5;
                    int[][] k = new int[x][y];
                    for (int x1 = 0; x1 < 2; x1++) {
                        for (int y1 = 0; y1 < 5; y1++) {
                            k[x1][4 - y1] = tetrispalikka[y1][x1];
                        }
                    }       tetrispalikka = k;
                    break;
                }
        }
        
    }
    
    /*
    * kääntää palikan vasemmalle (private kaannao() kääntää myös matriisin)
    */   
    public void kaannavasemmalle(){
        if (suunta.equals("o")) {
            kaannav();
            suunta = "a";
        } else if (suunta.equals("y")) {
            kaannav();
            suunta = "o";
        } else if (suunta.equals("v")) {
            kaannav();
            suunta = "y";
        } else {
            kaannav();
            suunta = "v";
        }
    }
    private void kaannao(){
        for (int i = 0; i < 3; i++) {
                kaannavasemmalle();
        }   
    }
    
    
    
    /*
    * luopalikka luo uuden tetrispalikan
    * 
    * @return matriisiin 2*5 jossa tettris palikan muoto
    */
    
    public int[][] luopalikka(){
        int t = (int)(Math.random()*7-1);//keksin jostain myöhemmin paremman random muutujan
        int[][] k = new int[x][y];
        for (int x1 = 0; x1 < x; x1++) {
            for (int y1 = 0; y1 < y; y1++) {
                k[x1][y1] = 0;
            }
        }
        luoPalikka2(t, k);
            
        return k;
    }

    public String getSuunta() {
        return suunta;
    }
    
    

    public int[][] getTetrispalikka() {
        return tetrispalikka;
    }

    private void luoPalikka2(int x, int[][] k){
        switch (x) {
            case 0:  //neliö 
                    k[0][0]= 1;
                    k[0][1]= 1;
                    k[1][0]= 1;
                    k[1][1]= 1;
                    break;
            case 1: //salama oikealle
                    k[0][0]= 1;
                    k[0][1]= 2;
                    k[1][1]= 1;
                    k[1][2]= 1;
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
                    k[1][1]= 1;
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
                    k[0][1]= 1;
                    k[1][0]= 1;
                    k[1][1]= 2;
                    k[0][2]= 1;
                    break;
    }
    
    }
    
    /*
    * toString oli hyödyllinen tarkistaessa.
    */
    @Override
    public String toString() {
        String g = "";
        for (int[] is : tetrispalikka) {
            for (int i : is) {
                g += i;
            }
            g += "\n";
        }
        return g;
    }
    
 
    
    
}
