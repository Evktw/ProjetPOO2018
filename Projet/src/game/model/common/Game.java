/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common;

import game.model.common.player.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author evktw
 */
public class Game implements Comparable<Player>
{
    public List<Player> playerList = new ArrayList();
    public boolean active;
    
    public Game()
    {
        
    }        
    
    
    public String ToStringAllHumanPlayers()
    {
        String str ="";
        
        for(Player player : humanPlayerList)
        {
            str += "Joueur n°" + player.id + " - Nom : " + player.name + "\n \t Nombre de partie gagné : " + player.getGameWin() + "\n \t Nombre de partie perdu : " + (player.getNbGame() - player.getGameWin()) + "\n \t Nombre de partie total : " + player.getNbGame() + '\n';
        }
        
        return str;
    }
    
    public String printAllPlayers()
    {
        for(Player player : playerList)
        {
            if(player.isHuman == true)
                System.out.println("- Joueur n°" + player.id + " - " + player.name);
            else
                System.out.println("- BOT - " + player.name);
        }
    }
    
    /**
     * Permet d'afficher les informations du joueur sur lequel est appelé la methode
     */
    public void printPlayer()
    {
        System.out.println("- Joueur n°" + this.id + " - Nom : " + this.name + "\n \t Nombre de partie gagné : " + this.getGameWin() + "\n \t Nombre de partie perdu : " + (this.getNbGame() - this.getGameWin()) + "\n \t Nombre de partie total : " + this.getNbGame() + '\n');
    } 
    
    
    
    /**
     * Fonction permettant de changer de tour
     * Attention ! Cette méthode n'est valable que pour les jeux en tour par tour
     * @param p
     */
    public void changeTurn(List<Player> p)
    {
        
        for (int i = 0; i < p.size(); i++) 
        {
            if(p.get(i).isActive() == true)
            {
                p.get(i).setActive(false);
                
                
                if(i != p.size()-1)
                {
                    p.get(i+1).setActive(true);
                    System.out.println("C'est à " + p.get(i+1).getName() + " de jouer");
                    break;
                }    
                
                else if(i == p.size()-1)
                {
                    p.get(0).setActive(true);
                    System.out.println("C'est à " + p.get(0).getName() + " de jouer");
                    break;
                }               
            }    
                
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
                        p.add(CreatePlayer(n,a));
                        break;
                        
                    case "bot":
                        p.add(CreateCPU());
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
    
    
    public static void addPlayers(Player p)
    {        
        playerList.add(p);
    }       
    
    /**
     * Permet de définir le premier joueur à jouer
     * @param p
     */
    public static void setFirst(List<Player> p)
    {
        p.get(0).setActive(true);
        System.out.println("C'est à " + p.get(0).getName() + " de jouer");
    }     

    public static void chooseOrderByAge()
    {
        Collections.sort(playerList, Player.Comparators.AGE);
    }
    
    public static void chooseOrderByName()
    {
        Collections.sort(playerList, Player.Comparators.NAME);
    }
    
    public static void chooseOrderByRandom()
    {
        Collections.shuffle(playerList);
    }
    
    

    @Override
    public int compareTo(Player t) {
        return 0;
    }
    
    
    
    /**
     * Classe permettant de trier une arraylist selon l'age ou le nom dans notre cas
     */
    public static class Comparators {

        public static Comparator<Player> NAME = (Player p1, Player p2) -> p1.name.compareTo(p2.name);
        
        public static Comparator<Player> AGE = (Player p1, Player p2) -> p1.age - p2.age;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
