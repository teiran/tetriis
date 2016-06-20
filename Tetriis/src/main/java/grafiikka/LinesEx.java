package grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import tetriis.logiikka.Siirrot;

public class LinesEx implements Runnable {

    private Siirrot peli;
    private Grafiikka grafiika;
    private JFrame frame;
    private Thread runner;
    private Container t;

    public LinesEx() {
        peli = new Siirrot();
        runner = new Thread(this);
        runner.start();
    }

    public void update(Container container) {
        container.remove(t);
        addComponents(container);
        frame.pack();
        frame.setVisible(true);
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
        grafiika.setFocusable(true);
        container.repaint();
        t = container;

    }

    public JFrame getFrame() {
        return frame;
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
        frame = new JFrame("Tetris");
        frame.setPreferredSize(new Dimension(50 * 10 + 100, 50 * 30 + 100));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        
        boolean k = peli.lopetus();
        while (k) {
            loop(lu);
            update(frame.getContentPane());
            k = peli.lopetus();

        }
    }

}
