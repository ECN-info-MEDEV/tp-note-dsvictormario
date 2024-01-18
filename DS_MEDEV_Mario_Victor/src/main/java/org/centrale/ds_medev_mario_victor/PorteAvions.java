package org.centrale.ds_medev_mario_victor;

import java.util.logging.Logger;

/**
 * Représente un porte-avions dans le jeu de bataille navale.
 * Un porte-avions est un type de navire caractérisé par sa grande taille.
 * Il hérite de la classe {@link Bateau}.
 * 
 * @author Victor Meirelles
 * @author Mario Espinoza
 */
public class PorteAvions extends Bateau {
    Logger logger = Logger.getLogger(getClass().getName());

    /**
     * Constructeur pour PorteAvions.
     * Initialise un porte-avions avec un nom spécifique et une taille définie.
     */
    public PorteAvions() {
        super("Porte-Avions", 5); // Nom et taille du Porte-Avions
    }

    /**
     * Affiche le type de navire.
     * Cette méthode surcharge {@code afficherType} de la classe parente {@link Bateau}.
     */
    @Override
    public void afficherType() {
        logger.info("Je suis un Porte-Avions.");
    }
}

