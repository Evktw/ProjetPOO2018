package game.model.nim;
import game.model.common.PlayerList;
import game.model.common.player.HumanNim;
import game.model.common.rules.Rules;


public class testNim {
    
    public static void main(String[] args) throws Exception
    {
        Nim nim = null;
        
        PlayerList p = new PlayerList(nim);
        Rules r;
        
        HumanNim h = new HumanNim("J1",12,nim);
        HumanNim c = new HumanNim("J2",25,nim);
        HumanNim a = new HumanNim("J3",50,nim);
        HumanNim b = new HumanNim("J4",35,nim);
        HumanNim d = new HumanNim("J5",40,nim);
        HumanNim e = new HumanNim("J6",30,nim);
        HumanNim f = new HumanNim("J7",70,nim);
        HumanNim g = new HumanNim("J8",2,nim);
        
        
        
        p.addPlayer(h);
        p.addPlayer(c);
        p.addPlayer(a);
        p.addPlayer(b);
        p.addPlayer(d);
        p.addPlayer(e);
        p.addPlayer(f);
        p.addPlayer(g);
        
        /*
        System.out.println("LISTE AVANT TRIE \n" + p.toStringAllPlayers());
        */
        /*
        
        System.out.println("\n\n\n\nLISTE APRES TRIE PAR NOM \n" + p.toStringAllPlayers());
        
        r = new RulesByName(p);
        
        System.out.println("\n\n\n\nLISTE APRES TRIE PAR AGE \n" + p.toStringAllPlayers());

        r = new RulesByAge(p);
        
        System.out.println("\n\n\n\nLISTE APRES TRIE PAR ALEATOIRE \n" + p.toStringAllPlayers());
        
        r = new RulesByRandom(p);

        */
        
        nim = new Nim(p,1,10);
        
        nim.NimGame();
    }
    
    
}
