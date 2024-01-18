/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package org.centrale.ds_medev_mario_victor;



/**
 * Représente la grille de jeu pour le jeu de bataille navale.
 * Cette classe gère deux grilles distinctes, une pour chaque joueur,
 * et fournit des méthodes pour positionner les navires, afficher les grilles,
 * et gérer les attaques pendant le jeu.
 * 

 * @author Espinoza Mario
 * @author MEIRELLES Victor
 */

public class Grille {
    private int largeur;
    private int hauteur;
    private char[][] grilleJoueur1;
    private char[][] grilleJoueur2;
    private final static char EAU = '~';
    private final static char NAVIRE = 'N';
    private final static char TOUCHE = 'T';
    private final static char MANQUE = 'M';
    private Joueur joueur1;
    private Joueur joueur2;

    
    /**
     * Constructeur pour initialiser une grille de jeu avec une largeur et une hauteur données.
     * 
     * @param largeur La largeur de la grille.
     * @param hauteur La hauteur de la grille.
     */

    public Grille(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        grilleJoueur1 = new char[hauteur][largeur];
        grilleJoueur2 = new char[hauteur][largeur];
        initialiserGrille();
    }


    /**
     * Initialise les deux grilles de jeu pour les joueurs.
     * Chaque grille est remplie initialement avec des caractères représentant de l'eau.
     */

