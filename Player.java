
public class Player {
    private String playerName;
    private int highScore;
    private int gamesPlayed;
    
    public Player( String playerName ){
        this.playerName = playerName;
        gamesPlayed = 0;
        highScore = 0;
    }
    public void setPlayerName( String playerName ){
        this.playerName = playerName;
    }
    public String getPlayerName(){
        return playerName;
    }
    public void setHighScore( int score ){
        if( score > highScore ){
            this.highScore = score;
        }
    }
    public int getHighScore(){
        return highScore;
    }
    public void increaseGamesPlayed(){
        this.gamesPlayed++;
    }
    public boolean equals( Object obj ){
        if( obj instanceof Player){
            Player p = (Player) obj;
            return this.playerName.equalsIgnoreCase( p.playerName );
        }
        return false;
    }
    public String toString(){
        return "Player Name: "+playerName + "\nGames Played: " + gamesPlayed +"\nHigh Score: " + highScore;
    }
}
