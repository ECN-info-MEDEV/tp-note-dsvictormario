/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package org.centrale.ds_medev_mario_victor;

/**
 *
 * @author murkp
 */
// Bateau.java
public abstract class Bateau {
    private String nom;
    private int taille;
    private int vie;

    public Bateau(String nom, int taille) {
        this.nom = nom;
        this.taille = taille;
        this.vie = taille; // A vida inicial é igual à tamanho do navio
    }

    public String getNom() {
        return nom;
    }

    public int getTaille() {
        return taille;
    }

    public int getVie() {
        return vie;
    }

    public void reduireVie() {
        if (vie > 0) {
            vie--;
        }
    }

    public boolean estDetruit() {
        return vie <= 0;
    }

    // Método abstrato que pode ser implementado pelas classes filhas
    public abstract void afficherType();
}

