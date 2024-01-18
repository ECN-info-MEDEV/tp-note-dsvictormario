/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package org.centrale.ds_medev_mario_victor;
import java.util.logging.Logger;
/**
 *
 * @author murkp
 */
public class Cuirasse extends Bateau {
    Logger logger = Logger.getLogger(getClass().getName());
    public Cuirasse() {
        super("Cuirassé", 4); // Nom et taille do Cuirassé
    }
    // Cuirasse.java


    @Override
    public void afficherType() {
        logger.info("Cuirassé.");
    }
}
