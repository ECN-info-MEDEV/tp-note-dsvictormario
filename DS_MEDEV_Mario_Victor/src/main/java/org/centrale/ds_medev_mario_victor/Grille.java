/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package org.centrale.ds_medev_mario_victor;

/**
 *
 * @author murkp
 */
public class Grille{
    private int largeur;
    private int hauteur;
    private char[][] grille;
    private final char EAU = '~';
    private final char NAVIRE = 'N';
    private final char TOUCHE = 'T';
    private final char MANQUE = 'M';

    public Grille(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        grille = new char[hauteur][largeur];
        initialiserGrille();
    }

    private void initialiserGrille() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                grille[i][j] = EAU;
            }
        }
    }

    public void affiche() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean positionnerNavire(Bateau navire, int x, int y, boolean horizontal) {
        if (horizontal) {
            return positionnerHorizontal(navire, x, y);
        } else {
            return positionnerVertical(navire, x, y);
        }
    }

    private boolean positionnerHorizontal(Bateau navire, int x, int y) {
        if (x + navire.getTaille() > largeur) {
            System.out.println("Vous ne pouvez pas placer le navire ici, il dépasse de la grille horizontalement.");
            return false; 
        }
        for (int i = x; i < x + navire.getTaille(); i++) {
            if (grille[y][i] != EAU) {
                System.out.println("Vous ne pouvez pas placer le navire ici, la position est déjà occupée.");
                return false; 
            }
        }
        for (int i = x; i < x + navire.getTaille(); i++) {
            grille[y][i] = NAVIRE;
        }
        System.out.println("Navire placé horizontalement avec succès.");
        return true;
    }

    private boolean positionnerVertical(Bateau navire, int x, int y) {
        if (y + navire.getTaille() > hauteur) {
            System.out.println("Vous ne pouvez pas placer le navire ici, il dépasse de la grille verticalement.");
            return false; 
        }
        for (int j = y; j < y + navire.getTaille(); j++) {
            if (grille[j][x] != EAU) {
                System.out.println("Vous ne pouvez pas placer le navire ici, la position est déjà occupée.");
                return false; 
            }
        }
        for (int j = y; j < y + navire.getTaille(); j++) {
            grille[j][x] = NAVIRE;
        }
        System.out.println("Navire placé verticalement avec succès.");
        return true;
    }


    public boolean recevoirAttaque(int x, int y) {
        if (x >= 0 && x < largeur && y >= 0 && y < hauteur) {
            if (grille[y][x] == NAVIRE) {
                grille[y][x] = TOUCHE;
                System.out.println("Touche!");
                return true;
            } else if (grille[y][x] == EAU) {
                grille[y][x] = MANQUE;
                System.out.println("Manque!");
                return true;
            }
        }
        return false;
    }

    

    
}

