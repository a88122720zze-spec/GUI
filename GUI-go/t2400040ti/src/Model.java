public class Model {

    private View view;
    private Controller controller;
    private Type type;

    // Sample instance variables:
    private int time;
    private String typedChar = "";
    private int mx, my;
    private boolean enableKeyRollover = true;

    public Model() {
        view = new View(this);
        controller = new Controller(this);
        type = new Type(this);
    }

    public synchronized void processTimeElapsed(int msec) {
        time++;
        view.repaint();
    }

    public synchronized void processKeyTyped(String typed) {
        typedChar = typed;
//        if (typed.equals("ESC")) { 
//            enableKeyRollover = !enableKeyRollover; // 同時押し許可モード反転
//            controller.setKeyRollover(enableKeyRollover);
//        }
        if(typed.equals("ENTER")) {
        	
        }
        else if(typed.equals("BS")) {
        	type.reset();
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

}
