package game.model.nim.historique;

public class MoveNim 
{
    private int spentMatches;
    private int remainingMatches;
    private String PlayerName;
    private final int idMove;
    private static int compteur = 1;

    public MoveNim (int nbS, String name, int nbR)
    {
        this.spentMatches = nbS;
        this.remainingMatches = nbR - this.spentMatches;
        this.PlayerName = name;
        this.idMove= compteur;
        compteur++;
    }

    public int getIdMove()
    {
        return idMove;
    }
    
    public int getSpentMatches()
    {
        return spentMatches;
    }

    private void setSpentMatches(int spentMatches)
    {
        this.spentMatches = spentMatches;
    }

    public String getPlayerName()
    {
        return PlayerName;
    }

    private void setPlayerName(String name)
    {
        PlayerName = name;
    }

    public int getRemainingMatches()
    {
        return remainingMatches;
    }

    public void setRemainingMatches(int remainingMatches)
    {
        this.remainingMatches = remainingMatches;
    }
}
