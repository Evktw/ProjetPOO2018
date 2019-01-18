package game.model.common.rules;

import game.model.common.PlayerList;
import game.model.common.player.Human;

public class RulesByName extends Rules
{

    public RulesByName(PlayerList p) 
    {
        super(p);
        getFirstByLowerName();
    } 
    
    private PlayerList getFirstByLowerName() 
    {     
        int id = 0;

        while(id < this.playerList.getSize())
        {
            String lowername = this.playerList.getPlayer(id).getName();

                for(int i = 0; i < this.playerList.getSize(); i++)
                {
                        if(this.playerList.getPlayer(i).getName().charAt(0) < lowername.charAt(0))
                        {
                            lowername = this.playerList.getPlayer(i).getName();
                            this.playerList.swap(id,i);
                        }    
                        else
                        {
                            int cpt = 1;
                            int lengthName;
                            
                            if(this.playerList.getPlayer(i).getName().length() < lowername.length())
                                lengthName = lowername.length();
                            else
                                lengthName =this.playerList.getPlayer(i).getName().length();
                            
                            while(lengthName < cpt)
                            {
                                if(this.playerList.getPlayer(i).getName().charAt(cpt) < lowername.charAt(cpt))
                                {
                                    this.playerList.swap(id,i);
                                }                       
                                cpt++;
                            }    
                            
                        }    
                    }   
                
            id++;  
        }      
            
       this.playerList.reverse();
        
       return this.playerList;
       
    }    
        
        
}
    
    
    
    
    
 



