package game.model.common.player;

import game.model.common.Game;




public abstract class Player {
  
    public static int idPlayer = 1;
    
    protected String name;
    protected int age;
    protected int id;
    protected int nbGame;
    protected int gameWin;
    protected Game game;
    /**
     * Constructeur de la classe Joueur
     * @param name
     * @param age
     * @param isHuman
     */
    Player(String name, int age, Game game)
    {
        this.gameWin = 0;
        this.nbGame = 0;
        this.name = name;
        this.age = age;
        this.id = idPlayer;
        idPlayer++;
        this.game = game;
    }
    
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

    protected static int getIdPlayer() {
        return idPlayer;
    }

    protected static void setIdPlayer(int idPlayer) {
        Player.idPlayer = idPlayer;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected int getNbGame() {
        return nbGame;
    }

    protected void setNbGame(int nbGame) {
        this.nbGame = nbGame;
    }

    protected int getGameWin() {
        return gameWin;
    }

    protected void setGameWin(int gameWin) {
        this.gameWin = gameWin;
    }

    protected Game getGame() {
        return game;
    }

    protected void setGame(Game game) {
        this.game = game;
    }

    
    

}
