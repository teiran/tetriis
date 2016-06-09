/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NappaimistonKuuntelija implements KeyListener {
    private char h;

    public char getH() {
        return h;
    }

    public NappaimistonKuuntelija() {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
         h  = e.getKeyChar();
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

  
}