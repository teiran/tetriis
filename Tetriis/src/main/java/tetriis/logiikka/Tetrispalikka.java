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
        Luotetrispalikka k = new Luotetrispalikka(x, y);
        tetrispalikka = k.getPalikka();
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
    public void kaannaoikealle() {
        if (suunta.equals("a")) {
            kaannao();
        } else if (suunta.equals("o")) {
            kaannao();
        } else if (suunta.equals("y")) {
            kaannao();
        } else {
            kaannao();
        }
    }

    private void kaannav() {
        switch (suunta) {
            case "a":
                x = 5;
                y = 2;
                int[][] k = new int[x][y];
                for (int x1 = 0; x1 < 2; x1++) {
                    for (int y1 = 0; y1 < 5; y1++) {
                        k[4 - y1][x1] = tetrispalikka[x1][y1];
                    }
                }
                tetrispalikka = k;
                break;

            case "o":
                x = 2;
                y = 5;
                int[][] k1 = new int[x][y];
                for (int x1 = 0; x1 < 2; x1++) {
                    for (int y1 = 0; y1 < 5; y1++) {
                        k1[1 - x1][y1] = tetrispalikka[y1][x1];
                    }
                }
                tetrispalikka = k1;
                break;

            case "y":
                x = 5;
                y = 2;
                int[][] k2 = new int[x][y];
                for (int x1 = 0; x1 < 2; x1++) {
                    for (int y1 = 0; y1 < 5; y1++) {
                        k2[4 - y1][x1] = tetrispalikka[x1][y1];
                    }
                }
                tetrispalikka = k2;
                break;

            default:
                x = 2;
                y = 5;
                int[][] k3 = new int[x][y];
                for (int x1 = 0; x1 < 2; x1++) {
                    for (int y1 = 0; y1 < 5; y1++) {
                        k3[1 - x1][y1] = tetrispalikka[y1][x1];
                    }
                }
                tetrispalikka = k3;
                break;

        }

    }

    /*
    * kääntää palikan vasemmalle (private kaannao() kääntää myös matriisin)
     */
    public void kaannavasemmalle() {
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

    private void kaannao() {
        for (int i = 0; i < 3; i++) {
            kaannavasemmalle();
        }
    }

    /*
    * luopalikka luo uuden tetrispalikan
    * 
    * @return matriisiin 2*5 jossa tettris palikan muoto
     */
    
    public String getSuunta() {
        return suunta;
    }

    public int[][] getTetrispalikka() {
        return tetrispalikka;
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
