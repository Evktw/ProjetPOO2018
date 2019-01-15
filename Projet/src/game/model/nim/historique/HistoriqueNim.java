package game.model.nim.historique;

import java.util.Stack;


public class HistoriqueNim
{

    private Stack<MoveNim> stack;

    private String winner;
    private int gameId;

    public HistoriqueNim(int id)
    {
        this.gameId = id;
        this.stack = new Stack<MoveNim>();
    }

    public void push(MoveNim move)
    {
        this.stack.push(move);
    }
    
    public MoveNim pop()
    {
        return this.stack.pop();
    }        
    
    public MoveNim peek()
    {
        return this.stack.peek();
    }        
    
    private void afficheHistorique()
    {
        while(!this.stack.isEmpty())
        {
            System.out.println(this.stack.peek());
            this.stack.pop();
        }
        System.out.println("Fin de l'Historique");
    }

    private String getWinner()
    {
        return winner;
    }

    private void setWinner(String winner)
    {
        this.winner = winner;
    }

    private int getGameId() 
    {
        return gameId;
    }

    private void setGameId(int gameId)
    {
        this.gameId = gameId;
    }

    public int getSize() 
    {
        return this.stack.size();
    }
}
