import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Iterator;

public class GameState implements State {
	
	private Type type;
    private Judge judge;
    private Human human;
	private Model model; // Model を次の状態に渡したい場合は遷移元も保持する必要あり
	private String typedChar;
	private Image image;
	
	public GameState(Model m) throws IOException { 
		this.model = m; 
		type = new Type();
        judge =new Judge();
        judge.reselect();
        judge.readtxt();
        human = new Human();
        typedChar = "";
        
        // 画像を読み込む．画像ファイルは src においておくと bin に自動コピーされる
         image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("woman.png"));
	
	}


	// ゲーム中状態におけるキータイプイベント処理
	public State processKeyTyped(String typed) {
		typedChar = typed;
//      if (typed.equals("ESC")) { 
//          enableKeyRollover = !enableKeyRollover; // 同時押し許可モード反転
//          controller.setKeyRollover(enableKeyRollover);
//      }
      if(typedChar.equals("ENTER")) {
      	int num =judge.judgeFeature(type.getString(), human.getfeature());//判定 文字列
      	if(num != 0) {//正解
      		human.gageadd( num);
      		model.addscore(num*num*num);
      		try {
				judge.reset();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
      		type.reset();
      		model.timereset();
      	}
      	else {//不正解
      		human.gagelow();
      		type.reset();
      		model.addscore(-50);//50ポイントを引く
      	}
      	
      }
      else if(typedChar.equals("BS")) {
      	type.reset();
      }
      else if(typedChar.equals("SHIFT")) {
      	//何もせず戻す
      }
      else {
      	type.typeRun(typedChar);
      }
			//return new ResultGame(model);
	return this;
	}
	// ゲーム中状態の時間経過イベントを処理するメソッド
	public State processTimeElapsed(int msec) { 
		model.addTimer();
    	if( model.judgetime()) {//0以下
    		model.timereset();
    		human.gagelow();
    	}
    	
    	if(human.endcheck() ==-1) {//負け
    		//終了処理リザルト画面へ
    		model.lastscore(5000);//0設定にする
    		try {
				return  new ResultState(model);
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
    	}
    	else if(human.endcheck() ==1) {//勝ち
    		model.lastscore(model.getalltime());
    		//終了処理、リザルト画面へ
    		try {
				return new ResultState(model);
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
    	}
        //view.repaint();
		
		return this; 
	}
	
	// ゲーム中状態のマウスクリックイベントを処理するメソッド
	public State processMousePressed(int x, int y) { return this; }
	
	// ゲーム中状態を描画するメソッド
	public void paintComponent(Graphics g) {
		 // 描画する
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
        g.setColor(Color.WHITE);

        g.drawString("Timer: " + model.getTime()/10, 400, 50);
        //g.drawString("Key Typed: " + model.getTypedChar(), 100, 200);
        //g.drawString("KeyRollover: " + model.getEnableKeyRollover(), 100, 250);
        //g.drawString("Mouse Pressed: " + model.getMX() + "," + model.getMY(), 100, 300);
        //g.drawRect(x, y, width, height);
        g.drawRect(50, 60, 90, 200);
        g.drawString("Life: "+ human.getgege() , 50, 50);
        g.setColor(Color.GREEN);//四角の色を緑に設定
        g.fillRect(50, 260 - human.getgege() * 2, 90, human.getgege() * 2); 
        
        g.setColor(Color.WHITE);//白に戻す
        
        //g.drawRect(200,60, 250, 160);//画像にする
        // 画像を表示 
        g.drawImage(image, 220, 60,200,250, model.getView());
        
        g.drawString("selected: " , 30, 300);//1文字
        g.drawString( judge.getselected() ,60, 340);
        g.drawRect(25,270, 145, 80);
        
        g.drawString("特性: " + human.getfeatureThings() , 200, 350);
        g.drawString("type: " + type.getString(), 200, 410);
        
        //候補を示す
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));//大きさ変更
        g.setColor(Color.WHITE);
        Iterator<Feature> it = judge.getFeature().iterator();
        int num =0;
        while (it.hasNext()) {
            Feature f = it.next();
            g.drawString( f.getfN() + " : " + f.getfR() , 500,100+30*num );
            num++;
            
        }
        
        // 画像の表示例
        //g.drawImage(image, model.getMX(), model.getMY(), this);

	}
}
