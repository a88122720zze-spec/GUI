
public class toJapanese {
private
	//boolean tu_flag; 
	String [] StReturn;
 public
 	toJapanese() {
	 	//tu_flag =false;]
	 	StReturn= new String[2];
 		StReturn[0] = "";//確定した文字
 		StReturn[1] = "";//未確定の文字
 	}
 
 	boolean tuJudge(String st) {
 		char moji1 =st.charAt(0);
 		char moji2 =st.charAt(1);
 		if(moji1 ==moji2 && moji1 != 'n') {
 			//tu_flag =true;
 			return true;
 		}
 		return false;
 	}
 	String changeAa(String st) {
 		return st= st.toLowerCase();
 	}
 	String change1(String st) {
	    switch (st) {
	        case "a":
	            return "あ";
	        case "i":
	            return "い";
	        case "u":
	            return "う";
	        case "e":
	            return "え";
	        case "o":
	            return "お";
	        //数字    
	        case "0": return "０";
	        case "1": return "１";
	        case "2": return "２";
	        case "3": return "３";
	        case "4": return "４";
	        case "5": return "５";
	        case "6": return "６";
	        case "7": return "７";
	        case "8": return "８";
	        case "9": return "９";    
	        
	        //記号
	        case "!": return "！";
 	        case "\"": return "”";
 	        case "#": return "＃";
 	        case "$": return "＄";
 	        case "%": return "％";
 	        case "&": return "＆";
 	        case "'": return "’";
 	        case "(": return "（";
 	        case ")": return "）";
 	        case "=": return "＝";
 	        case "~": return "～";
 	        case "|": return "｜";
 	        case "-": return "－";
 	        case "^": return "＾";
 	        case "\\": return "￥";   // バックスラッシュ
 	        case "+": return "＋";
 	        case "*": return "＊";
 	        case "}": return "}";
 	        case ";": return "；";
 	        case ":": return "：";
 	        case "]": return "］";
 	        case "<": return "＜";
 	        case ">": return "＞";
 	        case "?": return "？";
 	        case "_": return "＿";
 	        case ",": return "、";
 	        case ".": return "。";
 	        case "/": return "・";
	        default:
	            return st;
	    }
	}
 	String change2(String st) {
 	    switch (st) {
 	        // か行
 	        case "ka": return "か";
 	        case "ki": return "き";
 	        case "ku": return "く";
 	        case "ke": return "け";
 	        case "ko": return "こ";

 	        // さ行
 	        case "sa": return "さ";
 	        case "si": return "し";
 	        case "su": return "す";
 	        case "se": return "せ";
 	        case "so": return "そ";

 	        // た行
 	        case "ta": return "た";
 	        case "ti": return "ち";
 	        case "tu": return "つ";
 	        case "te": return "て";
 	        case "to": return "と";

 	        // な行
 	        case "na": return "な";
 	        case "ni": return "に";
 	        case "nu": return "ぬ";
 	        case "ne": return "ね";
 	        case "no": return "の";

 	        // は行
 	        case "ha": return "は";
 	        case "hi": return "ひ";
 	        case "hu": return "ふ";
 	        case "he": return "へ";
 	        case "ho": return "ほ";

 	        // ま行
 	        case "ma": return "ま";
 	        case "mi": return "み";
 	        case "mu": return "む";
 	        case "me": return "め";
 	        case "mo": return "も";

 	        // や行
 	        case "ya": return "や";
 	        case "yu": return "ゆ";
 	        case "yo": return "よ";

 	        // ら行
 	        case "ra": return "ら";
 	        case "ri": return "り";
 	        case "ru": return "る";
 	        case "re": return "れ";
 	        case "ro": return "ろ";

 	        // わ行
 	        case "wa": return "わ";
 	        case "wo": return "を";

 	        // が行
 	        case "ga": return "が";
 	        case "gi": return "ぎ";
 	        case "gu": return "ぐ";
 	        case "ge": return "げ";
 	        case "go": return "ご";

 	        // ざ行
 	        case "za": return "ざ";
 	        case "zi": return "じ";
 	        case "zu": return "ず";
 	        case "ze": return "ぜ";
 	        case "zo": return "ぞ";

 	        // だ行
 	        case "da": return "だ";
 	        case "di": return "ぢ";
 	        case "du": return "づ";
 	        case "de": return "で";
 	        case "do": return "ど";

 	        // ば行
 	        case "ba": return "ば";
 	        case "bi": return "び";
 	        case "bu": return "ぶ";
 	        case "be": return "べ";
 	        case "bo": return "ぼ";

 	        // ぱ行
 	        case "pa": return "ぱ";
 	        case "pi": return "ぴ";
 	        case "pu": return "ぷ";
 	        case "pe": return "ぺ";
 	        case "po": return "ぽ";

 	        // 小文字
 	    // F系
 	       case "fa": return "ふぁ";
 	       case "fi": return "ふぃ";
 	       case "fu": return "ふ";
 	       case "fe": return "ふぇ";
 	       case "fo": return "ふぉ";
 	       

 	       // V系
 	       case "va": return "ヴぁ";
 	       case "vi": return "ヴぃ";
 	       case "vu": return "ヴ";
 	       case "ve": return "ヴぇ";
 	       case "vo": return "ヴぉ";

 	       // W系
 	       case "wi": return "うぃ";
 	       case "we": return "うぇ";

 	       // Q系
 	       case "qa": return "くぁ";
 	       case "qi": return "くぃ";
 	       case "qe": return "くぇ";
 	       case "qo": return "くぉ";

 	       // C系
 	       case "ca": return "か";
 	       case "ci": return "し";
 	       case "cu": return "く";
 	       case "ce": return "せ";
 	       case "co": return "こ";

 	       // J系
 	       case "ja": return "じゃ";
 	       case "ji": return "じ";
 	       case "ju": return "じゅ";
 	       case "je": return "じぇ";
 	       case "jo": return "じょ";

 	       // 小文字
 	       case "la": case "xa": return "ぁ";
 	       case "li": case "xi": return "ぃ";
 	       case "lu": case "xu": return "ぅ";
 	       case "le": case "xe": return "ぇ";
 	       case "lo": case "xo": return "ぉ";
 	       
 	      case "lya":  return "ゃ";
	       case "lyu": return "ゅ";
	       case "lyo": return "ょ";
 	       
 	        //ん
 	       case "nn": return "ん";
 	       


 	        default:
 	            return st;
 	    }
 	}
 	String change3(String st) {
 	    switch (st) {
 	    	case "shi": return "し";
 	    	case "tsu": return "つ";
 	    	
 	        // きゃ行
 	        case "kya": return "きゃ";
 	        case "kyu": return "きゅ";
 	        case "kyo": return "きょ";

 	        // しゃ行
 	        case "sha":
 	        case "sya": return "しゃ";
 	        case "shu":
 	        case "syu": return "しゅ";
 	        case "sho":
 	        case "syo": return "しょ";

 	        // ちゃ行
 	        case "cha":
 	        case "tya": return "ちゃ";
 	        case "chi": return "ち";
 	        case "chu":
 	        case "tyu": return "ちゅ";
 	        case "cho":
 	        case "tyo": return "ちょ";

 	        // にゃ行
 	        case "nya": return "にゃ";
 	        case "nyu": return "にゅ";
 	        case "nyo": return "にょ";

 	        // ひゃ行
 	        case "hya": return "ひゃ";
 	        case "hyu": return "ひゅ";
 	        case "hyo": return "ひょ";

 	        // みゃ行
 	        case "mya": return "みゃ";
 	        case "myu": return "みゅ";
 	        case "myo": return "みょ";

 	        // りゃ行
 	        case "rya": return "りゃ";
 	        case "ryu": return "りゅ";
 	        case "ryo": return "りょ";

 	        // ぎゃ行
 	        case "gya": return "ぎゃ";
 	        case "gyu": return "ぎゅ";
 	        case "gyo": return "ぎょ";

 	        // じゃ行
 	        case "ja":
 	        case "jya":
 	        case "zya": return "じゃ";
 	        case "ju":
 	        case "jyu":
 	        case "zyu": return "じゅ";
 	        case "jo":
 	        case "jyo":
 	        case "zyo": return "じょ";

 	        // ぢゃ行
 	        case "dya": return "ぢゃ";
 	        case "dyu": return "ぢゅ";
 	        case "dyo": return "ぢょ";

 	        // びゃ行
 	        case "bya": return "びゃ";
 	        case "byu": return "びゅ";
 	        case "byo": return "びょ";

 	        // ぴゃ行
 	        case "pya": return "ぴゃ";
 	        case "pyu": return "ぴゅ";
 	        case "pyo": return "ぴょ";
 	        
 	    // ふゃ行
 	       case "fya": return "ふゃ";
 	       case "fyu": return "ふゅ";
 	       case "fyo": return "ふょ";

 	       // てゃ行
 	       case "tha": return "てゃ";
 	       case "thi": return "てぃ";
 	       case "thu": return "てゅ";
 	       case "the": return "てぇ";
 	       case "tho": return "てょ";

 	       // とぁ行
 	       case "twa": return "とぁ";
 	       case "twi": return "とぃ";
 	       case "twu": return "とぅ";
 	       case "twe": return "とぇ";
 	       case "two": return "とぉ";

 	       // でゃ行
 	       case "dha": return "でゃ";
 	       case "dhi": return "でぃ";
 	       case "dhu": return "でゅ";
 	       case "dhe": return "でぇ";
 	       case "dho": return "でょ";

 	       // どぁ行
 	       case "dwa": return "どぁ";
 	       case "dwi": return "どぃ";
 	       case "dwu": return "どぅ";
 	       case "dwe": return "どぇ";
 	       case "dwo": return "どぉ";

 	       // うぁ行
 	       case "wha": return "うぁ";
 	       case "whi": return "うぃ";
 	       case "whe": return "うぇ";
 	       case "who": return "うぉ";

 	       // くぁ行（qaでも入力可）
 	       case "qwa": return "くぁ";
 	       case "qwi": return "くぃ";
 	       case "qwe": return "くぇ";
 	       case "qwo": return "くぉ";

 	       // ヴゃ行
 	       case "vya": return "ヴゃ";
 	       case "vyu": return "ヴゅ";
 	       case "vyo": return "ヴょ";

 	        // 小文字
 	        case "xya":
 	        case "lya": return "ゃ";
 	        case "xyu":
 	        case "lyu": return "ゅ";
 	        case "xyo":
 	        case "lyo": return "ょ";

 	        case "xtu":
 	        case "ltu": return "っ";
 	        
 	    // しぇ・ちぇ・じぇ
 	       case "she": return "しぇ";
 	       case "che": return "ちぇ";
 	       case "je":  return "じぇ";

 	       // ふぇ系
 	       case "fye": return "ふぇ";

 	       // ○ぇ系
 	       case "nye": return "にぇ";
 	       case "hye": return "ひぇ";
 	       case "mye": return "みぇ";
 	       case "rye": return "りぇ";
 	       case "gye": return "ぎぇ";
 	       case "bye": return "びぇ";
 	       case "pye": return "ぴぇ";

 	        default:
 	            return st;
 	    }
 	}
 	void reset() {
 		StReturn[0] ="";
 		StReturn[1] ="";
 	}
 	
