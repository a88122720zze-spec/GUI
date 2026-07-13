
public class Type {
	public static Model model;
	public static toJapanese jp;
	
	private
		String decided;
		String notdecided;
	public
		Type(Model model) {
			this.model =model;
			decided ="";
			notdecided ="";
			jp = new  toJapanese();
		}
	
		void addNotDecided(String st) {
			notdecided += st;
		}
		void reset() {
			this.decided ="";
			this.notdecided ="";
		}
		String getString() {
			return decided +notdecided;
		}
		void  judgeString() {
			String[] st =jp.translate(decided, notdecided);
			decided += st[0];
			notdecided =st[1];
			
		}
		String  typeRun(String st) {//普通１文字

				addNotDecided(st);
				judgeString();
			
			return getString();
		}
		
		
}
