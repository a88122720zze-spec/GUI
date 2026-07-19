import java.io.IOException;
import java.util.ArrayList;

public class Model {

    private View view;
    private Controller controller;
    private Type type;
    private Judge judge;
    private Human human;

    // Sample instance variables:
    private int time;
    private String typedChar = "";
    private int mx, my;
    private boolean enableKeyRollover = true;

    public Model() throws IOException {
        view = new View(this);
        controller = new Controller(this);
        type = new Type(this);
        judge =new Judge();
        judge.reselect();
        judge.readtxt();
        human = new Human();
    }

    public synchronized void processTimeElapsed(int msec) {
        time++;
        view.repaint();
    }

    public synchronized void processKeyTyped(String typed) throws IOException {
        typedChar = typed;
//        if (typed.equals("ESC")) { 
//            enableKeyRollover = !enableKeyRollover; // 同時押し許可モード反転
//            controller.setKeyRollover(enableKeyRollover);
//        }
        if(typed.equals("ENTER")) {
        	int num =judge.judgeFeature(type.getString(), human.getfeature());//判定 文字列
        	if(num != 0) {//正解
        		human.gageadd( num);
        		judge.reset();
        		type.reset();
        	}
        	else {
        		human.gagelow();
        		type.reset();
        	}
        	
        }
        else if(typed.equals("BS")) {
        	type.reset();
        }
        else if(typed.equals("SHIFT")) {
        	//何もせず戻す
        }
        else {
        	type.typeRun(typed);
        }
        
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
        return time;
    }

    public String getTypedChar() {
        return typedChar;
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
    public String getString() {
    	return type.getString();
    }
    public ArrayList<Feature> getFeature() {
        return judge.getFeature();
    }
    public String getselected() {
    	return judge.getselected();
    }
    public String getFeatureThings() {
    	return human.getfeatureThings();
    }
    public int getlife() {
    	return human.getgege();
    }

}
