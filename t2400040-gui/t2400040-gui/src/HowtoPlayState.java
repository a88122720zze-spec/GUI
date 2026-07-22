import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HowtoPlayState implements State {
	private Model model; // Model を次の状態に渡したい場合は遷移元も保持する必要あり
	public HowtoPlayState(Model m) { model = m; }


	// タイトル状態におけるキータイプイベント処理
	public State processKeyTyped(String typed) {
		if (typed.equals("ENTER")) {
			return  new TitleState(model);
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
		//遊び方
		g.drawString("遊び方", 200, 120);
		
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		g.setColor(Color.WHITE);
		//ランキング
		g.drawString("心が弱っている人がいる…、" , 200, 150);
		g.drawString("相手の特性に合う文字をタイピングして相手を褒めよう", 200, 170);
		g.drawString("右下図の特性に合った候補の文字を、平仮名で打ち、Enterで発声！社会復帰を目指せ！", 200, 190);
		g.drawString("社会復帰にはメータをためる必要がある", 500, 230);
		g.drawString("よりよい言葉選びでゲージが上がる", 500, 250);
		g.drawString("失敗・時間切れでゲージが下がる…", 500, 270);
		g.drawString("  下がりきると社会復帰失敗…", 500, 290);
		g.drawString("よりよい言葉を選んで社会復帰を目指そう！", 500, 330);
		
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		g.setColor(Color.WHITE);
		//遊び方
		g.drawString("back to title to Enter", 500, 450);
		
		
		
		//位置調整
		int x =200;
		int y =10;
		
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		g.setColor(Color.WHITE);
	    // 外枠
		g.drawRect(0+y, 0+x, 450, 270);
	    // 気力メータ
		g.drawRect(15+y, 20+x, 60, 150);
	    // メータ部分（塗りつぶしの形だけ）
		g.fillRect(17+y, 60+x, 58, 108);
		g.drawString("メータ", 20+y, 35+x);
	    // 人（画像領域）
		g.drawRoundRect(120+y, 20+x, 130, 120, 20, 20);
		g.drawString("人", 125+y, 40+x);
	    // 特性
		g.drawRect(120+y, 160+x, 110, 30);
		g.drawString("特性", 122+y, 175+x);
		// 指定文字
		g.drawRect(15+y, 180+x, 100, 60);
		g.drawString("指定文字", 17+y, 200+x);
	    // タイピング文字
		g.drawRect(120+y, 210+x, 110, 30);
		g.drawString("タイピング文字", 120+y, 225+x);
	    // 特徴の列挙
		g.drawRect(260+y, 45+x, 160, 220);
		g.drawString("特徴の列挙", 262+y, 60+x);
		//Timer
		g.drawString("timer", 270+y, 20+x);
		
		
	}
}