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

    public int[][] kartat() {
        return terriskartta.molemmatkartat();
    }

    /*
    * lopetus ehdon getteri
     */
    public boolean lopetus() {
        return lopetusehot;
    }

    private boolean lopetus2() {
        int[] h = terriskartta.lopetus();
        if (h[4] == 1 || h[5] == 1) {
            return false;
        }
        return true;
    }

    public void liikuvasemmalle() {
        Liikuminen vasen = new Liikuminen(terriskartta);
        vasen.liikuvasemmalle();
        terriskartta = vasen.getTerriskartta();
    }

    public void liikuoikealle() {
        Liikuminen oikea = new Liikuminen(terriskartta);
        oikea.liikuoikealle();
        terriskartta = oikea.getTerriskartta();
    }

    public void liikualas() {
        Liikuminen alas = new Liikuminen(terriskartta);
        alas.liikualas();
        terriskartta = alas.getTerriskartta();
        lopetusehot = lopetus2();
    }

    public void kaannyvasemmalle() {
        Kaantaminen k = new Kaantaminen(terriskartta);
        terriskartta = k.kaanny("vasen");
    }

    public void kaannyoikealle() {
        Kaantaminen k = new Kaantaminen(terriskartta);
        terriskartta = k.kaanny("");

    }

}
