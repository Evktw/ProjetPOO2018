package game.model.nim.historique;

import java.util.List;
import java.util.ArrayList;

public class HistoriqueNim {

    /**
     * Attributs
     */
    private List<MoveNim> listMoves= new ArrayList<>();          // Liste des Coups de la partie
    private String winner;                                       // Gagnant de la partie
    private int gameId;                                          // Identifiant de la partie correspondant à l'historique


    /**
     * Constructeur
     */
    public HistoriqueNim(int id){
        this.listMoves = this.getListMoves();
        this.winner = this.listMoves.get(listMoves.size()-1).getPlayerName();
        this.gameId = id;
        toto
    }

    /**
     * Méthode permettant de récuperer la liste des Coups d'une partie
     */
    public List<MoveNim> addtoListMoves(MoveNim move) {
        this.listMoves.add(move);
        return listMoves;
    }

    /**
     * Getters & Setters
     */
    private List<MoveNim> getListMoves() {
        return listMoves;
    }

    private void setListMoves(List<MoveNim> listMoves) {
        this.listMoves = listMoves;
    }

    private String getWinner() {
        return winner;
    }

    private void setWinner(String winner) {
        this.winner = winner;
    }

    private int getGameId() {
        return gameId;
    }

    private void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
