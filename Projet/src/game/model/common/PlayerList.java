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

    /**
     * Attributs
     */
    public Game game;
    
    private List<Player> playerList;   // Liste de Joueurs
    private int idlist;                // Indice d'un joueur dans la liste


    /**
     * Constructeurs
     */
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


    /**
     * Reset la liste des joueurs
     */
    public void clearPlayerList()
    {
        this.playerList.clear();
    }

    /**
     * Ajoute un joueur de la liste
     * @param player
     */
    public void addPlayer(Player player)
    {
        this.playerList.add(player);
    }

    /**
     * Enleve un joueur de la liste via le joueur
     * @param player
     * @return boolean
     */

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

    /**
     * Enleve un joueur de la liste via le pseudo
     * @param n
     * @return boolean
     */
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

    /**
     * Méthode permettant de générer une chaîne de caractères comprenant tous les pseudos de la liste de joueurs
     * @return str
     */
    public String toStringAllPlayers()
    {
        String str = "";
        
        for(Player player : playerList)
        {
                str += player.toString() + "; ";
        }
        
        return str;
    }
    
    /**
     * Fonction permettant de changer de tour
     * Attention ! Cette méthode n'est valable que pour les jeux en tour par tour
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

    /**
     * Méthode permettant d'échanger la place de deux joueurs au sein de la liste
     * @param id1
     * @param id2
     * @return boolean
     */
    public boolean swap(int id1, int id2) {
        if(id1 > this.playerList.size() - 1|| id1 < 0 || id2 > this.playerList.size() - 1 || id2 < 0)
            return false;

        Player p = this.playerList.get(id1);
        Player p2 = this.playerList.get(id2);

        this.playerList.set(id2, p);
        this.playerList.set(id1, p2);

        return true;
    }

    /**
     * Getters & Setters
     */
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
    
    public Player getPlayer(int idlist) { return this.playerList.get(idlist); }
    
    public int getSize() { return this.playerList.size(); }

}
