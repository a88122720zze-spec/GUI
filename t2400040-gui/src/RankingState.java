import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class RankingState implements State {
	private Model model; // Model を次の状態に渡したい場合は遷移元も保持する必要あり
	public RankingState(Model m) { model = m; }


	// タイトル状態におけるキータイプイベント処理
	public State processKeyTyped(String typed) {
		if (typed.equals("ENTER")) {
			return new TitleState(model);
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
		
		//ランキング
		g.drawString("ランキング" , 200, 110);
		
		
		
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		g.setColor(Color.WHITE);
		//遊び方
		g.drawString("back to title to Enter", 500, 400);
		
	}
}