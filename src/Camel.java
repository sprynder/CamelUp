public class Camel {
	public Die getDice() {
		return dice;
	}

	public void setDice(Die dice) {
		this.dice = dice;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setPos(int position) {
		this.pos = position;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	// instance variables
	private String color;
	private int pos;
	private int place;
	private Die dice;

	// constructor
	public Camel(String c) {
		dice = new Die(c);
		color = c;
		pos = 0;
		place = 1;
	}

	// methods
	public void move(int roll) {
		pos += roll;
	}

	public String getColor() {
		return color;
	}

	public int getPos() {
		return pos;
	}

	public int getPlace() {
		return place;
	}

	public Die getDie() {
		return dice;
	}
}
