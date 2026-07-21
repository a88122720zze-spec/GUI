import java.io.IOException;

public class Model {

    private View view;
    private Controller controller;
    private State state;


    // Sample instance variables:
    private Timer time;
    //private String typedChar = "";
    private int mx, my;
    private boolean enableKeyRollover = true;
    private User user;

    public Model() throws IOException {
        view = new View(this);
        controller = new Controller(this);
        time =new Timer();
        state = new TitleState(this); // 初期状態はタイトル状態
        user =new User();
        
    }

    public synchronized void processTimeElapsed(int msec) {//時間経過
    	state = state.processTimeElapsed(msec);
        view.repaint();
    }

    public synchronized void processKeyTyped(String typed) throws IOException {

    	state = state.processKeyTyped(typed);
        view.repaint();        
    }

    public synchronized void processMousePressed(int x, int y) {
//        mx = x;
//        my = y;
//        view.playBombSound();
//        view.repaint();
    }

    public void start() {
        controller.start();
    }

    public View getView() {
        return view;
    }

    public Controller getController() {
        return controller;
    }

    public int getTime() {
        return time.getturntime();
    }
    public void addTimer() {
    	time.addtimer();
    }
    public void timereset() {
    	time.reset();
    }
    public boolean judgetime() {
    	return time.judgetime();
    }
    public int getalltime() {
		return time.getalltime();
	}



    public int getMX() {
        return mx;
    }

    public int getMY() {
        return my;
    }

    public boolean getEnableKeyRollover() { 
        return enableKeyRollover;
    }
    public State getState() {
    	return state;
    }
    
    public void  resetname() {
    	user.resetname();
    }
    public void  resetscore() {
    	user.resetscore();
    }
    public void  addscore(int num) {
    	user.addscore(num);
    }
    public void  lastscore(int time) {
    	user.lastscore(time);
    }
    public void addname(String st) {
    	user.addname(st);
    }
    public String  getname() {
    	return user.getname();
    }
    public int getscore() {
    	return user.getscore();
    }

}
