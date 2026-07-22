import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ResultState implements State{
	private Model model; // Model を次の状態に渡したい場合は遷移元も保持する必要あり
	List<String> topname = new ArrayList<>();
	List<Integer> topscore = new ArrayList<>();
	private int number;
	
	public ResultState(Model m) throws IOException { 
		model = m;
		number =readRank(model.getname(), model.getscore());//仮のデータmodel.を入れる
		write();
	}


	// タイトル状態におけるキータイプイベント処理
	public State processKeyTyped(String typed) {
		if (typed.equals("ENTER")) {
			model.resetname();
			model.resetscore();
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
		
		//result表示
		g.drawString("Result", 200, 100);
		//score順位の表示	
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		g.setColor(Color.WHITE);
		g.drawString("Your score is 2001", 200, 170);
		if(number<11) {//ランキングは１０までとする
			g.drawString("Your number is " +  number , 220, 210);
		}
		else {
			g.drawString("Your have no number... "  , 220, 210);
		}
		g.drawString("Your score is " +  model.getscore() , 220, 260);
		
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		g.setColor(Color.WHITE);
		//遊び方
		g.drawString("Enter to backTitle!!", 200, 300);
		
		
	}
	public int readRank(String usrname,int score) throws IOException {
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
		
		if(topscore.size() ==0) {//ランキングに１人もいないとき
    		topname.add(0 , usrname);
			topscore.add(0 , score);
			return 1;
    	}
		//ランキングを上から順にみていく
		for(int i=0; i<topscore.size() ;i++) {
    		if(topscore.get(i) <= score ) {//加える
    			topname.add(i , usrname);
    			topscore.add(i , score);
    			//rank =i;
    			return i+1;
    		}
    		
    	}
    	
    	// 一番下に追加
        topname.add(usrname);
        topscore.add(score);
        return topscore.size();
	}
	
	//書き込み用の関数
	public void write() throws FileNotFoundException {
		URL textURL = getClass().getResource("ranking.txt");//取得
		try (PrintStream out = new PrintStream(//binに書き込まれる
				new FileOutputStream(textURL.getPath()))) {
			//out.println("hello, world");
			for (int i = 0; i < topname.size() && i<10 ; i++) {
			    out.println(topname.get(i) + "#" + topscore.get(i));
			}
		}
	}
	
}
