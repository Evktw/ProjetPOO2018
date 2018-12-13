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
    
    public Game(PlayerList p)
    {
        this.playerList = p;
    }
    
    public Game()
    {
        this.playerList = new PlayerList(this);
    }        
    
    
    
    
    
    



    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
