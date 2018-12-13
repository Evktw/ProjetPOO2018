/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common.rules;

import game.model.common.PlayerList;
import game.model.common.player.Player;

import java.util.List;

public class RulesByAge extends Rules {

    /**
     * Attributs
     */
    protected boolean younger;  // Le plus jeune si vrai, vieux si faux




    public RulesByAge(PlayerList p, boolean y) {
        super(p);
        this.younger= y;
        //CHERCHER LES HUMAINS
        if(younger == true) {
            this.getHumansByAgeMin(p);
        }
        else {
            this.getHumansByAgeMax(p);
        }
    }


    /**
     * Méthode permettant de récupérer un joueur en fonction de l'age de chaque joueur d'une liste de joueurs.
     */
    private Player getHumansByAgeMin(PlayerList p){
        int start = 0;
        int indMin = start;
        List<Player> tab = p.getPlayerList();
        for( int i = start +1; i < tab.size() ;i++){
            if(this.tab[i]<this.tab[indMin]){
                indMin=i;
            }
        }
        return p[indMin];
    }


    private Player getHumansByAgeMax(PlayerList p){
        int start = 0;
        int indMax = start;
        List<Player> tab = p.getPlayerList();
        for( int i = start +1; i < tab.size() ;i++){
            if(tab[i]>tab[indMax]){
                indMax=i;
            }
        }
        return p[indMax];
    }
}
