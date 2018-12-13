package game.model.nim.historique;

public class MoveNim {


    /**
     * Attributs
     */
    private int spentMatches;                  // Nombre d'allumettes retirées lors d'un coup
    private int remainingMatches;              // Nombre d'allumettes restantes après un coup
    private String PlayerName;                 // Identifiant du joueur ayant effectué le coup
    private final int idMove;                  // Ordre des coups
    private static int compteur = 1;           // Compteur pour les identifiants


    /**
     * Constructeur d'un coup
     */
    public MoveNim (int nbS, String name, int nbR) {
        this.spentMatches = nbS;
        this.remainingMatches = nbR - this.spentMatches;
        this.PlayerName = name;
        this.idMove= compteur;
        compteur++;
    }

    /**
     * Getters & Setters
     */
    public int getIdMove() {
        return idMove;
    }

    public int getSpentMatches() {
        return spentMatches;
    }

    private void setSpentMatches(int spentMatches) {
        this.spentMatches = spentMatches;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    private void setPlayerName(String name) {
        PlayerName = name;
    }

    public int getRemainingMatches() {
        return remainingMatches;
    }

    public void setRemainingMatches(int remainingMatches) {
        this.remainingMatches = remainingMatches;
    }
}
