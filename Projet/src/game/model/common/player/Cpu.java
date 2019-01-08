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
 * @author Opti-Pognon
 */
public abstract class Cpu extends Player {
    
    private final static String CPUNAMES [] = {"Jean","Eric","Sophie", "Bruno", "Melanie"};
    
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
        int val = rnd.nextInt(5);
        
        str += CPUNAMES[val];
        
        return str;
    }
    
    @Override
    public void play()
    {
        
    }      
}
