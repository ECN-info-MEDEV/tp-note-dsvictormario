/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.centrale.ds_medev_mario_victor;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

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
    /**
     * Test of affiche method, of class GrilleAdversaire.
     */
    @Test
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
    /**
     * Test of affiche method, of class GrilleAdversaire.
     */
    @Test
    public void testRecevoirAttaque() {
        // Redirigir System.out para capturar la salida
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Crear una instancia de Grille y configurar la situación del juego
        Grille tuClase = new Grille(3, 3 );  
        // Configurar las grillas de los jugadores según sea necesario

        // Llamar a la función recevoirAttaque con coordenadas válidas (puedes ajustar esto según tu implementación)
        boolean result = tuClase.recevoirAttaque(new Joueur("Joueur1"), 0, 0);

        // Restaurar la salida estándar
        System.setOut(System.out);

        // Verificar la salida esperada
        String expectedOutput = "Touche!\n";  // Ajusta esto según tu lógica de juego
        assertEquals(expectedOutput, outContent.toString());

        // Verificar el resultado de la función (puedes ajustar esto según tu lógica de juego)
        assertTrue(result);
    }

    
    
}
