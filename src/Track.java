public class Track {

	private Tile[] Arr;

	public Track() {
		Arr = new Tile[18];
		for (int i = 0; i < Arr.length; i++) {
			Arr[i] = new Tile();
		}
	}

	public Tile[] getTiles() {
		return Arr;
	}

	public boolean emptyTile(int x) {
		if ( x!=1&&x+1< Arr.length&& x-1 > -1 && Arr[x].getCamels().size() == 0 && Arr[x-1].hasDesertTile() == false && x+1< Arr.length&& Arr[x+1].hasDesertTile() == false && Arr[x].hasDesertTile() == false)
			return true;
		return false;
	}
}