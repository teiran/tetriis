package grafiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetriis.logiikka.Siirrot;

public class NappaimistonKuuntelija implements KeyListener {
    private Siirrot peli;
    private Component component;

    public NappaimistonKuuntelija(Siirrot peli, Component component) {
        this.peli = peli;
        this.component = component;
    }

    public Siirrot getPeli() {
        return peli;
    }

    public Component getComponent() {
        return component;
    }
    
    

    

    

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(peli);
        System.out.println("q,e,a,s,d");
        int g = e.getKeyChar();

        switch (g) {
            case KeyEvent.VK_Q:
                peli.kaannyvasemmalle();
                break;
            case KeyEvent.VK_E:
                peli.kaannyoikealle();
                break;
            case KeyEvent.VK_D:
                peli.liikuvasemmalle();
                break;
            case KeyEvent.VK_S:
                peli.liikualas();
                break;
            case KeyEvent.VK_A:
                peli.liikuoikealle();
                break;
            default:
                peli.liikualas();
                break;
    }
        
       

   

  
}

    @Override
    public void keyTyped(KeyEvent e) {
         
   }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
