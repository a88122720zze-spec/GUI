import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

public class BossState implements State{
	private Model model; // Model を次の状態に渡したい場合は遷移元も保持する必要あり
	private Image image;
	
	
	public BossState(Model m) throws IOException { 
		model = m;
		// 画像を読み込む．画像ファイルは src においておくと bin に自動コピーされる
        image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("boss.png"));
	}


	// タイトル状態におけるキータイプイベント処理
	public State processKeyTyped(String typed) {
		if (typed.equals("ENTER") ) {
			model.unlock();
			return model.getpreState();
		}
			
		return this;
	}
	// タイトル状態の時間経過イベントを処理するメソッド
	public State processTimeElapsed(int msec) { return this; }
	
	// タイトル状態のマウスクリックイベントを処理するメソッド
	public State processMousePressed(int x, int y) { return this; }
	
	// タイトル状態を描画するメソッド
	public void paintComponent(Graphics g) {
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		g.setColor(Color.WHITE);
		//タイトル名
		g.drawString("Boss State  :  Enter to back", 10, 15);
		
		g.drawImage(image, 0,30, 850,520, model.getView());
		
		
		
	}
	
	
}