import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

public class Judge {
	
	private String selected;//選ばれた１つ
	private String [] kouho;//候補数、候補
	//private ArrayList<String> vacablarylist; 
	private String [] strings;//候補数、候補
	
	public Judge() {
		selected ="a";
		kouho = new String[] {"a","i","u","e","o","b"};
		//vacablarylist =new ArrayList<>();
		strings = new String[10];//読み込んだもの
		
	}
	public void reselect() {//１文字をランダムにする
		Random random = new Random();
		int randomnum = random.nextInt(kouho.length);
		selected = kouho[randomnum];
	}
	public void readtxt() throws IOException {
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
			textURL = getClass().getResource("file_etxt");
		}
		else if(selected.equals("o")) {
			textURL = getClass().getResource("file_o.txt");
		}
		
		BufferedReader reader = new BufferedReader(
		new InputStreamReader(textURL.openStream()));
		String line;
		int num=0;
		while ((line = reader.readLine()) != null) {
			//vacablarylist.add(line);
			strings[num] = line;
			num++;
		}
	}
	public String[] getStrings() {
		return strings;
	}
	
	
}
