
public class User {
	private String name;
	private int score;
	
	public User() {
		name ="";
		score= 0;
	}
	
	public void resetname() {
		name ="";
	}
	public void resetscore() {
		score =-0;
	}
	public void addscore(int num) {
		score += num;
	}
	public void lastscore(int time) {
		score += (5000-time);
	}
	public void addname(String st) {
		name += st;
	}
	
	public String getname() {
		return name;
	}
	public int getscore() {
		return score;
	}
}
