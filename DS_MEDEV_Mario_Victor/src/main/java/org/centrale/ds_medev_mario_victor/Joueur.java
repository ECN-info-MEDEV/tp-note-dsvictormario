package org.centrale.ds_medev_mario_victor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 * @author Espinoza Mario
 * @author MEIRELLES Victor
 */


import java.util.Scanner;

/**
    * Représente un joueur dans le jeu de bataille navale.
    * Chaque joueur gère un ensemble de navires et effectue des actions telles que 
    * placer des navires sur la grille et attaquer les navires adverses.
    * 
    * @author Espinoza Mario
    * @author MEIRELLES Victor
    */
public class Joueur {
    private String nom;
    private Bateau[] navires;
    private Scanner scanner;

    
    /**
     * Constructeur pour créer un nouveau joueur.
     * 
     * @param nom Le nom du joueur.
     */
    public Joueur(String nom) {
        this.nom = nom;
        this.navires = new Bateau[3];
        this.scanner = new Scanner(System.in);
    }

    /**
     * Permet au joueur de placer un navire sur la grille.
     * Le joueur entre les coordonnées où il souhaite placer son navire.
     * 
     * @param grille La grille sur laquelle le navire sera placé.
     * @param navire Le navire à placer sur la grille.
     */
    public void placerNavire(Grille grille, Bateau navire) {
        System.out.println(nom + ", vous allez placer votre " + navire.getNom() + ".");

        boolean positionValide = false;
        while (!positionValide) {
            try {
                System.out.println("Entrez les coordonnées pour placer votre " + navire.getNom() + " (format: x y): ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
              
                positionValide = grille.positionnerNavire(this, navire, x, y);
              
                if (!positionValide) {
                    System.out.println("Position invalide, essayez à nouveau.");
                }
            } catch (Exception e) {
                System.out.println("Entrée invalide. Veuillez entrer des numéros.");
                scanner.next(); // To avoid infinite loop in case of input error
            }
        }
    }
    
    /**
     * Permet au joueur de choisir un type de navire à placer sur la grille.
     * Le choix est fait à partir d'une liste de navires disponibles.
     * 
     * @return Le navire choisi par le joueur.
     */
    public Bateau choisirNavire() {
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

    /**
     * Vérifie si tous les navires du joueur sont détruits.
     * 
     * @return Vrai si tous les navires sont détruits, faux sinon.
     */
    public boolean aPerdu() {
        for (Bateau navire : navires) {
            if (!navire.estDetruit()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Obtient le nom du joueur.
     * 
     * @return Le nom du joueur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Obtient l'objet Scanner utilisé pour lire les entrées du joueur.
     * 
     * @return L'objet Scanner.
     */
    public Scanner getScanner() {
        return scanner;
    }
}
