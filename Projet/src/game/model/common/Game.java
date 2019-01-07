/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common;



/**
 *
 * @author evktw
 */
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
