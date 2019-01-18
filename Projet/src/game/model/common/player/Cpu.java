package game.model.common.player;

import game.model.common.Game;
import java.util.Random;

public abstract class Cpu extends Player {
    
    private final static String CPUNAMES [] = {"Jean","Eric","Sophie", "Bruno", "Melanie", "John","Mary","Hin"};
    
    private final static boolean NAME_USED [] = {false,false,false,false,false,false,false,false};
    
    public Cpu(Game g)
    {
        super(ChooseCpuName(),g);
    }   
    
    @Override
    public String toString()
    {
        String str = "\nNom : " + this.getName() + " | " + "Win : " + this.getGameWin() + " | " + "Played : " + this.getNbGame() + '\n';
        return str;
    }
    
    
    public static String ChooseCpuName()
    {
        String str = "";
        
        Random rnd = new Random();
        int val = rnd.nextInt(8);
        
        
        if(NAME_USED[val] == false)
        {
            NAME_USED[val] = true;
            str += CPUNAMES[val] + "_BOT";
        }
        else
            str = ChooseCpuName();
        
        
        
        return str;
    }
        
}
