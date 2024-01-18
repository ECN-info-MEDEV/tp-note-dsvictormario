package org.centrale.ds_medev_mario_victor;

import java.util.logging.Logger;

/**
 * Représente un cuirassé dans le jeu de bataille navale.
 * Le cuirassé est un type de navire caractérisé par sa taille importante et sa robustesse.
 * Il hérite de la classe {@link Bateau} et possède des caractéristiques spécifiques, notamment sa taille.
 * Cette classe définit les attributs et comportements spécifiques d'un cuirassé.
 * 
 * @author Victor Meirelles
 * @autor Mario Espinoza
 */
public class Cuirasse extends Bateau {
    Logger logger = Logger.getLogger(getClass().getName());

    /**
     * Constructeur pour Cuirasse.
     * Initialise un cuirassé avec un nom spécifique ("Cuirassé") et une taille définie (4).
     */
    public Cuirasse() {
        super("Cuirassé", 4); // Nom et taille du Cuirassé
    }

    /**
     * Affiche le type de navire.
     * Cette méthode surcharge {@code afficherType} de la classe parente {@link Bateau},
     * et utilise un logger pour enregistrer le type de navire.
     */
    @Override
    public void afficherType() {
        logger.info("Je suis un Cuirassé.");
    }
}

