/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common;

import game.model.common.player.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author Opti-Pognon
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
    
    public String toStringAllPlayers()
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
    public void changeTurn()
    {           
        if(this.idlist == this.playerList.size()-1)
            this.idlist = 0;   
        else
            this.idlist++;
    }  
          
    public void shuffle()
    {
        Collections.shuffle(playerList);
    }        

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    //A vérifier, on peut aussi faire un tour de boucle et ajouter les joueur un par un dans this.playerList
    public void setPlayerList(PlayerList playerList) {
        this.playerList = (List<Player>)playerList;
    }

    public int getIdlist() {
        return idlist;
    }

    public void setIdlist(int idlist) {
        this.idlist = idlist;
    }
    
    public Player getPlayer(int idlist)
    {
        return this.playerList.get(idlist);
    }        
    
    public int getSize()
    {
        return this.playerList.size();
    }        
    
    public boolean swap(int id1, int id2)
    {
        if(id1 > this.playerList.size() - 1|| id1 < 0 || id2 > this.playerList.size() - 1 || id2 < 0)
            return false;
        
        Player p = this.playerList.get(id1);
        Player p2 = this.playerList.get(id2);
        
        this.playerList.set(id2, p);
        this.playerList.set(id1, p2);
        
        return true;
    }        
    
}
