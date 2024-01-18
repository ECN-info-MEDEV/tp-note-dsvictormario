/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author murkp
 */
package org.centrale.ds_medev_mario_victor;

import java.util.Scanner;

public class Joueur {
    private String nom;
    private Grille grille;
    private Bateau[] navires;
    private Scanner scanner;

    public Joueur(String nom) {
        this.nom = nom;
        this.grille = new Grille(5, 5); 
        this.navires = new Bateau[3]; 
        this.scanner = new Scanner(System.in);
    }

    public void placerNavire(Bateau navire) {
        System.out.println(nom + ", vous allez placer votre " + navire.getNom() + ".");

        boolean positionValide = false;
        while (!positionValide) {
            try {
                System.out.println("Entrez les coordonnées pour placer votre " + navire.getNom() + " (format: x y): ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                positionValide = grille.positionnerNavire(navire, x, y, true);

                if (!positionValide) {
                    System.out.println("Position invalide, essayez à nouveau.");
                }
            } catch (Exception e) {
                System.out.println("Entrée invalide. Veuillez entrer des numéros.");
                scanner.next(); // To avoid infinite loop in case of input error
            }
        }
    }

    private Bateau choisirNavire() {
        System.out.println("Choisissez un navire à placer (1: Destroyer, 2: Cuirassé, 3: Porte-Avions):");
        int choix = scanner.nextInt();

        switch (choix) {
            case 1 -> {
                return new Destroyer();
            }
            case 2 -> {
                return new Cuirasse();
            }
            case 3 -> {
                return new PorteAvions();
            }
            default -> {
                System.out.println("Choix invalide. Par défaut, un Destroyer sera placé.");
                return new Destroyer();
            }
        }
    }

    public void attaquer(Joueur adversaire) {
        System.out.println(nom + ", choisissez les coordonnées pour attaquer (format: x y): ");

        boolean attaqueValide = false;
        while (!attaqueValide) {
            try {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                attaqueValide = adversaire.grille.recevoirAttaque(x, y);

                if (!attaqueValide) {
                    System.out.println("Attaque invalide, essayez à nouveau.");
                }
            } catch (Exception e) {
                System.out.println("Entrée invalide. Veuillez entrer des numéros.");
                scanner.next(); // Pour éviter une boucle infinie en cas d'erreur de saisie
            }
        }
    }

    public boolean aPerdu() {
        for (Bateau navire : navires) {
            if (!navire.estDetruit()) {
                return false;
            }
        }
        return true;
    }

    public String getNom() {
        return nom;
    }
}


