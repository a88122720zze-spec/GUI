import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

public class TitleState implements State {
	private Model model; // Model を次の状態に渡したい場合は遷移元も保持する必要あり
	public TitleState(Model m) { model = m; }


	// タイトル状態におけるキータイプイベント処理
	public State processKeyTyped(String typed) {
		if (typed.equals("ENTER")) {
			try {
				return new GameState(model);
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		else if(typed.equals("p")) {
			return new HowtoPlayState(model);
		}
		else if(typed.equals("r")) {
			return new RankingState(model);
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
		
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		g.setColor(Color.WHITE);
		//遊び方
		g.drawString("遊び方  ->  p", 200, 100);
		//ランキング
		g.drawString("ランキング -> r" , 200, 150);
		
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		g.setColor(Color.WHITE);
		//遊び方
		g.drawString("Enter to start Game!!", 200, 300);
		
		
	}
}