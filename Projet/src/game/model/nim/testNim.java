/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.nim;
import game.model.common.PlayerList;
import game.model.common.player.HumanNim;
import game.model.common.rules.Rules;
import game.model.common.rules.RulesByAge;
import game.model.common.rules.RulesByName;
import game.model.common.rules.RulesByRandom;


/**
 *
 * @author Opti-Pognon
 */

public class testNim {
    
    public static void main(String[] args) throws Exception
    {
        Nim nim = null;
        
        PlayerList p = new PlayerList(nim);
        Rules r;
        
        HumanNim h = new HumanNim("jean",12,nim);
        HumanNim c = new HumanNim("rene",25,nim);
        HumanNim a = new HumanNim("natasha",50,nim);
        HumanNim b = new HumanNim("cecile",35,nim);
        HumanNim d = new HumanNim("emma",40,nim);
        HumanNim e = new HumanNim("papouasie",30,nim);
        HumanNim f = new HumanNim("elu",70,nim);
        HumanNim g = new HumanNim("osymentopias",2,nim);
        
        
        
        p.addPlayer(h);
        p.addPlayer(c);
        p.addPlayer(a);
        p.addPlayer(b);
        p.addPlayer(d);
        p.addPlayer(e);
        p.addPlayer(f);
        p.addPlayer(g);
        
        System.out.println("LISTE AVANT TRIE \n" + p.toStringAllPlayers());
        
        r = new RulesByAge(p);
        
        System.out.println("\n\n\n\nLISTE APRES TRIE PAR AGE \n" + p.toStringAllPlayers());
        
        r = new RulesByName(p);
        
        System.out.println("\n\n\n\nLISTE APRES TRIE PAR NOM \n" + p.toStringAllPlayers());
        
        r = new RulesByRandom(p);
        
        System.out.println("\n\n\n\nLISTE APRES TRIE PAR ALEATOIRE \n" + p.toStringAllPlayers());
        
        nim = new Nim(p,1,10);
        
        nim.NimGame();
    }
    
    
}
