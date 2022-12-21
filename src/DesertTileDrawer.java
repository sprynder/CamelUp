import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class DesertTileDrawer {
	private int x, y;
	private int xOff, yOff;

	public DesertTileDrawer() {
	}

	public void paint(Graphics g, GameState a) {
		for (int i = 1; i < 18; i++) {
			if (a.getTrack().emptyTile(i)) {
				findCoordinate(i);
				g.setColor(Color.getHSBColor(52, 30, 40));
				g.fillRect(x, y + 160, 180, 20);
				Font myFont = new Font("Serif", Font.BOLD, 20);
				g.setFont(myFont);
				g.setColor(Color.black);
				g.drawString("           +             -", x, y + 178);
				g.drawRect(x, y + 160, 180, 20);
			}
			if (a.getTrack().getTiles()[i].hasDesertTile()) {
				findCoordinate(i);
				g.setFont(new Font("Arial", Font.BOLD, 25));
				if (a.getTrack().getTiles()[i].getMyTile().getValue() == true) {
					g.setColor(Color.getHSBColor(36, 68, 66));
					g.fillRect(x, y, 180, 180);
					g.setColor(Color.black);
					g.drawString(""+a.getTrack().getTiles()[i].getMyTile().getPlayerName()+ " (+)",x+40 ,y+25);
				} else {
					g.setColor(Color.getHSBColor(194, 68, 90));
					g.fillRect(x, y, 180, 180);
					g.setColor(Color.black);
					g.drawString(""+a.getTrack().getTiles()[i].getMyTile().getPlayerName()+ " (-)",x+40 ,y+25);
				}
			}
		}
	}

	public void findCoordinate(int pos) {
		if (pos <= 3) {
			x = 740;
			y = 380 + (pos - 1) * 180;
		}
		if (pos <= 7 && pos > 3) {
			pos = Math.abs(pos - 3);
			x = 740 - (pos) * 180;
			y = 740;
		}
		if (pos <= 11 && pos > 7) {
			pos = Math.abs(pos - 7);
			x = 20;
			y = 740 - (pos) * 180;
		}
		if (pos <= 15 && pos > 11) {
			pos = Math.abs(pos - 11);
			x = 20 + pos * 180;
			y = 20;

		}
		if (pos <= 17 && pos > 15) {
			pos = Math.abs(pos - 15);
			x = 740;
			y = 20 + pos * 180;
		}
	}
}