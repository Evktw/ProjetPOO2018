/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common;

import game.model.common.player.Cpu;
import game.model.common.player.Human;
import game.model.common.player.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author evktw
 */
public class Game
{
    
    public List<Player> playerList = new ArrayList();
    
    public Game(List<Player> p)
    {
        this.playerList = p;
    }       
    
    public void clearPlayerList()
    {
        this.playerList.clear();
    }
    
    public void addPlayer(Player player)
    {
        this.playerList.add(player);
    }
    
    //Voir avec la prof si cela fonctionne ou si il faut prevoir un cas si cela ne fonctionne pas et voir si utiliser un boolean est interessant, demander si il est interessant de redefinir equals
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
    /*
    
    //Voir avec la prof si on peut mettre un id negatif au bot afin de pouvoir fiare un remove par id
    public boolean removePlayerById(int identifiant)
    {
        for(int i = 0; i < this.playerList.size()-1; i++)
        {
            if(playerList.get(i).)
            {
                this.playerList.remove(player);
                return true;
            }    
                
        }          
        return false;
    }        
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
    
    //Voir avec la prof, string ou void STRING
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
    public void changeTurn(List<Player> p, int idlist)
    {
                
                if(idlist != p.size()-1)
                {
                    idlist = 
                }    
                
                else if(i == p.size()-1)
                {
                    p.get(0).setActive(true);
                    System.out.println("C'est à " + p.get(0).getName() + " de jouer");
                    break;
                }               

    }  
    
    /**
     * Permet de créer une liste de joueur
     */
    public void CreateListOfPlayers()
    {
        List<Player> p = new ArrayList<Player>();
        Scanner sc = new Scanner(System.in);
        String c;
        
        System.out.println("================= CREATION DES JOUEURS =================");
        
        do
        {    
            String choix;
            do
            {   
                System.out.println("Souhaitez vous ajouter un joueur ou un BOT (joueur ou bot)");
                choix = sc.nextLine();

                switch (choix) 
                {
                    
                    case "joueur":
                        System.out.println("Saisissez le nom du joueur que vous souhaitez ajouter");
                        String n = sc.nextLine();
                        System.out.println("Saisissez l'age du joueur que vous souhaitez ajouter");
                        int a = sc.nextInt();
                        p.add(new Human(n,a,this));
                        break;
                        
                    case "bot":
                        p.add(new Cpu(this));
                        break;
                        
                    default:
                        System.out.println("Erreur de saisie, ecrivez joueur ou bot");
                        break;
                }
                
            }
            while(!choix.equals("bot") && !choix.equals("joueur"));
            
            System.out.println("Voici la liste des joueurs actuelle : \n");
            printAllPlayers();
            System.out.println("\n");
               
            //--------------------------------------------------------------------------
            System.out.println("Souhaitez vous continuer à ajouter des joueurs (oui ou non)");
            //Voir pourquoi ça bug
            c = sc.nextLine();
            //--------------------------------------------------------------------------
        }
        while(c.equals("oui"));
        
        playerList = p;
    }
    
    
    public void addPlayers(Player p)
    {        
        playerList.add(p);
    }       
    
    /**
     * Permet de définir le premier joueur à jouer
     * @param p
     */
    public void setFirst(List<Player> p)
    {
        p.get(0).setActive(true);
        System.out.println("C'est à " + p.get(0).getName() + " de jouer");
    }     



    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
