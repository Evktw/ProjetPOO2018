package game.model.nim.historique;

import game.model.nim.historique.MoveNim;
import java.util.List;
import java.util.ArrayList;

public class HistoriqueNim {

    /**
     * Attributs
     */
    public List<MoveNim> listMoves= new ArrayList<>();          // Liste des Coups de la partie
    public String winner;                                       // Gagnant de la partie
    public List<String> losers = new ArrayList<>();             // Perdant(s) de la partie
    public int gameId;                                          // Identifiant de la partie correspondant à l'historique


    /**
     * Constructeur
     */
    public HistoriqueNim(List moves, String winn,, int id ){
        listMoves =

    }


    /**
     * Getters & Setters
     */
}
