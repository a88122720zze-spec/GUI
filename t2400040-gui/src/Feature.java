
public class Feature {
	private String featureName;//漢字
	private String featureHiragana;//平仮名
	private String featureRomaji;//ローマ字
	private int features;
	
	public Feature(String st1,String st2, String st3, int fe) {
		featureName =st1;
		featureHiragana =st2;
		featureRomaji =st3;
		features =fe;
	}
	public String getfN() {
		return featureName;
	}
	public String getfH() {
		return featureHiragana;
	}
	public String getfR() {
		return featureRomaji;
	}
	public int getfe() {
		return features;
	}
	
}
