package game.model.common.rules;

import game.model.common.PlayerList;


public abstract class Rules 
{
    
    public PlayerList playerList;

    Rules(PlayerList p)
    {
        this.playerList = p;
    }        
}
