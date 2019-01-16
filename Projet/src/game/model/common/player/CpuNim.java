package game.model.common.player;

import game.model.common.Game;
import java.util.Random;

public class CpuNim extends Cpu implements PlayerNim
{
    
    private static final Random RND = new Random();
    
    public CpuNim(Game g)
    {
        super(g);
    }

    @Override
    public int play(int nbperturn)
    {
        int val = RND.nextInt(nbperturn)+1;
        
        return val;
    }
    
    
}
