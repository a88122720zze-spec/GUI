import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Judge {
	
	private String selected;//選ばれた１つ
	private String [] kouho;//候補数、候補
	//private ArrayList<String> vacablarylist; 
	//private String [] strings;//候補数、候補
	private ArrayList<Feature>  feature;
	private JudgeFeature jf;
	
	public Judge() {
		selected ="a";
		kouho = new String[] {"a","i","u","e","o","b"};
		//vacablarylist =new ArrayList<>();
		//strings = new String[10];//読み込んだもの
		feature = new ArrayList<>();
		jf =new JudgeFeature();
		
	}
	public void reselect() {//１文字をランダムに決定
		Random random = new Random();
		int randomnum = random.nextInt(kouho.length);
		selected = kouho[randomnum];
	}
	public void readtxt() throws IOException {//特性候補を読み取る
		URL textURL = null;
		if(selected.equals("a")) {
			textURL = getClass().getResource("file_a.txt");
		}
		else if(selected.equals("b")) {
			textURL = getClass().getResource("file_b.txt");
		}
		else if(selected.equals("i")) {
			textURL = getClass().getResource("file_i.txt");
		}
		else if(selected.equals("u")) {
			textURL = getClass().getResource("file_u.txt");
		}
		else if(selected.equals("e")) {
			textURL = getClass().getResource("file_e.txt");
		}
		else { //if(selected.equals("o")) {
			textURL = getClass().getResource("file_o.txt");
		}
		
		BufferedReader reader = new BufferedReader(
		new InputStreamReader(textURL.openStream()));
		String line;
		int num=0;
		while ((line = reader.readLine()) != null) {
			//vacablarylist.add(line);
			String[] parts = line.split(":");
			num = Integer.parseInt(parts[3],2);
			//strings[num] = line;
			//num++;
			feature.add(new Feature(parts[0], parts[1], parts[2], num));
		}
	}
	public ArrayList<Feature> getFeature() {//
	    return feature;
	}
	public String getselected() {
		return selected;
	}
	public void reset() throws IOException {//特性内容のリセット
		//リセット
		feature.clear();
		reselect() ;
		readtxt();
		
	}
	public int judgeFeature(String inter ,int fe) {//特性の判定を行う 入力文字；humanの特性
		//候補との一致判断
		Iterator<Feature> it = feature.iterator();
        //int num =0;
        while (it.hasNext()) {
            Feature f = it.next();
            if(inter.equals(f.getfH())) {//名前一致
            	return jf.judge2(fe, f.getfe());//特性の一致数を返す
            }
            //num++;
        }
		return 0;
	}
	
	
}
