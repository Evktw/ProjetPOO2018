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
     * @param game
     */
    Player(String name, Game game)
    {
        this.gameWin = 0;
        this.nbGame = 0;
        this.name = name;
        this.game = game;
    }
    
    public void play()
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

    public void incrementNbGame() {
        this.nbGame++;
    }

    public int getGameWin() {
        return gameWin;
    }

    public void incrementGameWin() {
        this.gameWin++;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
    
}