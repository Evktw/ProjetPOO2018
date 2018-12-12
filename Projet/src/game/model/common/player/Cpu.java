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
public class Cpu extends Player {
    
    private final static String cpuNames [] = {"Jean","Eric","Sophie", "Bruno", "Melanie"};
    
    public Cpu(String name, Game g)
    {
        super(ChooseCpuName(),g);
    }     
    
    
    public static String ChooseCpuName()
    {
        String str="BOT_";
        
        Random rnd = new Random();
        int val = rnd.nextInt(5);
        
        str += cpuNames[val];
        
        return str;
    }
    
    @Override
    protected void play()
    {
        
    }      
}
