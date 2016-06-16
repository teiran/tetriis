package grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Scanner;
import javax.swing.JFrame;
import tetriis.logiikka.Siirrot;

public class LinesEx extends JFrame implements Runnable {

    private Siirrot peli;
    private Grafiikka grafiika;

    public LinesEx() {
        peli = new Siirrot();

        //initUI();
    }

    public void update(Container container) {
        container.add(grafiika);
    }

//    private void initUI() {
//
//        add(new Grafiikka(kartta));
//        
//        setTitle("Lines");
//        setSize(50*10+100, 50*30+100);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//    }
    private void addComponents(Container container) {
        grafiika = new Grafiikka(peli.kartat());
        container.add(grafiika);
        

    }

    private void loop(Scanner lu) {
        System.out.println(peli);
        System.out.println("q,e,a,s,d");
        String g = lu.nextLine();

        switch (g) {
            case "q":
                peli.kaannyvasemmalle();
                break;
            case "e":
                peli.kaannyoikealle();
                break;
            case "d":
                peli.liikuvasemmalle();
                break;
            case "s":
                peli.liikualas();
                break;
            case "a":
                peli.liikuoikealle();
                break;
            default:
                peli.liikualas();
                break;
        }

    }

    @Override
    public void run() {
        Scanner lu = new Scanner(System.in);
        addComponents(this.getContentPane());
        this.setTitle("Lines");
        this.setPreferredSize(new Dimension(50 * 10 + 100, 50 * 30 + 100));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        boolean k = peli.lopetus();
        while (k) {
            update(this.getContentPane());
            loop(lu);
            k = peli.lopetus();
            
        }
    }

}
