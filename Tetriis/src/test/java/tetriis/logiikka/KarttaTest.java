    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriis.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiera
 */
public class KarttaTest {
    
    public KarttaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getKartta method, of class Kartta.
     */
    @Test
    public void testGetKarttajagetvanhatpaikat() {
        Kartta k = new Kartta();
        int[][] t = k.getKartta();
        int[][] t2 = k.getVanhatpalkat();
        assertArrayEquals(t, t2);
        int[][] g = k.luouusikarrtta();
        assertArrayEquals(g, t);
        
        int[][] kartta2 = new int[10][30];
        for (int x = 0; x < 10; x++) { //luo uuden tyhjän kartan
            for (int y = 0; y < 30; y++) {
                kartta2[x][y] = 0;
            }
        }
        assertArrayEquals(kartta2, k.getKartta());
        assertArrayEquals(kartta2, k.getVanhatpalkat());
    }

    /**
     * Test of getVanhatpalkat method, of class Kartta.
     */
   

    /**
     * Test of setKartta method, of class Kartta.
     */
    @Test
    public void testSetKartta() {
        int[][] o = new int[1][1];
        Kartta t = new Kartta();
        t.setKartta(o);
        assertArrayEquals(t.getKartta(), o);
    }

    /**
     * Test of setVanhatpalkat method, of class Kartta.
     */
    @Test
    public void testSetVanhatpalkat() {
        int[][] o = new int[1][1];
        Kartta t = new Kartta();
        t.setVanhatpalkat(o);
        assertArrayEquals(t.getVanhatpalkat(), o);
    }

    /**
     * Test of getPalikka method, of class Kartta.
     */
    @Test
    public void testGetPalikka() {
        Kartta t = new Kartta();
        t.uusipalikka();
        Tetrispalikka k = t.getPalikka();
        int h = 0;
        int y = 0;
        for (int[] i: k.getTetrispalikka()) {
            for (int j : i) {
                h += j;
                y++;
            }
        }
        assertEquals(true , 5 == h || 4 == h);
        assertEquals(y, 10);
        
    }

    /**
     * Test of tallennakartat method, of class Kartta.
     */
    @Test
    public void testTallennakartat() {
        Kartta t = new Kartta();
        t.uusipalikka();
        t.tallennakartat();
        int h = 0;
        int y = 0;
        for (int[] i: t.getVanhatpalkat()) {
            for (int j : i) {
                h += j;
                y++;
            }
        }
        assertEquals(4, h);
        assertEquals(y, 300);
    }
    
    @Test
    public void testTallennakartat2(){
        Kartta t = new Kartta();
        int[][] o = t.luouusikarrtta();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 29) {
                    o[j][i] = 1;
                } else if (i == 28 && j > 0){
                    o[j][i] = 1;
                }
            }
        }
        t.setVanhatpalkat(o);
        t.tallennakartat();
        o = t.molemmatkartat();
        for (int i = 1; i < 10; i++) {
            assertEquals(1, o[i][29]); 
        }
        
    }
    
    public void testTallennakartta3(){
        Kartta t = new Kartta();
        int[][] o = t.luouusikarrtta();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 29) {
                    o[j][i] = 1;
                } else if (i == 28 && j > 0){
                    o[j][i] = 1;
                }
            }
        }
        t.setVanhatpalkat(o);
        t.tallennakartat();
        o = t.molemmatkartat();
        for (int i = 1; i < 10; i++) {
            assertEquals(1, o[i][29]); 
        }
    }

    /**
     * Test of luouusikarrtta method, of class Kartta.
     */
    @Test
    public void testLuouusikarrtta3() {
        Kartta t = new Kartta();
        int[][] o = t.luouusikarrtta();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 29) {
                    o[j][i] = 1;
                } else if (i == 28){
                    o[j][i] = 1;
                } else if (i == 27 &&(j ==0|| j==5)) {
                    o[j][i] = 1;
                }
            }
        }
        t.setVanhatpalkat(o);
        t.tallennakartat();
        o = t.molemmatkartat();
        for (int i = 0; i < 10; i++) {
            if (i== 0 || i == 5) {
                assertEquals(1, o[i][29]); 
            } else{
                assertEquals(0, o[i][29]); 
            }
        }
        
    }
    


}