    private void initialiserGrille() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                grilleJoueur1[i][j] = EAU;
                grilleJoueur2[i][j] = EAU;
            }
        }
    }


    /**
     * Affiche la grille du joueur actuel et une vue partielle de la grille de l'adversaire.
     * La grille du joueur montre la position des navires, tandis que celle de l'adversaire
     * ne montre que les résultats des attaques.
     * 
     * @param joueurActuel Le joueur pour lequel les grilles sont affichées.
     */

    public void affiche(Joueur joueurActuel) {
        if(joueurActuel == this.joueur1){
            System.out.println(joueurActuel.getNom() + " - Votre Grille:");
        afficherGrilleComplete(grilleJoueur1);
        System.out.println(getAdversaire(joueurActuel).getNom() + " - Grille de l'Adversaire:");
        afficherGrilleAdversaire(grilleJoueur2);
        }
        
    }


    /**
     * Renvoie le joueur adverse.
     * 
     * @param joueur Le joueur pour lequel l'adversaire doit être déterminé.
     * @return Le joueur adverse.
     */

    private Joueur getAdversaire(Joueur joueur) {
        return joueur == joueur1 ? joueur2 : joueur1;
    }



    public String afficherGrilleComplete(char[][] grille) {
        String output="";
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                output= output +(grille[i][j] + " ");
            }
            output= output + "\n";
        }
        return  output;
    }

    public String afficherGrilleAdversaire(char[][] grilleAdversaire) {
        String output="";
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                char cellule = grilleAdversaire[i][j];
                if (cellule == TOUCHE || cellule == MANQUE) {
                    output= output +(cellule + " ");
                } else {
                    output= output + (EAU + " "); 
                }
            }
            output= output + "\n";
           
        }
        return output;
    }


 /**
     * Méthode pour positionner un navire sur la grille d'un joueur.
     * Demande au joueur s'il souhaite placer le navire horizontalement ou verticalement,
     * puis positionne le navire en conséquence si possible.
     * 
     * @param joueur Le joueur qui positionne le navire.
     * @param navire Le navire à positionner.
     * @param x La coordonnée x de départ pour le positionnement du navire.
     * @param y La coordonnée y de départ pour le positionnement du navire.
     * @return Vrai si le navire a été positionné avec succès, faux sinon.
     */
    public boolean positionnerNavire(Joueur joueur, Bateau navire, int x, int y) {
        System.out.println(joueur.getNom() + ", voulez-vous placer le navire horizontalement ou verticalement? (H/V)");
        String choix = joueur.getScanner().nextLine().toUpperCase();

        boolean peutPlacerHorizontal = (x + navire.getTaille() <= largeur);
        boolean peutPlacerVertical = (y + navire.getTaille() <= hauteur);

        if (choix.equals("H")) {
            if (peutPlacerHorizontal) {
                return positionnerHorizontal(joueur, navire, x, y);
            } else {
                System.out.println("Placement horizontal impossible. Essayez une autre position ou orientation.");
                return false;
            }
        } else if (choix.equals("V")) {
            if (peutPlacerVertical) {
                return positionnerVertical(joueur, navire, x, y);
            } else {
                System.out.println("Placement vertical impossible. Essayez une autre position ou orientation.");
                return false;
            }
        } else {
            System.out.println("Choix invalide. Veuillez entrer 'H' pour horizontal ou 'V' pour vertical.");
            return positionnerNavire(joueur, navire, x, y); 
        }
}


    /**
     * Positionne un navire de manière horizontale sur la grille d'un joueur.
     * 
     * @param joueur Le joueur qui positionne le navire.
     * @param navire Le navire à positionner.
     * @param x La coordonnée x de départ pour le positionnement du navire.
     * @param y La coordonnée y de départ pour le positionnement du navire.
     * @return Vrai si le navire a été positionné avec succès, faux sinon.
     */

    private boolean positionnerHorizontal(Joueur joueur, Bateau navire, int x, int y) {
        if(joueur==this.joueur1){
            if (x + navire.getTaille() > largeur) {
            System.out.println("Vous ne pouvez pas placer le navire ici, il dépasse de la grille horizontalement.");
            return false; 
            }

            for (int i = x; i < x + navire.getTaille(); i++) {
                if (grilleJoueur1[y][i] != EAU) {
                    System.out.println("Vous ne pouvez pas placer le navire ici, la position est déjà occupée.");
                    return false; 
                }
            }

            for (int i = x; i < x + navire.getTaille(); i++) {
                grilleJoueur1[y][i] = NAVIRE;
            }

            System.out.println("Navire placé horizontalement avec succès.");
            return true;
            }
        else{
            if (x + navire.getTaille() > largeur) {
            System.out.println("Vous ne pouvez pas placer le navire ici, il dépasse de la grille horizontalement.");
            return false; 
            }

            for (int i = x; i < x + navire.getTaille(); i++) {
                if (grilleJoueur2[y][i] != EAU) {
                    System.out.println("Vous ne pouvez pas placer le navire ici, la position est déjà occupée.");
                    return false; 
                }
            }

            for (int i = x; i < x + navire.getTaille(); i++) {
                grilleJoueur2[y][i] = NAVIRE;
            }

            System.out.println("Navire placé horizontalement avec succès.");
            return true;
        }
        

        
    }


    /**
     * Positionne un navire de manière verticale sur la grille d'un joueur.
     * 
     * @param joueur Le joueur qui positionne le navire.
     * @param navire Le navire à positionner.
     * @param x La coordonnée x de départ pour le positionnement du navire.
     * @param y La coordonnée y de départ pour le positionnement du navire.
     * @return Vrai si le navire a été positionné avec succès, faux sinon.
     */

    private boolean positionnerVertical(Joueur joueur, Bateau navire, int x, int y) {
        if(joueur == this.joueur1){
            if (y + navire.getTaille() > hauteur) {
            System.out.println("Vous ne pouvez pas placer le navire ici, il dépasse de la grille verticalement.");
            return false; 
            }

            for (int j = y; j < y + navire.getTaille(); j++) {
                if (grilleJoueur1[j][x] != EAU) {
                    System.out.println("Vous ne pouvez pas placer le navire ici, la position est déjà occupée.");
                    return false; 
                }
            }

            for (int j = y; j < y + navire.getTaille(); j++) {
                grilleJoueur1[j][x] = NAVIRE;
            }

            System.out.println("Navire placé verticalement avec succès.");
            return true;
        }
        else{
            if (y + navire.getTaille() > hauteur) {
            System.out.println("Vous ne pouvez pas placer le navire ici, il dépasse de la grille verticalement.");
            return false; 
            }

            for (int j = y; j < y + navire.getTaille(); j++) {
                if (grilleJoueur2[j][x] != EAU) {
                    System.out.println("Vous ne pouvez pas placer le navire ici, la position est déjà occupée.");
                    return false; 
                }
            }

            for (int j = y; j < y + navire.getTaille(); j++) {
                grilleJoueur2[j][x] = NAVIRE;
            }

            System.out.println("Navire placé verticalement avec succès.");
            return true;
        }

        
    }



    /**
     * Gère une tentative d'attaque sur la grille d'un joueur.
     * Vérifie si l'attaque touche un navire, manque, ou si le point a déjà été attaqué.
     * 
     * @param joueur Le joueur attaqué.
     * @param x La coordonnée x de l'attaque.
     * @param y La coordonnée y de l'attaque.
     * @return Vrai si l'attaque est valide (touche ou manque), faux si le point a déjà été attaqué ou est hors de la grille.
     */

    public boolean recevoirAttaque(Joueur joueur, int x, int y) {
        if(joueur == this.joueur1){
            if (x >= 0 && x < largeur && y >= 0 && y < hauteur) {
                switch (grilleJoueur1[y][x]) {
                    case NAVIRE -> {
                        grilleJoueur1[y][x] = TOUCHE;
                        System.out.println("Touche!");
                        return true;
                    }
                    case EAU -> {
                        grilleJoueur1[y][x] = MANQUE;
                        System.out.println("Manque!");
                        return true;
                    }
                    default -> { 
                        System.out.println("Vous avez déjà attaqué ce point.");
                        return false;
                    }
                }
            } else {
                System.out.println("Attaque en dehors de la grille!");
                return false;
            }
        }
        else{
            if (x >= 0 && x < largeur && y >= 0 && y < hauteur) {
                switch (grilleJoueur2[y][x]) {
                    case NAVIRE -> {
                        grilleJoueur2[y][x] = TOUCHE;
                        System.out.println("Touche!");
                        return true;
                    }
                    case EAU -> {
                        grilleJoueur2[y][x] = MANQUE;
                        System.out.println("Manque!");
                        return true;
                    }
                    default -> { 
                        System.out.println("Vous avez déjà attaqué ce point.");
                        return false;
                    }
                }
            } else {
                System.out.println("Attaque en dehors de la grille!");
                return false;
            }
        }
        
}


    /**
     * Gère le tour d'un joueur dans le jeu.
     * Permet au joueur de choisir les coordonnées pour attaquer et traite l'attaque.
     * 
     * @param joueur Le joueur qui a le tour.
     */

    public void tourDeJeu(Joueur joueur) {
        System.out.println(joueur.getNom() + ", c'est votre tour.");
        this.affiche(joueur);

        Joueur adversaire = getAdversaire(joueur);
        boolean attaqueValide = false;
        while (!attaqueValide) {
            try {
                System.out.println("Veuillez choisir les coordonnées pour attaquer (format: x y).\n" +
                                   "x est la colonne (0 à " + (largeur - 1) + ") et y est la ligne (0 à " + (hauteur - 1) + ").\n" +
                                   "Le point le plus en haut à gauche est (0, 0).");
                int x = joueur.getScanner().nextInt();
                int y = joueur.getScanner().nextInt();

                if (x >= 0 && x < largeur && y >= 0 && y < hauteur) {
                    attaqueValide = recevoirAttaque(adversaire, x, y); // Atacar o adversário
                } else {
                    System.out.println("Coordonnées hors de la grille. Veuillez réessayer.");
                }
            } catch (Exception e) {
                System.out.println("Entrée invalide. Veuillez entrer des numéros valides.");
                joueur.getScanner().next(); // Para evitar loop infinito em caso de erro de entrada
            }
        }
    }

}

