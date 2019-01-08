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
import game.model.common.player.PlayerNim;
import game.model.common.rules.Rules;
import game.model.common.rules.RulesByAge;
import game.model.common.rules.RulesByName;
import game.model.common.rules.RulesByRandom;
import game.model.nim.historique.HistoriqueNim;
import game.model.nim.historique.MoveNim;

import java.util.Scanner;

/**
 *
 * @author Opti-Pognon
 */

public class Nim extends Game {

    /**
     * Attributs
     */
    public boolean isPlaying;
    public int nbMatchstickTotal;
    public int nbPerTurn;
    public int mkID = 0;
    
    public Nim(PlayerList p, int min, int max) throws Exception
    {
        super(p,min,max);
    }
    
    public Nim(int min, int max) throws Exception
    {
        this(null,min,max);
        this.setPlayerList(PlayerListFactory());
    }  
  
    //Voir pour eventuellement divisé le NimGame en méthode plus petite
    
    public void NimGame() throws Exception
    {
        if(this.playerList.getSize() > this.getNbMaxJoueurs())
            throw new Exception("Il y a trop de joueurs");          //Voir ce que l'on fait dans ce cas la
        else if(this.playerList.getSize() < this.getNbMinJoueurs())
            throw new Exception("Il n'y a pas assez de joueurs");   //Voir ce que l'on fait dans ce cas la
        
        Scanner sc = new Scanner(System.in);
        this.mkID = mkID+1;
        int gameId = this.mkID;
        HistoriqueNim GameMoves = new HistoriqueNim(gameId);
        this.isPlaying = true;
        
        int resultat;
        
        do
        {    
            System.out.println("Comment decidez vous que le joueur commence ? Choisissez une des réponses suivante : \n- 1 : age\n- 2 : nom\n- 3 : hasard\n \nVotre reponse :");
                resultat = sc.nextInt();
                
            if(resultat != 1 && resultat != 2 && resultat != 3)
                System.out.println("\nErreur, veuillez rentrer une valeur entre 1 et 3\n");
        }
        while(resultat != 1 && resultat != 2 && resultat != 3);
            
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
        }
        
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
        
        do
        {   
            int i = this.playerList.getIdlist();
            
            System.out.println("\nC'est à " + this.playerList.getPlayer(i).getName() + " de jouer\n");
            
            System.out.println("Il y a actuellement " + this.nbMatchstickTotal + " Allumettes \n \n \t Combien souhaitez vous en enlever ?");
            if(this.playerList.getPlayer(i) instanceof PlayerNim)
            {
               int nbMatchRemoved = (((PlayerNim)this.playerList.getPlayer(i)).play(this.nbMatchstickTotal, this.nbPerTurn));
               MoveNim daMove = new MoveNim(nbMatchRemoved, (this.playerList.getPlayer(i).getName()), (this.nbMatchstickTotal-nbMatchRemoved));
               GameMoves.push(daMove);
               this.nbMatchstickTotal = (this.nbMatchstickTotal - nbMatchRemoved);
            }    
            
            if(this.nbMatchstickTotal <= 0)
            {
                this.nbMatchstickTotal = 0;
                System.out.println(this.playerList.getPlayer(i).getName() + " à perdu");
            }    
            
            this.playerList.changeTurn();
        }    
        while(this.isPlaying == true && this.nbMatchstickTotal > 0);
    }        

    public boolean isIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public int getNbMatchstickTotal() {
        return nbMatchstickTotal;
    }

    public void setNbMatchstickTotal(int nbMatchstickTotal) {
        this.nbMatchstickTotal = nbMatchstickTotal;
    }

    public int getNbPerTurn() {
        return nbPerTurn;
    }

    public void setNbPerTurn(int nbPerTurn) {
        this.nbPerTurn = nbPerTurn;
    }
    
    @Override
    public void addPlayerInGame(String name, int age) 
    {
        HumanNim p = new HumanNim(name,age,this);
        this.playerList.addPlayer(p);
    }

    @Override
    public void addCpuInGame() {
        CpuNim c = new CpuNim(this);
        this.playerList.addPlayer(c);
    }
    
    public PlayerList PlayerListFactory()
    {
        PlayerList p = new PlayerList(this);
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
                        this.addPlayerInGame(n,a);
                        break;
                        
                    case "bot":
                        this.addCpuInGame();
                        break;
                        
                    default:
                        System.out.println("Erreur de saisie, ecrivez joueur ou bot");
                        break;
                }
                
            }
            while(!choix.equals("bot") && !choix.equals("joueur"));
            
            System.out.println("Voici la liste des joueurs actuelle : \n" + p.toStringAllPlayers() + "\n");
               
            //--------------------------------------------------------------------------
            System.out.println("Souhaitez vous continuer à ajouter des joueurs (oui ou non)");
            //Voir pourquoi ça bug
            c = sc.nextLine();
            //--------------------------------------------------------------------------
        }
        while(c.equals("oui"));
        
        return p;
    }        
    

}

