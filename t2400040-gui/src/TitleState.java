import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

public class TitleState implements State {
	private Model model; // Model を次の状態に渡したい場合は遷移元も保持する必要あり
	public TitleState(Model m) { model = m; }


	// タイトル状態におけるキータイプイベント処理
	public State processKeyTyped(String typed) {
		if (typed.equals(" "))
			try {
				return new GameState(model);
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		return this;
	}
	// タイトル状態の時間経過イベントを処理するメソッド
	public State processTimeElapsed(int msec) { return this; }
	
	// タイトル状態のマウスクリックイベントを処理するメソッド
	public State processMousePressed(int x, int y) { return this; }
	
	// タイトル状態を描画するメソッド
	public void paintComponent(Graphics g) {
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
		g.setColor(Color.WHITE);
		g.drawString("TITLE", 100, 50);
	}
}