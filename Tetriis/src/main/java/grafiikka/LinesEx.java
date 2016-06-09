package grafiikka;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class LinesEx extends JFrame {
    private int[][] kartta;
    public LinesEx(int[][] k) {
        kartta = k;
        initUI();
    }
    
    public void update(){
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initUI() {

        add(new Grafiikka(kartta));
        
        setTitle("Lines");
        setSize(50*10+100, 50*30+100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }


}