/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common.player;

import game.model.common.Game;
import java.util.Random;

/**
 *
 * @author evktw
 */
public class CpuNim extends Cpu implements PlayerNim{
    
    private static final Random RND = new Random();
    
    public CpuNim(Game g)
    {
        super(g);
    }

    @Override
    public int play(int nbperturn, int nbtotal)
    {
        int val = RND.nextInt(nbperturn)+1;
        
        return nbtotal - val;
    }
    
    
}
