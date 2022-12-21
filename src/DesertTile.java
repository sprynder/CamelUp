public class DesertTile {
	// instance variables
	private boolean isOasis;
	private String playerName;
	private int position;
	private boolean used;

	// constructor
	public DesertTile(boolean x, boolean u, String player, int pos) {
		isOasis = x;
		playerName = player;
		position = pos;
		used = u;
	}

	// methods
	public void setPluMin(boolean b) {
		isOasis = b;
	}

	public boolean isOasis() {
		return isOasis;
	}

	public void setOasis(boolean isOasis) {
		this.isOasis = isOasis;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public boolean getValue() {
		return isOasis;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setUsed(boolean u) {
		used = u;
	}

	public boolean getUsed() {
		return used;
	}

	public int getPosition() {
		return position;
	}
}
