/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.ihm.text;

import game.model.common.Game;
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
public class PlayerListFactory {
    
    public static  List<Player> CreateListOfPlayers(Game g)
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
                        p.add(new Human(n,a,g));
                        break;
                        
                    case "bot":
                        p.add(new Cpu(g));
                        break;
                        
                    default:
                        System.out.println("Erreur de saisie, ecrivez joueur ou bot");
                        break;
                }
                
            }
            while(!choix.equals("bot") && !choix.equals("joueur"));
            
            System.out.println("Voici la liste des joueurs actuelle : \n");
            System.out.println(printAllPlayers(p));
            System.out.println("\n");
               
            //--------------------------------------------------------------------------
            System.out.println("Souhaitez vous continuer à ajouter des joueurs (oui ou non)");
            //Voir pourquoi ça bug
            c = sc.nextLine();
            //--------------------------------------------------------------------------
        }
        while(c.equals("oui"));
        
        return p;
    }
    
    public static String printAllPlayers(List<Player> p){
        
        String str = null;
        
        for(Player player : p)
        {
                str += player.toString();
        }
        
        return str;
    }
}
