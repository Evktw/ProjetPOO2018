package game.model.common.rules;

import game.model.common.PlayerList;
/**
 *
 * @author Opti-Pognon
 */
public class RulesByRandom extends Rules {

    /**
     * Constructeur de RulesByRandom
     * @param p
     */
    public RulesByRandom(PlayerList p) 
    {
        super(p);
        this.playerList.shuffle();
    }
    
    
    
    
}
