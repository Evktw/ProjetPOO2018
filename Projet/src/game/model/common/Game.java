package game.model.common;

public abstract class Game
{
    public PlayerList playerList;
    public int nbjoueurs[] = new int[2];
    
    public Game(PlayerList p, int min, int max)
    {
        this.playerList = p;
        this.nbjoueurs[0] = min;
        this.nbjoueurs[1] = max;
    }
    
    public Game(int min, int max)
    {
        this.playerList = new PlayerList(this);
        this.nbjoueurs[0] = min;
        this.nbjoueurs[1] = max;
    }          
    
    public int getNbMinJoueurs()
    {
        return this.nbjoueurs[0];
    }        
    
    public int getNbMaxJoueurs()
    {
        return this.nbjoueurs[1];
    }        

    public PlayerList getPlayerList() {
        return playerList;
    }

    public void setPlayerList(PlayerList playerList) {
        this.playerList = playerList;
    }
    
    public abstract void addPlayerInGame(String name, int age);        
    
    public abstract void addCpuInGame();
}
