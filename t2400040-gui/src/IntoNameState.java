import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

public class IntoNameState implements State{
	private Model model; // Model を次の状態に渡したい場合は遷移元も保持する必要あり
	
	public IntoNameState(Model m) throws IOException { 
		model = m;
	}


	// タイトル状態におけるキータイプイベント処理
	public State processKeyTyped(String typed) {
		if (typed.equals("ENTER") ) {
			if(model.getname().length() ==0) {
				//何もしない
				return this;
			}
			try {
				return new GameState(model);
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		else if(typed.equals("BS")) {//文字列のリセット
			model.resetname();
		}
		else if(typed.equals("~") || typed.equals("#")) {
			//何もしない
		}
		else {
			model.addname(typed);
		}
			
		return this;
	}
	// タイトル状態の時間経過イベントを処理するメソッド
	public State processTimeElapsed(int msec) { return this; }
	
	// タイトル状態のマウスクリックイベントを処理するメソッド
	public State processMousePressed(int x, int y) { return this; }
	
	// タイトル状態を描画するメソッド
	public void paintComponent(Graphics g) {
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		g.setColor(Color.WHITE);
		//タイトル名
		g.drawString("SPEED PRAISE GAME", 150, 50);
		g.drawString("名前入力", 200,110);
		
		//
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		g.setColor(Color.WHITE);
		//名前入力表示
		g.drawString("禁止文字　: ~, # ", 250, 150);
		
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		g.setColor(Color.WHITE);
		//名前入力表示
		g.drawString("user name : " + model.getname() , 150, 250);
		
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		g.setColor(Color.WHITE);
		//遊び方
		g.drawString("Enter to backTitle!!", 370, 380);
		
		
	}
	
	
	//書き込み用の関数
	
	
}