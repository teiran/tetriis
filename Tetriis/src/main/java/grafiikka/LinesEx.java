package grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import tetriis.logiikka.Siirrot;

public class LinesEx implements Runnable {

    private Siirrot peli;
    private Grafiikka grafiika;
    private JFrame frame;
    private Thread runner;
    private Container c;

    public LinesEx() {
        peli = new Siirrot();
    }

    public void update(Siirrot graf) {
        frame.getContentPane().removeAll();
        frame.remove(c);
        peli = graf;
        addComponents(frame.getContentPane());
        if (graf.lopetus()) {
            System.exit(0); // häviät pelin
            
        }

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
        c = container;
        grafiika = new Grafiikka(peli);
        container.add(grafiika);
        grafiika.setFocusable(true);
        frame.pack();
        frame.setVisible(true);
        container.repaint();

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
        grafiika = new Grafiikka(peli);
        addComponents(frame.getContentPane());
        NappaimistonKuuntelija k = new NappaimistonKuuntelija(peli, grafiika, this);
        frame.getContentPane().addKeyListener(k);
        frame.getContentPane().setFocusable(true);

    }

}
