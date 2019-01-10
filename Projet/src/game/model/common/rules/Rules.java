package game.model.common.rules;

import game.model.common.PlayerList;

/**
 *
 * @author Opti Pognon
 */

//Pour les mot clés, faire une interface implémenté par tous les jeux (voir avec la prof)

public abstract class Rules {

    /**
     * Attributs
     */
    public PlayerList playerList;

    /**
     * Constructeur de Rules
     * @param p
     */
    Rules(PlayerList p)
    {
        this.playerList = p;
    }        
}
