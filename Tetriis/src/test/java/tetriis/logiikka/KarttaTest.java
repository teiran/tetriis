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

    /**
     * Test of luouusikarrtta method, of class Kartta.
     */
    @Test
    public void testLuouusikarrtta() {
        Kartta t = new Kartta();
        int [][] h = t.luouusikarrtta();
        int summ = 0;
        int maara = 0;
        for (int[] is : h) {
            for (int i : is) {
                summ += i;
                maara++;
            }
            
        }
        assertEquals(summ, 0);
        assertEquals(maara, 300);
        
    }

}
