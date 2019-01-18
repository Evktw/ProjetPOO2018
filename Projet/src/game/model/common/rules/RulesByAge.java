package game.model.common.rules;

import game.model.common.PlayerList;
import game.model.common.player.Human;

public class RulesByAge extends Rules
{
    public RulesByAge(PlayerList p)
    {
        super(p);
        getFirstByLowerAge();
    }
    
    private PlayerList getFirstByLowerAge() 
    {   
        int id = 0;

        while(id < this.playerList.getSize())
        {
            if(this.playerList.getPlayer(id) instanceof Human)
            {    
                int lowerage = ((Human) this.playerList.getPlayer(id)).getAge();

                if(this.playerList.getPlayer(id) instanceof Human)
                {
                    for(int i = 0; i < this.playerList.getSize(); i++)
                    {
                        if(this.playerList.getPlayer(i) instanceof Human)
                        {
                            if(((Human) this.playerList.getPlayer(i)).getAge() < lowerage)
                            {
                                lowerage = ((Human) this.playerList.getPlayer(i)).getAge();
                                this.playerList.swap(id,i);
                            }    
                        }    
                    }    
                }  
            
            } 
            id++;
        }    
        
        this.playerList.reverse();
        
        return this.playerList;
    }
    
}    

