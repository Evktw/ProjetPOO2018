/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.nim;



import game.model.common.player.Player;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author evktw
 */
public class Nim
{
    private boolean isPlaying;
    private int nbMatchstickTotal;
    private int K;
    
    
    public Nim(List<Player> playerList)
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
    
    
    
    
}
