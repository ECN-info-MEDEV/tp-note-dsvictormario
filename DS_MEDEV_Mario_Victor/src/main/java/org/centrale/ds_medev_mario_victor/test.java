package org.centrale.ds_medev_mario_victor;


/**
 * Classe principale pour lancer le jeu de bataille navale.
 * Cette classe configure et démarre le jeu, y compris la création de la grille,
 * l'initialisation des joueurs et la gestion des tours de jeu.
 * 
 * @author Victor Meirelles
 * @autor Mario Espinoza
 */
public class test {
    /**
     * Point d'entrée principal du jeu.
     * Configure la grille, les joueurs et démarre le jeu.
     * 
     * @param args Les arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        
        Grille grille = new Grille(5, 5);

        
        Joueur joueur1 = new Joueur("Joueur 1");
        Joueur joueur2 = new Joueur("Joueur 2");

        
        placerTousLesNavires(joueur1, grille);
        placerTousLesNavires(joueur2, grille);

        
        while (!joueur1.aPerdu() && !joueur2.aPerdu()) {
            grille.tourDeJeu(joueur1);
            if (!joueur2.aPerdu()) {
                grille.tourDeJeu(joueur2);
            }
        }
        if (joueur1.aPerdu()) {
            System.out.println(joueur2.getNom() + " a gagné!");
        } else {
            System.out.println(joueur1.getNom() + " a gagné!");
        }
    }
    /**
     * Permet à un joueur de placer tous ses navires sur la grille.
     * Le joueur choisit la position et l'orientation de chaque navire.
     * 
     * @param joueur Le joueur qui place les navires.
     * @param grille La grille sur laquelle les navires sont placés.
     */
    private static void placerTousLesNavires(Joueur joueur, Grille grille) {
        System.out.println(joueur.getNom() + ", c'est votre tour de placer vos navires.");
        System.out.println("La grille a une taille de 5x5. Les coordonnées vont de (0,0) à (4,4).");

        for (int i = 0; i < 3; i++) {
            Bateau navire = joueur.choisirNavire();
            System.out.println("Placement de " + navire.getNom() + ". Sa taille est " + navire.getTaille() + ".");
            System.out.println("Pour positionner votre navire, choisissez une coordonnée initiale (x y) et une orientation (H pour horizontal, V pour vertical).");
            System.out.println("En orientation horizontale (H), le navire s'étendra vers la droite à partir du point (x, y).");
            System.out.println("En orientation verticale (V), le navire s'étendra vers le bas à partir du point (x, y).");

            boolean positionValide = false;
            while (!positionValide) {
                System.out.println("Entrez les coordonnées (x y):");
                int x = joueur.getScanner().nextInt();
                int y = joueur.getScanner().nextInt();

                grille.positionnerNavire(joueur, navire, x, y);

                if (!positionValide) {
                    System.out.println("Position invalide ou navire hors de la grille. Essayez à nouveau.");
                }
            }
        }
    }

    
}

