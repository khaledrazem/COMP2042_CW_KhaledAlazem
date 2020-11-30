package p4_group_8_repo;

public class ScoreType {


    public String Username;
    public int Score;
    public int Level;
  
 
    public ScoreType(String Username, int score,int Level) {
    	
        this.Username = Username;
        this.Score = score;
        this.Level=Level;
    
    }
    
    public int getScore() {
    	return(Score);
    }
    
    public int getLevel() {
    	return(Level);
    }
    
    public String getUsername() {
    	return(Username);
    }
    
    public void setScore(int Score) {
    	this.Score=Score;
    }
    
    public void setLevel(int Level) {
    	this.Level=Level;
    }
    
    public void setUsername(String Username) {
    	this.Username=Username;
    }
    
}
