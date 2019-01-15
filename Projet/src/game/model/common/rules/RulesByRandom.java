package game.model.common.rules;

import game.model.common.PlayerList;

public class RulesByRandom extends Rules 
{
    public RulesByRandom(PlayerList p) 
    {
        super(p);
        this.playerList.shuffle();
    }
}
