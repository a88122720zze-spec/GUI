
public class Type {
	public static toJapanese jp;
	
	private
		
		String decided;
		String notdecided;
	public
		Type() {
			decided ="";
			notdecided ="";
		}
	
		void addNotDedided(String st) {
			notdecided += st;
		}
		void reset() {
			decided ="";
			notdecided ="";
		}
		String getString() {
			return decided +notdecided;
		}
		void  judgeString() {
			String[] st =jp.translate(decided, notdecided);
			decided += st[0];
			notdecided =st[1];
			
		}
		
		
}
