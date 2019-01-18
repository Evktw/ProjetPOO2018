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
        //CpuNim b = new CpuNim(nim);
        CpuNim c = new CpuNim(nim);
        //CpuNim d = new CpuNim(nim);
        CpuNim e = new CpuNim(nim);
        CpuNim f = new CpuNim(nim);
        CpuNim g = new CpuNim(nim);
        //CpuNim h = new CpuNim(nim);
        
        
        HumanNim a = new HumanNim("Colin",27,nim);
        HumanNim b = new HumanNim("Kevin",2,nim);
        //HumanNim c = new HumanNim("Mathieu",32,nim);
        HumanNim d = new HumanNim("Anae",29,nim);
        //HumanNim e = new HumanNim("Anad",1,nim);
        //HumanNim f = new HumanNim("Anac",79,nim);
        //HumanNim g = new HumanNim("Ana",7,nim);
        HumanNim h = new HumanNim("Belly",27,nim);
        
        
        p.addPlayer(a);
        p.addPlayer(b);
        p.addPlayer(c);
        p.addPlayer(d);
        p.addPlayer(e);
        p.addPlayer(f);
        p.addPlayer(g);
        p.addPlayer(h);
        
        nim = new Nim(p);
        
        nim.NimGame();
    }
    
    
}
