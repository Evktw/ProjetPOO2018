package game.model.common.player;

import game.model.common.Game;
import java.util.Random;

public abstract class Cpu extends Player {
    
    private final static String CPUNAMES [] = {"Jean","Eric","Sophie", "Bruno", "Melanie", "John","Mary","Hin"};
    
    public Cpu(Game g)
    {
        super(ChooseCpuName(),g);
    }     
    
    @Override
    public String toString()
    {
        String str = " \n Nom : " + this.getName() + " | " + "Win : " + this.getGameWin() + " | " + "Played : " + this.getNbGame() + '\n';
        return str;
    }
    
    
    public static String ChooseCpuName()
    {
        String str="BOT_";
        
        Random rnd = new Random();
        int val = rnd.nextInt(8);
        
        str += CPUNAMES[val];
        
        return str;
    }
        
}
