
public class Human {
	//URL image;
	private String name;
	private int feature;
	private int gage;
	private String featureThings;
	
	public Human() {
		name ="name1";
		feature =0b01000010;//2進数
		gage = 50;
		featureThings ="社会的、女性";
	}
//	public void judgegage() {
//		if()
//	}
	public void gageadd(int num) {
		gage += num*num;
	}
	public void gagelow() {
		gage -=10;
	}
	public int endcheck() {
		if(gage <=0) {//敗北の意味で終了
			return -1;
		}
		else if(gage >= 100) {//社会復帰で終了
			return 1;
		}
		
		return 0;//続ける
	}
	
	
	public String getname() {
		return name;
	}
	public int  getfeature() {
		return feature;
	}
	public int getgege() {
		return gage;
	}
	public String getfeatureThings() {
		return featureThings;
	}
}

//下部から
//#1 男
//#2 女
//#3 かっこいい
//#4 かわいい
//#5 真面目
//#6 好奇心旺盛
//#7 社交的
//#8 温厚
//
