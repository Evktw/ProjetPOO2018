/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common.rules;

import game.model.common.PlayerList;

/**
 *
 * @author Opti-Pognon
 */
public class RulesByName extends Rules{

    /**
     * Constructeur(s) de RulesByName
     */
    public RulesByName(PlayerList p) {
        super(p);
        getFirstByLowerName();
    }

    /**
     * Méthode permettant de trier alphabétiquement une liste de
     * joueurs par rapport à leurs noms
     * @return playerList
     */
    private PlayerList getFirstByLowerName() {
        PlayerList sortedList = new PlayerList(this.playerList.getGame());
        while (this.playerList.getSize() != 1) {
           String theLower = getLowerNameInList();
            for (int i = 1; i < this.playerList.getSize(); i++) {
                if (theLower.equals(this.playerList.getPlayer(i).getName())) {
                    this.playerList.swap(0, i);
                }
            }
            sortedList.addPlayer(this.playerList.getPlayer(0));
            this.playerList.removePlayer(this.playerList.getPlayer(0));
        }
        for (int i = 1; i < sortedList.getSize(); i++) {
            this.playerList.addPlayer(sortedList.getPlayer(i));
        }
        return this.playerList;
    }



    /**
     * Méthode permettant d'obtenir le nom le plus haut placé dans
     * une liste de nom par rapport à un tri alphabétique
     * @return theLower
     */
    private String getLowerNameInList() {
        String theLower = (this.playerList.getPlayer(0).getName().toLowerCase()) ;
        for (int i =1; i < this.playerList.getSize(); i++) {
            String currentName = (this.playerList.getPlayer(i).getName().toLowerCase());
            if(theLower.compareTo(currentName)<0){
                theLower = currentName;
                break;
            }
        }
        return theLower;
    }
}


