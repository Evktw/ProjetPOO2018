/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common;

import game.model.common.player.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author evktw
 */
public class PlayerList 
{
    public Game game;
    
    public List<Player> playerList;
    public int idlist;
    
    public PlayerList(Game g, List<Player> p)
    {
        this.playerList = p;
        this.game = g;
        this.idlist = 0;
    }
    
    public PlayerList(Game g)
    {
        this(g,new ArrayList<Player>());
    }        
    
    public void clearPlayerList()
    {
        this.playerList.clear();
    }
    
    public void addPlayer(Player player)
    {
        this.playerList.add(player);
    }
    
    public boolean removePlayer(Player player)
    {
        for(int i = 0; i < this.playerList.size()-1; i++)
        {
            if(playerList.get(i).equals(player))
            {
                this.playerList.remove(player);
                return true;
            }          
        }          
        return false;
    }        
    
    public boolean removePlayerByName(String n)
    {
        for(int i = 0; i < this.playerList.size()-1; i++)
        {
            if(playerList.get(i).getName().equals(n))
            {
                this.playerList.remove(i);
                return true;
            }    
                
        }          
        return false;
    }        
    
    public String printAllPlayers()
    {
        String str = null;
        
        for(Player player : playerList)
        {
                str += player.toString();
        }
        
        return str;
    }
    
    /**
     * Fonction permettant de changer de tour
     * Attention ! Cette méthode n'est valable que pour les jeux en tour par tour
     * @param p
     */
    public void changeTurn(List<Player> p)
    {           
        if(this.idlist == p.size()-1)
            this.idlist = 0;   
        else
            this.idlist++;
    }  
    
}
