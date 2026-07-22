
public class Timer {
	private int alltime;
	private int turntime;
	
	private static int limit = 209;
	
	public Timer() {
		alltime =0;
		turntime =209;
	}
	public void addtimer() {
		alltime++;
		turntime--;
	}
	public void reset() {
		turntime = limit;
	}
	public boolean judgetime() {
		if( turntime < 0) {
			return true;
		}
		return false;
	}
	
	public int getalltime() {
		return alltime;
	}
	public int getturntime() {
		return turntime;
	}
}
