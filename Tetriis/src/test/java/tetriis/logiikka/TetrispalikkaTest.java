/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriis.logiikka;

import java.util.ArrayList;
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
public class TetrispalikkaTest {

    private Tetrispalikka palikka;

    public TetrispalikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        palikka = new Tetrispalikka();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLuopalikka() {
        int[][] koko = palikka.getTetrispalikka();
        int summ1 = 0;
        for (int[] is : koko) {
            for (int i : is) {
                summ1++;
            }
        }
        assertEquals(summ1, 2 * 5);

    }
    
    @Test
    public void testgetXgetY() {
        Tetrispalikka h = new Tetrispalikka();
        for (int i = 0; i < 4; i++) {
            if (i%2 == 0) {
                assertEquals(h.getX(), 2);
                assertEquals(h.getY(), 5);
            } else {
                assertEquals(h.getX(), 5);
                assertEquals(h.getY(), 2);
            }
            
        }
    }
    
    @Test
    public void testKaantaminenoikealle() {
        Tetrispalikka h = new Tetrispalikka();
        assertEquals(h.getSuunta(), "a");
        h.kaannaoikealle();
        assertEquals(h.getSuunta(), "o");
        h.kaannaoikealle();
        assertEquals(h.getSuunta(), "y");
        h.kaannaoikealle();
        assertEquals(h.getSuunta(), "v");
        h.kaannaoikealle();
        assertEquals(h.getSuunta(), "a");
        int[][] k = h.getTetrispalikka().clone();
        h.kaannaoikealle();
        h.kaannaoikealle();
        h.kaannaoikealle();
        h.kaannaoikealle();
        assertArrayEquals(k, h.getTetrispalikka());
    }
    
    
    @Test
    public void testKaantaminenvasemmalle() {
        Tetrispalikka h = new Tetrispalikka();
        assertEquals(h.getSuunta(), "a");
        h.kaannavasemmalle();
        assertEquals(h.getSuunta(), "v");
        h.kaannavasemmalle();
        assertEquals(h.getSuunta(), "y");
        h.kaannavasemmalle();
        assertEquals(h.getSuunta(), "o");
        h.kaannavasemmalle();
        assertEquals(h.getSuunta(), "a");
        int[][] k = h.getTetrispalikka().clone();
        h.kaannavasemmalle();
        h.kaannavasemmalle();
        h.kaannavasemmalle();
        h.kaannavasemmalle();
        assertArrayEquals(k, h.getTetrispalikka());
    }


    @Test
    public void testGetTetrispalikka() {
        int[] random = new int[6];
        for (int i = 0; i < 1000; i++) {
            boolean onko = false;
            int[][] k = palikka.getTetrispalikka();
            if (k[0][0] == 1 && k[0][1] == 1 && k[1][0] == 1 && k[1][1] == 1) { //nelö
                onko = true;
                random[0] ++;
            } else if (k[0][0] == 1 && k[0][1] == 1 && k[1][1] == 1 && k[1][2] == 1) {//salama oikealle
                onko = true;
                random[1] ++;
            } else if (k[0][0] == 1 && k[0][1] == 1 && k[0][2] == 1 && k[0][3] == 1) {//suora
                onko = true;
                random[2] ++;
            } else if (k[0][0] == 1 && k[0][1] == 1 && k[0][2] == 1 && k[1][2] == 1) { // l:llä oikealle
                onko = true;
                random[3] ++;
            } else if (k[0][0] == 1 && k[0][1] == 1 && k[0][2] == 1 && k[1][1] == 1) { // t
                onko = true;
                random[4] ++;
            } else if (k[1][0] == 1 && k[1][1] == 1 && k[1][2] == 1 && k[0][2] == 1) { // l:llä vasemmalle
                onko = true;
                random[5] ++;
            } else if (k[1][0] == 1 && k[1][1] == 1 && k[0][1] == 1 && k[0][2] == 1) { // salama vasemmalle
                onko = true;
                random[6] ++;
            }
            assertEquals(onko, true);
            assertEquals((random[0]/1000.000) >= 0.5, true);
            assertEquals((random[1]/1000.000) >= 0.5, true);
            assertEquals((random[2]/1000.000) >= 0.5, true);
            assertEquals((random[3]/1000.000) >= 0.5, true);
            assertEquals((random[4]/1000.000) >= 0.5, true);
            assertEquals((random[5]/1000.000) >= 0.5, true);
        }
       

    }

}
