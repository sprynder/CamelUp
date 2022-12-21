import java.util.ArrayList;

public class Tile {
	// instance variables
	DesertTile myTile;
	ArrayList<Camel> camels;

	public Tile() {
		camels = new ArrayList<Camel>();
		myTile = null;
	}

	public DesertTile getMyTile() {
		return myTile;
	}

	public void setMyTile(DesertTile myTile) {
		this.myTile = myTile;
	}

	public void setCamels(ArrayList<Camel> camels) {
		this.camels = camels;
	}

	public void setTile(DesertTile tile) {
		myTile = tile;
	}

	public boolean hasDesertTile() {
		if (myTile != null) {
			return true;
		} else {
			return false;
		}
	}

	public void removeTile() {
		myTile.setUsed(false);
		myTile.setPosition(-1);
		myTile = null;
	}

	public ArrayList removeCamels(String color) {
		int pos = 0;
		for (int i = 0; i < camels.size(); i++) {
			if (camels.get(i).getColor().equals(color)) {
				pos = i;
			}
		}
		ArrayList<Camel> subList = new ArrayList<Camel>(camels.subList(pos, camels.size()));
		camels.removeAll(subList);
		return subList;
	}

	public ArrayList<Camel> getCamels() {
		return camels;
	}
}
