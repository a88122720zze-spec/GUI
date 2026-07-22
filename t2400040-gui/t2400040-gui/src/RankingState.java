import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RankingState implements State {
	private Model model; // Model を次の状態に渡したい場合は遷移元も保持する必要あり
	public RankingState(Model m) { 
		model = m; 
		try {
			readrank();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	List<String> topname = new ArrayList<>();
	List<Integer> topscore = new ArrayList<>();


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
		g.drawString("ランキング" , 140, 110);
		
//		for(int i=0; i< top_name.size()  ; i++) {
//			String string =  (i+1) + "位: " + topname(i) +" : score " + topname(i);
//			//x++;
//			g.drawString(string , 200, 110);
//		}
		
		
		
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		g.setColor(Color.WHITE);
		//ランキングの順位を記述する
		Iterator<String> it1 = topname.iterator();
		Iterator<Integer>  it2= topscore.iterator();
        int num =0;
        while (it1.hasNext()) {
            String f = it1.next();
            Integer i =it2.next();
            g.drawString( num+1 + "位:  " + f  + "  Score: "+  i   , 145,150+30*num );
            num++;
            
        }
		
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		g.setColor(Color.WHITE);
		//遊び方
		g.drawString("back to title to Enter", 500, 400);
		
	}
	
	public void readrank() throws IOException {
		//一回一回読み込まないと更新できない
		URL textURL = getClass().getResource("Ranking.txt");
		BufferedReader reader = new BufferedReader(
		new InputStreamReader(textURL.openStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			//System.out.println(line);
			
			 String[] parts = line.split("#");

		     topname.add(  parts[0]);               // ユーザー名
		     topscore.add( Integer.parseInt(parts[1])); // スコア
		     
		     //num++;
		}
	}
}