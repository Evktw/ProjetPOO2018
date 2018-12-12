package game.model.nim.historique;

public class MoveNim {


    /**
     * Attributs
     */
    private int spentMatches;           // Nombre d'allumettes retirées lors d'un coup
    private int remainingMatches;       // Nombre d'allumettes restantes après un coup
    private int PlayerId;               // Identifiant du joueur ayant effectué le coup
    private int idMove;           // Ordre des coups
    private static int compteur = 1;           // Compteur pour les identifiants


    /**
     * Constructeur d'un coup
     */
    public MoveNim (int nbS, int id, int nbR) {
        this.spentMatches = nbS;
        this.remainingMatches = nbR - this.spentMatches;
        this.PlayerId = id;
        this.idMove= compteur;
        compteur++;
    }


    /**
     * Getters & Setters
     */
    public int getSpentMatches() {
        return spentMatches;
    }

    public void setSpentMatches(int spentMatches) {
        this.spentMatches = spentMatches;
    }

    public int getPlayerId() {
        return PlayerId;
    }

    public void setPlayerId(int playerId) {
        PlayerId = playerId;
    }

    public int getRemainingMatches() {
        return remainingMatches;
    }

    public void setRemainingMatches(int remainingMatches) {
        this.remainingMatches = remainingMatches;
    }
}