 	//変換を実際に行うとこ　st1確定、st2未確定
 	String[] translate(String st1,String st2) {
 		int num = st2.length();
 		String chst =changeAa(st2);//A大文字を小文字に
 		reset();
 		
 		if(num <2) {//1文字
 			StReturn[0] = change1(chst);//英語、記号
 			if(StReturn[0] ==chst) {//変換できていない
 				StReturn[1]=StReturn[0];
 				StReturn[0] ="";
 			}
 			//StReturn=changeAa(chst);//記号、UP等はcontrollerのコメントアウトでなくす方針
 		}
 		else if(num ==2) {//２文字
 			//rt8uiなどのように打たれたとき ui等を判別する
// 			if(change1(Character.toString(chst.charAt(0))) != Character.toString(chst.charAt(0)) ) {
// 				StReturn[0] =Character.toString(chst.charAt(0));//1文字を入れる
// 				StReturn[1] =chst.substring(1);//初めの１字を取る、残りを入れる
// 				return StReturn;
// 			}
 			
 			if(tuJudge(chst) ==true) {//っの判定
 				StReturn[0] ="っ";
 				StReturn[1] =chst.substring(1);//初めの１字を取る
 				return StReturn;//
 			}
 			StReturn[0] = change2(chst);//ローマ字
 			if(StReturn[0] ==chst) {//2文字のローマ字ではできていない時
 				StReturn[1] =StReturn[0];
 				StReturn[0] ="";
 				//under2char(StReturn[1]);//以下２文字の判定
 			}
 		}
 		else {//３文字
 			StReturn[0] =change3(chst);
 			if(StReturn[0] == chst) {//変換なし
 				StReturn[0] =Character.toString(chst.charAt(0));//1文字を入れる
 				StReturn[1] =chst.substring(1);//初めの１字を取る、残りを入れる
 				//return translate("", StReturn[1]);
 				String[] STret = under2char(StReturn[1]);//残り２字の判定
 				StReturn[0] += STret[0];
 				StReturn[1] =  STret[1];
 				
 				
 			}
 		}
 		return StReturn;
 	}
 	String[] under2char(String st) {
 		//2文字ともaiuio123等など　例8ui
 		String st1 =st.substring(0,1);
 		String st2 =st.substring(1,2);
 		String stst[] =new String[2];
 		String ch1 =change1(st1);
 		String ch2 =change1(st2);
 		if(st1 != ch1 && st2 !=ch2) {//両方変換可能
 			stst[0] = ch1 + ch2;
 			stst[1] = "";
 			return stst;
 		}
 		
 		else if(st1 !=ch1 && ch2.equals(st2)) {//1文字目だけ可能　例8ub
 			stst[0] = ch1;
 			stst[1] = ch2;
 			return stst;
 		}
 		else if(tuJudge(st)) {//っの場合
 			stst[0] ="っ";
 			stst[1] =st2;
 			return stst;
 		}
 		else if(st != change2(st)) {//２文字で変換可能　8biなど
 			stst[0] = change2(st);
 			stst[1] = "";
 			return stst;
 		}
 		//変換不可
 		stst[0] = "";
		stst[1] = st;
		return stst;
 	}
 	
 	
 	
 	
}
