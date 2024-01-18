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
    public void testAfficherGrilleComplete() {
        char[][] tab = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'}
        };

        Grille  grille = new Grille(3,3);  
        String expectedOutput = "a b c \nd e f \ng h i \n";
        String actualOutput = grille.afficherGrilleComplete(tab);

        assertEquals(expectedOutput, actualOutput);
    }
    public void testAfficherGrilleAdversaire() {
        char[][] grilleAdversaire = {
            {' ', 'X', 'O'},
            {'O', ' ', 'X'},
            {' ', 'O', ' '}
        };

        Grille tab = new Grille(3,3);  // Reemplaza "TuClase" con el nombre real de tu clase
        String expectedOutput = "~ T M \nM ~ T \n~ M ~ \n";
        String actualOutput = tab.afficherGrilleAdversaire(grilleAdversaire);

        assertEquals(expectedOutput, actualOutput);
    }

    
    
}
