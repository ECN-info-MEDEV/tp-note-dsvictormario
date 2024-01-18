/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author murkp
 */
import java.util.Scanner;
import org.centrale.ds_medev_mario_victor.Bateau;
import org.centrale.ds_medev_mario_victor.PorteAvions;
import org.centrale.ds_medev_mario_victor.Cuirasse;
import org.centrale.ds_medev_mario_victor.Destroyer;

import java.util.Scanner;

public class Joueur {
    private String nom;
    private Grille grille;
    private Bateau[] navires;
    private Scanner scanner;

    public Joueur(String nom) {
        this.nom = nom;
        this.grille = new Grille(5, 5); // Supondo que a classe Grille tem um construtor com largura e altura
        this.navires = new Bateau[1]; // Cada jogador tem um navio
        this.scanner = new Scanner(System.in);
    }

    public void placerNavires() {
        System.out.println(nom + ", vous allez placer votre navire.");

        // Aqui você pode expandir para permitir diferentes tipos de navios
        navires[0] = new Destroyer(); // Exemplo com um Destroyer

        boolean positionValide = false;
        while (!positionValide) {
            try {
                System.out.println("Entrez les coordonnées pour placer votre Destroyer (format: x y): ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                positionValide = grille.positionnerNavire(navires[0], x, y);

                if (!positionValide) {
                    System.out.println("Position invalide, essayez à nouveau.");
                }
            } catch (Exception e) {
                System.out.println("Entrée invalide. Veuillez entrer des numéros.");
                scanner.next(); // Pour éviter une boucle infinie en cas d'erreur de saisie
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

    // Ajoutez des getters ou des setters supplémentaires si nécessaire
}


