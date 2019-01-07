/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.nim;



import static game.ihm.text.PlayerListFactory.CreateListOfPlayers;
import game.model.common.Game;
import game.model.common.PlayerList;
import game.model.common.player.PlayerNim;
import game.model.common.rules.Rules;
import game.model.common.rules.RulesByAge;
import game.model.common.rules.RulesByName;
import game.model.common.rules.RulesByRandom;
import java.util.Scanner;

/**
 *
 * @author evktw
 */
public class Nim extends Game
{
    public boolean isPlaying;
    public int nbMatchstickTotal;
    public int nbPerTurn;
    
    public Nim(PlayerList p, int min, int max) throws Exception
    {
        super(p,min,max);
        NimGame();
    }
    
    public Nim(int min, int max) throws Exception
    {
        this(null,min,max);
        this.setPlayerList(CreateListOfPlayers(this));
        NimGame();
    }  
  
    //Voir pour eventuellement divisé le NimGame en méthode plus petite
    
    public void NimGame() throws Exception
    {
        if(this.playerList.getSize() > this.getNbMaxJoueurs())
            throw new Exception("Il y a trop de joueurs");          //Voir ce que l'on fait dans ce cas la
        else if(this.playerList.getSize() < this.getNbMinJoueurs())
            throw new Exception("Il n'y a pas assez de joueurs");   //Voir ce que l'on fait dans ce cas la
        
        Scanner sc = new Scanner(System.in);
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
        }
        while(this.nbMatchstickTotal < nbPerTurn);
        
        do
        {   
            int i = this.playerList.getIdlist();
            
            System.out.println("Il y a actuellement " + this.nbMatchstickTotal + " Allumettes \n \n \t Combien souhaitez vous en enlever ?");
            if(this.playerList.getPlayer(i) instanceof PlayerNim)
            {    
               ((PlayerNim)this.playerList.getPlayer(i)).play(this.nbMatchstickTotal, this.nbPerTurn);
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
    
    
    
    
/*
    public Nim()
    {
        Scanner sc = new Scanner(System.in);
        
        
        
        if(playerList.size() < 2)
            System.out.println("Vous n'êtes pas assez pour jouer à ce jeux");
        else
        {
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
            
            switch (resultat) {
                case 1:
                    System.out.println("=== Vous avez choisis de trier par age ===\n");
                    Player.chooseOrderByAge();
                    break;
                case 2:
                    System.out.println("=== Vous avez choisis de trier aleatoirement ===\n");
                    Player.chooseOrderByRandom();
                    break;
                case 3:
                    System.out.println("=== Vous avez choisis de trier par nom ===\n");
                    Player.chooseOrderByName();
                    break;
            }
            
            do 
            {    
                System.out.println("Combien d'allumettes au total choisissez vous ?");
                this.nbMatchstickTotal = sc.nextInt();
            
                System.out.println("Combien d'allumettes au maximum par tour voulez vous enlever ?");
                this.K = sc.nextInt();
            }
            while(this.nbMatchstickTotal < K);
            
            Player.setFirst(playerList);
            
            do
            {
                int nb;
                 
                do
                {
                    System.out.println("Il y a actuellement " + this.nbMatchstickTotal + " Allumettes \n \n \t Combien souhaitez vous en enlever ?");
                    
                    nb = sc.nextInt();
                    
                    if(nb > this.K || nb < 1)
                        System.out.println("Nombre invalide, veuillez rentrer une autre valeur");
                }    
                while(nb > this.K || nb < 1);
                
                this.nbMatchstickTotal-=nb;
                
                if(this.nbMatchstickTotal <= 0)
                {
                    System.out.println("Vous avez perdu !");
                }     
                else
                    Player.changeTurn(playerList);
            }    
            while(this.isPlaying == true && this.nbMatchstickTotal > 0);
            
        }
        
           
        
    }        
   
    
    public void strategieBot(Player cpu, int nb)
    {
        Random rnd = new Random();
        
        if(cpu.isHuman())
        {    
            //voir pour l'erreur
        }    
        else
        {    
            int val = rnd.nextInt(nb-1)+1;
        }        
    }        
    
    
*/    

    
}
