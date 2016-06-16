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
                if (t.kartat()[i][j] == 1 || t.kartat()[i][j] == 2) {
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
                if (t.kartat()[i][j] == 1 || t.kartat()[i][j] == 2) {
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
                if (s.kartat()[i][j] == 1 || s.kartat()[i][j] == 2) {
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
                if (h[i][j] != 1 || h[i][j] != 2) {
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
                if (y.kartat()[j][i] == 1 || y.kartat()[j][i] == 2) {
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
                if (y.kartat()[j][i] == 1 || y.kartat()[j][i] == 2) {
                    if (j > t2) {
                        t2 = j;
                    }
                }
            }
        }
        assertEquals(t - 1, t2);
    }

    @Test
    public void testLiikuoikealle2() {
        System.out.println("liikuvasemmalle2");
        Siirrot y = new Siirrot();
        for (int i = 0; i < 10; i++) {
            y.liikuoikealle();
        }
        int o = 0;
        int[][] g = y.kartat();
        for (int[] is : g) {
            for (int i : is) {
                if (i == 1 || i == 2) {
                    o++;
                }
            }
        }
        assertEquals(4, o);
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
                if (y.kartat()[j][i] == 1 || y.kartat()[j][i] == 2) {
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
                if (y.kartat()[j][i] == 1 || y.kartat()[j][i] == 2) {
                    if (j > t2) {
                        t2 = j;
                    }
                }
            }
        }
        assertEquals(t - 1, t2);
    }

    @Test
    public void testLiikuvasemmalle2() {
        System.out.println("liikuvasemmalle2");
        Siirrot y = new Siirrot();
        for (int i = 0; i < 10; i++) {
            y.liikuvasemmalle();
        }
        int o = 0;
        int[][] g = y.kartat();
        for (int[] is : g) {
            for (int i : is) {
                if (i == 1 || i == 2) {
                    o++;
                }
            }
        }
        assertEquals(4, o);
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
                if (y.kartat()[j][i] == 1 || y.kartat()[j][i] == 2) {
                    if (i > t) {
                        t = i;
                    }
                }
            }
        }
        y.liikualas();
        int t2 = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                if (y.kartat()[j][i] == 1 || y.kartat()[j][i] == 2) {
                    if (i > t2) {
                        t2 = i;
                    }
                }
            }
        }
        assertEquals(t + 1, t2);
    }

    @Test
    public void testLiikualas2() {
        Siirrot y = new Siirrot();
        y.liikuoikealle();
        y.liikuoikealle();
        for (int i = 0; i < 30; i++) {
            y.liikualas();
        }
        int z = 0;
        int[][] f = y.kartat();
        for (int[] is : f) {
            for (int i : is) {
                if (i == 1 || i == 2) {
                    z++;
                }
            }
        }
        assertEquals(8, z);
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

    @Test
    public void testKaannyvasemalle2() {
        Siirrot y = new Siirrot();
        for (int i = 0; i < 10; i++) {
            y.liikualas();
        }
        int[][] x = y.kartat();
        for (int i = 0; i < 4; i++) {
            y.kaannyvasemmalle();
        }
        int[][] x2 = y.kartat();
        
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(x[j][i], x2[j][i]);
            }
        }
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
    
    
    @Test
    public void testKaannyoikealle2() {
        Siirrot y = new Siirrot();
        for (int i = 0; i < 10; i++) {
            y.liikualas();
        }
        int[][] x = y.kartat();
        for (int i = 0; i < 4; i++) {
            y.kaannyoikealle();
        }
        int[][] x2 = y.kartat();
        
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(x[j][i], x2[j][i]);
            }
        }
    }
   

}
