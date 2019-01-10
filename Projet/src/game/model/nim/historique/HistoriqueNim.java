package game.model.nim.historique;

import java.util.Stack;

/**
 *
 * @author Opti-Pognon
 */

public class HistoriqueNim{

    /**
     * Attributs
     */
    private Stack<MoveNim> stack;

    private String winner;                                      // Gagnant de la partie
    private int gameId;                                         // Identifiant de la partie correspondant à l'historique
    private int size;                                           // Taille de l'Historique

    /**
     * Constructeur
     */
    public HistoriqueNim(int id){
        this.gameId = id;
        this.stack = new Stack<MoveNim>();
        this.size = this.stack.size();
    }

    /**
     * Méthode permettant d'empiler un coup dans l'historique
     */
    public void push (MoveNim move){
        this.stack.push(move);
        this.size++;
    }


    /**
     * Méthode permettant d'afficher l'historique
     */
    private void afficheHistorique(Stack s){
        while(!s.isEmpty()) {
            System.out.println(s.pop());
            afficheHistorique(s);
        }
        System.out.println("Fin de l'Historique");
    }

    /**
     * Getters & Setters
     */
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
