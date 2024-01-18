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
public class JoueurTest {
    
    public JoueurTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of placerNavire method, of class Joueur.
     */
    @Test
    public void testPlacerNavire() {
        System.out.println("placerNavire");
        Bateau navire = null;
        Joueur instance = null;
        instance.placerNavire(navire);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attaquer method, of class Joueur.
     */
    @Test
    public void testAttaquer() {
        System.out.println("attaquer");
        Joueur adversaire = null;
        Joueur instance = null;
        instance.attaquer(adversaire);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aPerdu method, of class Joueur.
     */
    @Test
    public void testAPerdu() {
        System.out.println("aPerdu");
        Joueur instance = null;
        boolean expResult = false;
        boolean result = instance.aPerdu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNom method, of class Joueur.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Joueur instance = null;
        String expResult = "";
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
