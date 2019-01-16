package game.model.nim;
import game.model.common.PlayerList;
import game.model.common.player.CpuNim;
import game.model.common.player.HumanNim;
import game.model.common.rules.Rules;


public class testNim {
    
    public static void main(String[] args) throws Exception
    {
        Nim nim = null;
        
        PlayerList p = new PlayerList(nim);
        Rules r;
        
        
        //CpuNim a = new CpuNim(nim);
        CpuNim b = new CpuNim(nim);
        //CpuNim c = new CpuNim(nim);
        CpuNim d = new CpuNim(nim);
        //CpuNim e = new CpuNim(nim);
        CpuNim f = new CpuNim(nim);
        //CpuNim g = new CpuNim(nim);
        CpuNim h = new CpuNim(nim);
        
        
        HumanNim a = new HumanNim("HUMAIN1",27,nim);
        //HumanNim b = new HumanNim("HUMAIN2",2,nim);
        HumanNim c = new HumanNim("HUMAIN3",32,nim);
        //HumanNim d = new HumanNim("HUMAIN4",29,nim);
        HumanNim e = new HumanNim("HUMAIN5",1,nim);
        //HumanNim f = new HumanNim("HUMAIN6",79,nim);
        HumanNim g = new HumanNim("HUMAIN7",7,nim);
        //HumanNim h = new HumanNim("HUMAIN8",27,nim);
        
        
        p.addPlayer(a);
        p.addPlayer(b);
        p.addPlayer(c);
        p.addPlayer(d);
        p.addPlayer(e);
        p.addPlayer(f);
        p.addPlayer(g);
        p.addPlayer(h);
        
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
