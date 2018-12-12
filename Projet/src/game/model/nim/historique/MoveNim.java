package game.model.nim.historique;

import game.model.nim.historique.MoveNim;

public class MoveNim {

    /**
     * Attributs
     */
    private int spentMatches;           // Nombre d'allumettes retirées lors d'un coup
    private int PlayerId;            // Identifiant du joueur ayant effectué le coup

    /**
     * Constructeur d'un coup
     */

    public Coup (int nb, int id) {
        this.spentMatches = nb;
        this.PlayerId = id;
    }

    /**
     * Getters & Setters
     */
    

}
