
public class JudgeFeature {
	//特性の種類
	public static int man    = 1 << 0; //00000001
    public static int woman   = 1 << 1; //00000010
    public static int coll = 1 << 2; //00000100
    public static int cute   = 1 << 3; //00001000
    public static int serious   = 1 << 4; //00010000
    public static int curious  = 1 << 5; //00100000
    public static int sociable  = 1 << 6; //01000000
    public static int GentleNatured  = 1 << 7; //10000000
    
    public JudgeFeature() {
    	
    }
    public int judge2(int human, int thing) {//特性がどのくらい一致しているか
    	int count =0;
    	for (int i = 0; i < 8; i++) {
    	    if (((human >> i) & 1) == 1 && ((thing >> i) & 1) == 1) {
    	        count++;
    	    }
    	}
    	return count;
    }
    
}
