/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common.player;

import game.model.common.Game;

/**
 *
 * @author Opti Pognon
 */
public abstract class Human extends Player {
    
    public int age;
    public int id;
    public static int idPlayer =1;
    
    
    public Human(String name,int age, Game g)
    {
        super(name,g);
        this.age = age;
        this.id = idPlayer;
        idPlayer++;
    }
    
    @Override
    public String toString()
    {
        String str = "ID : " + this.getId() + " - " + "Nom : " + this.getName() + " | " + "Age : " + this.getAge() + " | " + "Win : " + this.getGameWin() + " | " + "Played : " + this.getNbGame() + '\n';
        return str;
    }

    @Override
    public void play()
    {
        
    }      

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
