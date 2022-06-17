package question.pkg2;

/**
 *
 * @author Ntsako
 */
public class player {
    //Storing the player name
    String playerName;
    //Storing the scores
    int playerScore = 0;
    
    //Setter methods
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore += playerScore;
    }

    //The getter methods
    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }
    
    //Resetting the player scores
    public void resetScore(){
        this.playerScore = 0;
    }
}
