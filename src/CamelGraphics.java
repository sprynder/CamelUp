import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class CamelGraphics {
	private int x, y;
	private int xOff, yOff;
	private int RADIUS;

	public CamelGraphics() {
	}

	public void paint(Graphics g, ArrayList<Camel> camels, int tile) {
		for (int i = 0; i < camels.size(); i++) {
			getOffSet(i);
			findCoordinate(tile);
			g.setColor(findColor(camels.get(i).getColor()));
			g.fillOval(x + xOff, y + yOff, RADIUS, RADIUS);
			g.setColor(Color.black);
			g.drawOval(x + xOff, y + yOff, RADIUS, RADIUS);
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

	public void getOffSet(int a) {
		if (a == 0) {
			xOff = 15;
			yOff = 15;
			RADIUS = 75 * 2;
		} else if (a == 1) {
			xOff = 30;
			yOff = 30;
			RADIUS = 60 * 2;
		} else if (a == 2) {
			xOff = 45;
			yOff = 45;
			RADIUS = 45 * 2;
		} else if (a == 3) {
			xOff = 60;
			yOff = 60;
			RADIUS = 30 * 2;
		} else if (a == 4) {
			xOff = 75;
			yOff = 75;
			RADIUS = 15 * 2;
		} else if (a == 5) {
			xOff = 90;
			yOff = 90;
			RADIUS = 5 * 2;
		}
	}

	public Color findColor(String a) {
		if (a.equals("Blue"))
			return Color.BLUE;
		if (a.equals("White"))
			return Color.WHITE;
		if (a.equals("Green"))
			return Color.GREEN;
		if (a.equals("Yellow"))
			return Color.YELLOW;
		if (a.equals("Orange"))
			return Color.ORANGE;
		return Color.BLACK;
	}
}