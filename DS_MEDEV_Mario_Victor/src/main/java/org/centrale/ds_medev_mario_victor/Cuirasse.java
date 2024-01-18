/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package org.centrale.ds_medev_mario_victor;

/**
 *
 * @author murkp
 */
public class Cuirasse extends Bateau {
    public Cuirasse() {
        super("Cuirassé", 4); // Nom et taille do Cuirassé
    }
    // Cuirasse.java


    @Override
    public void afficherType() {
        System.out.println("Cuirassé.");
    }
}
