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
public class KaantaminenTest {
    
    public KaantaminenTest() {
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
     * Test of kaanny method, of class Kaantaminen.
     */
    @Test
    public void testKaanny() {
        System.out.println("kaanny");
        Kartta ka = new Kartta();
        Kaantaminen k = new Kaantaminen(ka);
        ka.uusipalikka();
        
        int u = 0;
        for (int i = 0; i < 4; i++) {
            k.kaanny("vasen");
        }
        
        
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                if(ka.getKartta()[j][i] == 1 ||ka.getKartta()[j][i] == 2){
                    u++;
                }
            }
        }
        assertEquals(4, u);
    }
    
}
