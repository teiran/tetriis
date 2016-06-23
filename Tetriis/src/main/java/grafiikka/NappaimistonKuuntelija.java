package grafiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import tetriis.logiikka.Siirrot;

public class NappaimistonKuuntelija implements KeyListener  {

    private Siirrot peli;
    private Grafiikka container;
    private LinesEx k;

    public NappaimistonKuuntelija(Siirrot peli, Grafiikka container, LinesEx k) {
        this.peli = peli;
        this.container = container;
        this.k = k;

    }

    public Grafiikka getContainer() {
        return container;
    }

    public Siirrot getPeli() {
        return peli;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int g = e.getKeyChar();

//        if (g == KeyEvent.VK_PAGE_DOWN) {
//            peli.kaannyvasemmalle();
//        } else if (g == KeyEvent.VK_DELETE) {
//            peli.kaannyoikealle();
//        } else if (g == KeyEvent.VK_LEFT) {
//            peli.liikuvasemmalle();
//        } else if (g == KeyEvent.VK_DOWN) {
//            peli.liikualas();
//        } else if (g == KeyEvent.VK_RIGHT) {
//            peli.liikuoikealle();
//        } else {
//            peli.liikualas();
//        } 
        switch (g) {
            case 'q':
                peli.kaannyvasemmalle();
                break;
            case 'e':
                peli.kaannyoikealle();
                break;
            case 'a':
                peli.liikuoikealle();
                break;
            case 's':
                peli.liikualas();
                break;
            case 'd':
                peli.liikuvasemmalle();
                break;
            default:
                peli.liikualas();
                break;
        }

        container.setFocusable(true);
        container.repaint();
        container.setVisible(true);
        container = new Grafiikka(peli);
        k.update(peli);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
