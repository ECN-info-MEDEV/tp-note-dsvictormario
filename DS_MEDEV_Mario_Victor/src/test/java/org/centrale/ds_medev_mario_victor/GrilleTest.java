/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.centrale.ds_medev_mario_victor;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bebom
 */
public class GrilleTest {
    
    public GrilleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of affiche method, of class Grille.
     */
    @Test
    public void testAffiche() {
        System.out.println("affiche");
        Grille instance = null;
        instance.affiche();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of positionnerNavire method, of class Grille.
     */
    @Test
    public void testPositionnerNavire() {
        System.out.println("positionnerNavire");
        Bateau navire = null;
        int x = 0;
        int y = 0;
        boolean horizontal = false;
        Grille instance = null;
        boolean expResult = false;
        boolean result = instance.positionnerNavire(navire, x, y, horizontal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recevoirAttaque method, of class Grille.
     */
    @Test
    public void testRecevoirAttaque() {
        System.out.println("recevoirAttaque");
        int x = 0;
        int y = 0;
        Grille instance = null;
        boolean expResult = false;
        boolean result = instance.recevoirAttaque(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
