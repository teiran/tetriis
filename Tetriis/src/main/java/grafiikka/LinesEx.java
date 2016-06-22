package grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
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
        grafiika = new Grafiikka(peli.kartat());
        container.add(grafiika);
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
        frame.addKeyListener(new NappaimistonKuuntelija(peli, container));
        grafiika.setFocusable(true);
        container.repaint();
        t = container;
        frame.addKeyListener(new NappaimistonKuuntelija(peli, container));

    }

    public JFrame getFrame() {
        return frame;
    }

    @Override
    public void run() {
        frame = new JFrame("Tetris");
        frame.setPreferredSize(new Dimension(50 * 10 + 100, 50 * 30 + 100));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);

        boolean k = peli.lopetus();
        while (k) {
            update(frame.getContentPane());
            k = peli.lopetus(); 

        }
    }

}
