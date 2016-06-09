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
public class SiirrotTest {
    
    public SiirrotTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Siirrot t = new Siirrot();
        int l = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 30; j++) {
                if (t.kartat()[i][j]==1||t.kartat()[i][j]==2) {
                    l++;
                }
            }
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        Siirrot t = new Siirrot();
        int l = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 30; j++) {
                if (t.kartat()[i][j]==1||t.kartat()[i][j]==2) {
                    l++;
                }
            }
        }
    }
    
    @Before
    public void setUp() {
    
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of toString method, of class Siirrot.
     */
   

    /**
     * Test of kartat method, of class Siirrot.
     */
    @Test
    public void testKartat() {
        Siirrot s = new Siirrot();
        System.out.println("kartat");
        int g = 0;
        int l = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 30; j++) {
                if (s.kartat()[i][j]==1||s.kartat()[i][j]==2) {
                    l++;
                }
            }
        }
        assertEquals(4, l);
        
    }

    /**
     * Test of lopetus method, of class Siirrot.
     */
    @Test
    public void testLopetus() {
        Siirrot t = new Siirrot();
        int[][] h = t.kartat();
        boolean r = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 30; j++) {
                if (h[i][j]!=1||h[i][j]!=2) {
                    r = false;
                    break;
                }
            }
            if (r) {
                break;
            }
            r = true;
        }
        
        assertEquals(t.lopetus(), r);
    }

    /**
     * Test of liikuoikealle method, of class Siirrot.
     */
    @Test
    public void testLiikuoikealle() {
        Siirrot y = new Siirrot();
        int t = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                if (y.kartat()[j][i] == 1 ||y.kartat()[j][i] == 2) {
                    if (j > t) {
                        t = j;
                    }
                }
            }
        }
        
        y.liikuoikealle();
        int t2 = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                if (y.kartat()[j][i] == 1 ||y.kartat()[j][i] == 2) {
                    if (j > t2) {
                        t2 = j;
                    }
                }
            }
        }
        assertEquals(t-1, t2);
    }

    /**
     * Test of liikuvasemmalle method, of class Siirrot.
     */
    @Test
    public void testLiikuvasemmalle() {
        System.out.println("liikuvasemmalle");
        Siirrot y = new Siirrot();
        int t = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                if (y.kartat()[j][i] == 1 ||y.kartat()[j][i] == 2) {
                    if (j > t) {
                        t = j;
                    }
                }
            }
        }
        y.liikuoikealle();
        int t2 = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                if (y.kartat()[j][i] == 1 ||y.kartat()[j][i] == 2) {
                    if (j > t2) {
                        t2 = j;
                    }
                }
            }
        }
        assertEquals(t-1, t2);
    }

    /**
     * Test of liikualas method, of class Siirrot.
     */
    @Test
    public void testLiikualas() {
        System.out.println("liikualas");
        Siirrot y = new Siirrot();
        int t = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                if (y.kartat()[j][i] == 1 ||y.kartat()[j][i] == 2) {
                    if (i > t) {
                        t = j;
                    }
                }
            }
        }
        y.liikuoikealle();
        int t2 = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                if (y.kartat()[j][i] == 1 ||y.kartat()[j][i] == 2) {
                    if (i > t2) {
                        t2 = j;
                    }
                }
            }
        }
        assertEquals(t-1, t2);
    }

    /**
     * Test of kaannyvasemmalle method, of class Siirrot.
     */
    @Test
    public void testKaannyvasemmalle() {
        System.out.println("kaannyvasemmalle");
        Siirrot y = new Siirrot(); // testaa keskipisteen
        int t = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                if (y.kartat()[j][i] == 2) {
                    t = j;
                }
            }
        }
        y.liikuoikealle();
        int t2 = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                if (y.kartat()[j][i] == 2) {
                    t2 = j;

                }
            }
        }
        assertEquals(t, t2);
    }

    /**
     * Test of kaannyoikealle method, of class Siirrot.
     */
    @Test
    public void testKaannyoikealle() {
        System.out.println("kaannyoikealle");
        Siirrot y = new Siirrot();
        int t = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                if (y.kartat()[j][i] == 2) {
                    if (i > t) {
                        t = j;
                    }
                }
            }
        }
        y.liikuoikealle();
        int t2 = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                if (y.kartat()[j][i] == 2) {
                    if (i > t2) {
                        t2 = j;
                    }
                }
            }
        }
        assertEquals(t, t2);
    }
    
}
