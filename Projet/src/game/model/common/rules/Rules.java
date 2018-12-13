/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common.rules;

import game.model.common.PlayerList;


// Pour les mot clés, faire une interface implémentée par tous les jeux (voir avec la prof)

public abstract class Rules {

    /**
     * Attributs
     */
    public PlayerList playerList;                // Liste des Joueurs


    /**
     * Constructeur
     * @param p
     */
    Rules(PlayerList p) {
        this.playerList = p;
    }        
}
