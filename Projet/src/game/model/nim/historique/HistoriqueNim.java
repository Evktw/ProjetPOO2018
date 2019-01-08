package game.model.nim.historique;

/**
 *
 * @author Opti-Pognon
 */

public class HistoriqueNim {

    /**
     * Attributs
     */
    private class Moves {
        private MoveNim move;
        private Moves next;

        private Moves(MoveNim move, Moves next) {
            this.move = move;
            this.next = next;
        }
    }

    private int size;                                             // Taille de l'Historique
    private Moves firstMove;                                      // Sommet de la Pile de l'Historique
    private String winner;                                       // Gagnant de la partie
    private int gameId;                                          // Identifiant de la partie correspondant à l'historique


    /**
     * Constructeur
     */
    public HistoriqueNim(int id){
        this.firstMove = null;
        this.size = 0;
        this.gameId = id;
    }

    /**
     * Méthode permettant d'empiler un coup dans l'historique
     */
    public void push (MoveNim move){
        Moves temp = this.firstMove;
        this.firstMove = new Moves(move, temp);
        this.size++;
    }

    /**
     * Méthode permettant de dépiler le premier coup de l'historique
     */
    public int popS(){
        if(!this.isVide()){
            this.firstMove = this.firstMove.next;
            size = size - 1;
        }
        return size;
    }

    /**
     * Méthode permettant de dépiler un coup n de l'historique
     * @param n
     * @return size
     */
    //!\ Si n sommet de la pile le cas ne sera pas traité !  /!\
    public int popN(MoveNim n) {
        if (!this.isVide()) {
            Moves scroll = this.firstMove;
            while (scroll.next != null) {
                if (scroll.next.move == n) {
                    scroll.next = scroll.next.next;
                    size = size - 1;
                } else {
                    scroll = scroll.next;
                }
            }
        }
        return size;
    }

    /**
     * Méthode permettant de vérifier si la pile est nulle
     */

    private boolean isVide(){
        return (this.firstMove == null);
    }


    /**
     * Méthode permettant d'afficher l'historique
     */
    private void afficheRec(Moves hist){
        if(hist == null) {
            System.out.println("Fin de l'Historique");
        }
        else{
            System.out.println(hist.move);
            afficheRec(hist.next);
        }
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

    public Moves getFirstMove() {
        return firstMove;
    }

    public void setFirstMove(Moves firstMove) {
        this.firstMove = firstMove;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
