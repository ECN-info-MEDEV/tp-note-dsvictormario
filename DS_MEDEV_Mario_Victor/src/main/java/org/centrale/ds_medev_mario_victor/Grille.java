/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package org.centrale.ds_medev_mario_victor;

/**
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

    public Grille(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        grilleJoueur1 = new char[hauteur][largeur];
        grilleJoueur2 = new char[hauteur][largeur];
        initialiserGrille();
    }

    private void initialiserGrille() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                grilleJoueur1[i][j] = EAU;
                grilleJoueur2[i][j] = EAU;
            }
        }
    }

    public void affiche(Joueur joueurActuel) {
        if(joueurActuel == this.joueur1){
            System.out.println(joueurActuel.getNom() + " - Votre Grille:");
        afficherGrilleComplete(grilleJoueur1);
        System.out.println(getAdversaire(joueurActuel).getNom() + " - Grille de l'Adversaire:");
        afficherGrilleAdversaire(grilleJoueur2);
        }
        
    }

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

