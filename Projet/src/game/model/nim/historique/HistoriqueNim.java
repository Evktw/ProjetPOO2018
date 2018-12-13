package game.model.nim.historique;

import game.model.nim.historique.MoveNim;
import game.model.common.Game;
import java.util.List;
import java.util.ArrayList;

public class HistoriqueNim {

    /**
     * Attributs
     */
    public List<MoveNim> listMoves= new ArrayList<>();          // Liste des Coups de la partie
    public String winner;                                       // Gagnant de la partie
    public int gameId;                                          // Identifiant de la partie correspondant à l'historique


    /**
     * Constructeur
     */
    public HistoriqueNim(ArrayList moves, String winn, int id ){
        this.listMoves = moves;
        this.winner = winn;
        this.gameId = id;
    }

    /**
     * Méthode permettant de récuperer la liste des Coups d'une partie
     */
    public List<MoveNim> addtoListMoves(MoveNim move) {
        this.listMoves.add(move);
        this.winner = (getPlayerById(move.PlayerId)).name;
        return listMoves;
    }

    /**
     * Getters & Setters
     */
    public List<MoveNim> getListMoves() {
        return listMoves;
    }

    public void setListMoves(List<MoveNim> listMoves) {
        this.listMoves = listMoves;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
