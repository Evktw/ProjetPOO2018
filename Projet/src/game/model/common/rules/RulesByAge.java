/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common.rules;

import game.model.common.PlayerList;
import game.model.common.player.Human;

public class RulesByAge extends Rules {


    public RulesByAge(PlayerList p)
    {
        super(p);
    }
    
    
    public PlayerList getFirstByLowerAge()
    {
        int agemin = getLowerAgeInList();
        
        for(int i = 0; i < this.playerList.getSize()-1 ; i++)
        {
            if(this.playerList.getPlayer(i) instanceof Human)
            {
                if(agemin == ((Human)this.playerList.getPlayer(i)).getAge())
                    this.playerList.swap(0, i);
            }
        }
        return this.playerList;
    }        
    
    
    public int getLowerAgeInList()
    {
        int age=0;
        
        for(int i = 0; i < this.playerList.getSize()-1 ; i++)
        {
            if(this.playerList.getPlayer(i) instanceof Human)
            {
                int humanAge = ((Human)this.playerList.getPlayer(i)).getAge();
                
                if(humanAge > age)
                    age = humanAge;
            }
        }  
        return age;
    }        
    
    
}    

