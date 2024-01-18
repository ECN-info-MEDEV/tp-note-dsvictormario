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
// PorteAvions.java
public class PorteAvions extends Bateau {
    Logger logger = Logger.getLogger(getClass().getName());
    public PorteAvions() {
        super("Porte-Avions", 5); // Nom et taille du Porte-Avions
    }

    @Override
    public void afficherType() {
         logger.info("Porte-Avions.");
    }
}



// Destroyer.java


