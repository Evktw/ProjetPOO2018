package game.model.common.player;

import game.model.common.Game;

/**
 *
 * @author Opti-Pognon
 */

public abstract class Player {

    protected String name;          //Pseudo du joueur
    protected int nbGame;           //Nombre de parties effectuées par le joueur
    protected int gameWin;          //Nombre de parties gagnées par le joueur
    protected Game game;            //Nom du jeu auquel le joueur a participé

    /**
     * Constructeur de la classe Joueur
     * @param name
     * @param game
     */
    Player(String name, Game game)
    {
        this.gameWin = 0;
        this.nbGame = 0;
        this.name = name;
        this.game = game;
    }

    /**
     * Méthode play par défaut
     */
    public void play()
    {

    }

    /**
     * Getters & Setters
     */
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getNbGame() { return nbGame; }

    public void incrementNbGame() { this.nbGame++; }

    public int getGameWin() { return gameWin; }

    public void incrementGameWin() { this.gameWin++; }

    public Game getGame() { return game; }

    public void setGame(Game game) { this.game = game; }
}