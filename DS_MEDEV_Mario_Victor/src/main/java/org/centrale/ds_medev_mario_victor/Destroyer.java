package org.centrale.ds_medev_mario_victor;

import java.util.logging.Logger;

/**
 * Représente un destroyer dans le jeu de bataille navale.
 * Le destroyer est un type de navire plus petit, caractérisé par sa taille moyenne.
 * Il hérite de la classe {@link Bateau} et a une taille spécifique.
 * Cette classe définit les caractéristiques et les comportements d'un destroyer.
 * 
 * @author Victor Meirelles
 * @autor Mario Espinoza
 */
public class Destroyer extends Bateau {
    Logger logger = Logger.getLogger(getClass().getName());

    /**
     * Constructeur pour Destroyer.
     * Initialise un destroyer avec un nom spécifique ("Destroyer") et une taille définie (3).
     */
    public Destroyer() {
        super("Destroyer", 3); // Nom et taille du Destroyer
    }

    /**
     * Affiche le type de navire.
     * Cette méthode surcharge {@code afficherType} de la classe parente {@link Bateau},
     * et utilise un logger pour enregistrer le type de navire.
     */
    @Override
    public void afficherType() {
        logger.info("Je suis un Destroyer.");
    }
}

