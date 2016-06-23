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
public class Onkorivitaysi {

    private int[][] liikumattomatpalikat;
    private int pisteet;
    private int monikerta;

    public Onkorivitaysi(int[][] kartat) {
        this.liikumattomatpalikat = kartat;
        onkotaysirivi();

    }

    public int[][] getLiikumattomatpalikat() {
        return liikumattomatpalikat;
    }

    public int getPisteet() {
        return pisteet;
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
                pisteet += 10 * monikerta;
                monikerta++;
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

}
