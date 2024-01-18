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
public class Destroyer extends Bateau {
    Logger logger = Logger.getLogger(getClass().getName());
    public Destroyer() {
        super("Destroyer", 3); // Nom et taille do Destroyer
    }

    @Override
    public void afficherType() {
        logger.info("Destroyer.");
    }
}
