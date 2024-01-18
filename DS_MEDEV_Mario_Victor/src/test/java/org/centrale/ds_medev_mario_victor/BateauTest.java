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
public class BateauTest {
    
    public BateauTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getNom method, of class Bateau.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Bateau instance = null;
        String expResult = "";
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaille method, of class Bateau.
     */
    @Test
    public void testGetTaille() {
        System.out.println("getTaille");
        Bateau instance = null;
        int expResult = 0;
        int result = instance.getTaille();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVie method, of class Bateau.
     */
    @Test
    public void testGetVie() {
        System.out.println("getVie");
        Bateau instance = null;
        int expResult = 0;
        int result = instance.getVie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reduireVie method, of class Bateau.
     */
    @Test
    public void testReduireVie() {
        System.out.println("reduireVie");
        Bateau instance = null;
        instance.reduireVie();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estDetruit method, of class Bateau.
     */
    @Test
    public void testEstDetruit() {
        System.out.println("estDetruit");
        Bateau instance = null;
        boolean expResult = false;
        boolean result = instance.estDetruit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherType method, of class Bateau.
     */
    @Test
    public void testAfficherType() {
        System.out.println("afficherType");
        Bateau instance = null;
        instance.afficherType();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class BateauImpl extends Bateau {

        public BateauImpl() {
            super("", 0);
        }

        public void afficherType() {
        }
    }
    
}
