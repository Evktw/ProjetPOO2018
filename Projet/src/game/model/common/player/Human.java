package game.model.common.player;

import game.model.common.Game;

/**
 *
 * @author Opti Pognon
 */
public abstract class Human extends Player {

    /**
     * Attributs
     */
    public int age;
    public int id;
    public static int idPlayer =1;


    /**
     * Constructeur de Human
     * @param name
     * @param age
     * @param g
     */
    public Human(String name,int age, Game g)
    {
        super(name,g);
        this.age = age;
        this.id = idPlayer;
        idPlayer++;
    }

    /**
     * Méthode to String
     * @return String
     */
    @Override
    public String toString()
    {
        String str = "ID : " + this.getId() + " - " + "Nom : " + this.getName() + " | " + "Age : " + this.getAge() + " | " + "Win : " + this.getGameWin() + " | " + "Played : " + this.getNbGame() + '\n';
        return str;
    }

    /**
     * Override de la méthode Play
     */
    @Override
    public void play()
    {
        
    }

    /**
     * Getters & Setters
     */
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
