
package org.centrale.ds_medev_mario_victor;

/**
 * Classe abstraite représentant un bateau dans le jeu de bataille navale.
 * Cette classe fournit les caractéristiques communes à tous les types de bateaux,
 * telles que le nom, la taille et les points de vie.
 * 
 * Les classes dérivées représentent différents types de navires avec des caractéristiques spécifiques.
 * 
 * @author Victor Meirelles
 * @autor Mario Espinoza
 */

public abstract class Bateau {
    private String nom;
    private int taille;
    private int vie;

    
    /**
     * Constructeur pour la classe Bateau.
     * 
     * @param nom Le nom du bateau.
     * @param taille La taille du bateau, qui détermine également les points de vie initiaux.
     */
    protected Bateau(String nom, int taille) {
        this.nom = nom;
        this.taille = taille;
        this.vie = taille; 
    }

    /**
     * Obtient le nom du bateau.
     * 
     * @return Le nom du bateau.
     */

    public String getNom() {
        return nom;
    }


    /**
     * Obtient la taille du bateau.
     * 
     * @return La taille du bateau.
     */

    public int getTaille() {
        return taille;
    }


    /**
     * Obtient les points de vie actuels du bateau.
     * 
     * @return Les points de vie du bateau.
     */

    public int getVie() {
        return vie;
    }


    /**
     * Réduit les points de vie du bateau.
     * Cette méthode est appelée lorsqu'un bateau est touché par un tir.
     */

    public void reduireVie() {
        if (vie > 0) {
            vie--;
        }
    }


    /**
     * Vérifie si le bateau est détruit (c'est-à-dire que les points de vie sont à zéro ou moins).
     * 
     * @return Vrai si le bateau est détruit, faux sinon.
     */

    public boolean estDetruit() {
        return vie <= 0;
    }


    /**
     * Méthode abstraite pour afficher le type de bateau.
     * Les classes dérivées doivent implémenter cette méthode pour indiquer leur type spécifique.
     */
    public abstract void afficherType();
}


