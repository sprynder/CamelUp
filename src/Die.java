public class Die {	
	private String color;
	private boolean rolled;
	private int rollValue;
	public Die(String c) {
		color = c;
		rollValue= 1;
	}
	public int roll() { 
		rollValue = (int)(Math.random()*3)+1;
		setRolled(true);
		return rollValue;
	}
	public boolean isRolled() {
		return rolled;
	}
	public void setRolled(boolean b){
		rolled  = b;
	}
	public String getColor() {
		return color;
	}
	public int getRollValue() {
		return rollValue;
	}
}

