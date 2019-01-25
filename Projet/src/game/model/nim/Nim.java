/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.nim;

import game.model.common.Game;
import game.model.common.PlayerList;
import game.model.common.player.CpuNim;
import game.model.common.player.HumanNim;
import game.model.common.player.Player;
import game.model.common.player.PlayerNim;
import game.model.common.rules.Rules;
import game.model.common.rules.RulesByAge;
import game.model.common.rules.RulesByName;
import game.model.common.rules.RulesByRandom;
import game.model.nim.historique.HistoriqueNim;
import game.model.nim.historique.MoveNim;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public final class Nim extends Game 
{

    public boolean isPlaying;
    public int nbMatchstickTotal;
    public int nbPerTurn;
    public int mkID = 0;
    
    public Nim(PlayerList p, int min, int max) throws Exception
    {
        super(p,min,max);
    }
    
    public Nim() throws Exception
    {
        this(null,1,8);
        this.playerList = new PlayerList(this);
        PlayerListFactory();
    }
    
    public Nim(PlayerList p) throws Exception
    {
        this(p,1,8);
    }        
  
    
    public void NimGame() throws Exception
    {       
        if(this.playerList.getSize() > this.getNbMaxJoueurs())
            throw new Exception("Il y a trop de joueurs");
        else if(this.playerList.getSize() < this.getNbMinJoueurs())
            throw new Exception("Il n'y a pas assez de joueurs");

        
        Scanner sc = new Scanner(System.in);
        this.mkID = mkID+1;
        int gameId = this.mkID;
        HistoriqueNim GameMoves = new HistoriqueNim(gameId);
        this.isPlaying = true;
        
        int resultat;
        
        do
        {    
            System.out.println("Comment decidez vous que le joueur commence ? Choisissez une des réponses suivante : \n- 1 : Age\n- 2 : Hasard\n- 3 : Nom\n- 4 : Ne pas trier\nVotre reponse :");
                resultat = sc.nextInt();
                
            if(resultat != 1 && resultat != 2 && resultat != 3 && resultat != 4)
                System.out.println("\nErreur, veuillez rentrer une valeur entre 1 et 4\n");
        }
        while(resultat != 1 && resultat != 2 && resultat != 3 && resultat != 4);
            
        Rules r;
        
        switch (resultat) 
        {
            case 1:
                System.out.println("=== Vous avez choisis de trier par age ===\n");
                r = new RulesByAge(this.playerList);
                break;
            case 2:
                System.out.println("=== Vous avez choisis de trier aleatoirement ===\n");
                r = new RulesByRandom(this.playerList);
                break;
            case 3:
                System.out.println("=== Vous avez choisis de trier par nom ===\n");
                r = new RulesByName(this.playerList);
                break;
            case 4:
                System.out.println("=== Vous avez choisis de ne pas trier la liste ===\n");
                break;
            default:
                System.err.println("ERREUR");
        }
        
        System.out.println("Voici l'ordre dans lequel les joueurs vont jouer :" + this.playerList.toStringAllPlayers() + "\n");
        
        do 
        {    
            System.out.println("Combien d'allumettes au total choisissez vous ?");
            this.nbMatchstickTotal = sc.nextInt();
            
            System.out.println("Combien d'allumettes au maximum par tour voulez vous enlever ?");
            this.nbPerTurn = sc.nextInt();
            
            if(this.nbPerTurn > this.nbMatchstickTotal)
                System.out.println("/nErreur, veuillez entrer un nombre par tour superieur au nombre total/n");
        }
        while(this.nbMatchstickTotal < nbPerTurn);
        
        System.out.println("------------------------------------------------------------------------------------------------");
        
        do
        {   
            int idinList = this.playerList.getIdlist();
            
            System.out.println("\nC'est à " + this.playerList.getPlayer(idinList).getName() + " de jouer\n");
            
            System.out.println("Il y a actuellement " + this.nbMatchstickTotal + " Allumettes \n \n \t Combien souhaitez vous en enlever ? -Ecrivez 0 pour depiler-");
            
            if(this.playerList.getPlayer(idinList) instanceof PlayerNim)
            {
                if(this.playerList.getPlayer(idinList) instanceof CpuNim)
                {
                    TimeUnit.SECONDS.sleep((long)1.25);
                }    

               int nbMatchRemoved = (((PlayerNim)this.playerList.getPlayer(idinList)).play(this.nbPerTurn));
               
               if(nbMatchRemoved == -1)
               {
                   if(GameMoves.getSize() == 0)
                   {
                       System.out.println("\n C'est le premier coup vous ne pouvez pas depiler");
                       
                       System.out.println("------------------------------------------------------------------------------------------------");
                   }   
                   else
                   {      
                       this.playerList.turnBack();
                       this.nbMatchstickTotal += GameMoves.pop().getSpentMatches();
                       
                       while(this.playerList.getPlayer(this.playerList.getIdlist()) instanceof CpuNim)
                       {
                           this.nbMatchstickTotal += GameMoves.pop().getSpentMatches();
                           this.playerList.turnBack();
                       }
                       
                       System.out.println("------------------------------------------------------------------------------------------------");
                       
                   }   
               }    
               else
               {
                   this.nbMatchstickTotal -= nbMatchRemoved;
                   MoveNim move = new MoveNim((this.playerList.getPlayer(idinList).getName()), nbMatchRemoved,(this.nbMatchstickTotal-nbMatchRemoved));
                   GameMoves.push(move);
                   
                   System.out.println("\n" + this.playerList.getPlayer(idinList).getName() + " à retiré " + nbMatchRemoved + " alumettes \n");
                   
                   this.playerList.changeTurn();
                   
                   if(this.nbMatchstickTotal <= 0)
                   {
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        this.nbMatchstickTotal = 0;
                        System.out.println("\t \t \t \t" + this.playerList.getPlayer(idinList).getName() + " à perdu");
                        
                        for(int i = 0; i < this.playerList.getSize(); i++)
                        {
                            this.playerList.getPlayer(i).incrementNbGame();
                            
                            if( i != idinList)
                                this.playerList.getPlayer(i).incrementGameWin();
                        }    
                   }    
            
                   System.out.println("-----------------------------------------------------------------------------------------------");
               }    
               
            }
                
    
        }    
        while(this.isPlaying == true && this.nbMatchstickTotal > 0);
    }        
    
    
    @Override
    public void addPlayerInGame(String name, int age) 
    {
        Player p = new HumanNim(name,age,this);
        this.playerList.addPlayer(p);
    }

    @Override
    public void addCpuInGame() 
    {
        Player c = new CpuNim(this);
        this.playerList.addPlayer(c);
    }
    
    public void PlayerListFactory()
    {
        Scanner sc = new Scanner(System.in);
        int choix;
        int continuer;
        String name;
        int age;
        
        System.out.println("\n================= CREATION DES JOUEURS =================\n");
        
        System.out.println("-----------------------------------------------------------------------------------------------");
        
        do
        {
            System.out.println("Quel type de joueur souhaitez vous ajouter \n\t\t- 0 pour un bot \n\t\t- 1 pour un joueur");
            choix = sc.nextInt();
            
            switch(choix)
            {
                case 0 :            
                    addCpuInGame();
                    break;  
                case 1 :
                    
                    System.out.println("Choisissez le nom du joueur");
                    name = sc.next();
                    
                    System.out.println("Choisissez l'age du joueur");
                    age = sc.nextInt();
                    
                    addPlayerInGame(name, age);
                    break;
                default :
                    System.out.println("ERROR");
                    break;
            } 
            
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("Voici la liste des joueurs après ajout : " + this.playerList.toStringAllPlayers() + "\n");
            System.out.println("-----------------------------------------------------------------------------------------------");
            
            System.out.println("Souhaitez vous ajouter un autre joueur ? \n\t\t- 0 pour arreter \n\t\t- 1 pour continuer");
            continuer = sc.nextInt();
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
        while(continuer == 1);
        
        
        System.out.println("\n================= FIN DE CREATION DES JOUEURS =================\n");
        
    }        

    /**
     * Getters & Setters
     */
    
    public boolean isIsPlaying()
    {
        return isPlaying;
    }

    public void setIsPlaying(boolean isPlaying) 
    {
        this.isPlaying = isPlaying;
    }

    public int getNbMatchstickTotal() 
    {
        return nbMatchstickTotal;
    }

    public void setNbMatchstickTotal(int nbMatchstickTotal) 
    {
        this.nbMatchstickTotal = nbMatchstickTotal;
    }

    public int getNbPerTurn()
    {
        return nbPerTurn;
    }

    public void setNbPerTurn(int nbPerTurn) 
    {
        this.nbPerTurn = nbPerTurn;
    }
    
    
    

}

