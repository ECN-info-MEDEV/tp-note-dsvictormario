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
    public void testTourDeJeu() {
        // Redirigir System.out para capturar la salida
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Configurar la entrada simulada para las coordenadas (0, 0)
        InputStream originalIn = System.in;
        String input = "0 0\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        // Crear una instancia de TuClase y llamar a tourDeJeu
        TuClase tuClase = new TuClase();  // Reemplaza "TuClase" con el nombre real de tu clase
        Joueur joueur = new Joueur("JoueurTest", new Scanner(System.in));
        tuClase.tourDeJeu(joueur);

        // Restaurar la entrada y salida estándar
        System.setOut(System.out);
        System.setIn(originalIn);

        // Verificar la salida esperada
        String expectedOutput = "JoueurTest, c'est votre tour.\n";
        expectedOutput += "[Affiche du jeu ici]\n";  // Asegúrate de reemplazar esto con la salida real de affiche(joueur)
        expectedOutput += "Veuillez choisir les coordonnées pour attaquer (format: x y).\n" +
                           "x est la colonne (0 à " + (tuClase.getLargeur() - 1) + ") et y est la ligne (0 à " + (tuClase.getHauteur() - 1) + ").\n" +
                           "Le point le plus en haut à gauche est (0, 0).\n";
        assertEquals(expectedOutput, outContent.toString());

        // Verificar que la función recevoirAttaque fue llamada con las coordenadas correctas
        // Aquí necesitarías algún método o lógica adicional para verificar la interacción con la lógica de juego.
        assertTrue(/* Lógica de verificación para recevoirAttaque */);
    }

    
    
}
