package game.model.common.player;

import game.model.common.Game;




public abstract class Player {
  
    
    protected String name;
    protected int nbGame;
    protected int gameWin;
    protected Game game;
    /**
     * Constructeur de la classe Joueur
     * @param name
     * @param age
     * @param isHuman
     */
    Player(String name, Game game)
    {
        this.gameWin = 0;
        this.nbGame = 0;
        this.name = name;
        this.game = game;
    }
    
    protected void play()
    {
        
    }        

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbGame() {
        return nbGame;
    }

    public void setNbGame(int nbGame) {
        this.nbGame = nbGame;
    }

    public int getGameWin() {
        return gameWin;
    }

    public void setGameWin(int gameWin) {
        this.gameWin = gameWin;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean isActive) {
        this.active = isActive;
    }
    
    
}