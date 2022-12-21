import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Panel extends JPanel implements MouseListener {
	private static final int WIDTH = 1900;
	private static final int HEIGHT = 985;
	private GameState race;
	private CamelGraphics camel;
	private DieGraphics b;
	private PlayerGraphics c;
	private DesertTileDrawer d;
	private BetDrawer e;
	int x, y;
	int xOff, yOff;

	public Panel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.getHSBColor(52, 30, 25));
		addMouseListener(this);
		race = new GameState();
		race.setBoard();
		camel = new CamelGraphics();
		b = new DieGraphics();
		c = new PlayerGraphics();
		d = new DesertTileDrawer();
		e = new BetDrawer();
	}

	public void paint(Graphics gr) {
		super.paint(gr);
		d.paint(gr, race);
		e.paint(gr, race);
		for (int i = 0; i < 5; i++) {
			if (race.getCamels()[i].getDie().isRolled() == true) {
				b.paint(gr, i);
				b.drawNumber(gr, race.getCamels()[i].getColor(), race.getCamels()[i].getDice().getRollValue(), i);
			}
		}
		gr.setColor(Color.BLACK);
		// track
		for (int i = 0; i < 5; i++) {
			gr.drawRect(20 + i * 180, 20, 180, 180);
		}
		for (int i = 0; i < 5; i++) {
			gr.drawRect(740, 20 + i * 180, 180, 180);

		}
		for (int i = 0; i < 5; i++) {
			gr.drawRect(740 - i * 180, 740, 180, 180);
		}
		for (int i = 0; i < 5; i++) {
			gr.drawRect(20, 740 - i * 180, 180, 180);
		}
		gr.fillRect(740, 380, 90, 20);
		gr.setColor(Color.WHITE);
		gr.fillRect(830, 380, 90, 20);
		gr.setColor(Color.BLACK);
		// pyramid
		gr.setColor(Color.getHSBColor(52, 100, 50));
		for (int i = 0; i < 4; i++) {
			gr.setColor(Color.getHSBColor(52, 100, 50 - i * 10));
			gr.fillRect(275 + i * 50, 275 + i * 50, 400 - i * 100, 400 - i * 100);
		}
		gr.setColor(Color.black);
		for (int i = 0; i < 4; i++) {
			gr.drawRect(275 + i * 50, 275 + i * 50, 400 - i * 100, 400 - i * 100);
		}
		gr.drawLine(275, 275, 425, 425);
		gr.drawLine(675, 675, 525, 525);
		gr.drawLine(675, 275, 525, 425);
		gr.drawLine(275, 675, 425, 525);
		gr.drawString(race.convertToName(race.getTurn() % 5), 425, 250);
		for (int i = 1; i < 18; i++) {
			camel.paint(gr, race.getTrack().getTiles()[i].getCamels(), i);
		}
		if (race.checkWinner()) {
			paintWinner(gr, race);
		}
		c.paint(gr, race);
	}

	public void paintWinner(Graphics g, GameState s) {
		g.setColor(Color.white);
		g.fillRect(275, 275, 400, 400);
		g.setColor(Color.BLACK);
		g.drawString("SCOREBOARD", 400, 325);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		int place = -1;
		int b = 0;
		int c = 1;
		for (int i = 0; i < 5; i++) {
			if (s.getPplaces()[i].getMoney() != place || i == 0) {
				if (i != 0)
					c++;
				g.drawString(c + ". " + s.getPplaces()[i].getName(), 290, 425 + (c-1)* 50);
				b = 0;
			} else {
				g.drawString("   , " + s.getPplaces()[i].getName(), 370 + 90 * b, 425 + (c - 1) * 50);
				b++;
			}
			place = s.getPplaces()[i].getMoney();
			if(b==4)
			{
				g.setColor(Color.white);
				g.fillRect(275, 275, 400, 400);
				g.setColor(Color.black);
				g.drawString("ALL PLAYERS TIE", 375, 325);
				break;
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		int t = e.getX();
		int u = e.getY();
		// System.out.println(t + " " + u);
		if (race.checkWinner() != true) {
			if (t > 275 && t < 675 && u > 275 && u < 675) {// &&!a.isWon())
				race.turn(1, true, true, "Blue", 5);
			}
			for (int i = 0; i < 18; i++) {
				findCoordinate(i);
				if (t > x && t < x + 90 && u > y + 160 && u < y + 180) {
					race.turn(3, true, true, "blue", i);
				}
				if (t > x + 90 && t < x + 180 && u > y + 160 && u < y + 180)
					race.turn(3, false, false, "blue", i);
			}
			for (int i = 0; i < 5; i++) {
				int n = 85 + i * 200;
				if (withinBounds(t, u)) {
					for (int b = 0; b < 5; b++) {
						if (t > 1140 + b * 70 && t < 1190 + b * 70 && u > n && u < n + 75 / 2) {
							if (b == 0)
								race.turn(2, true, true, "Blue", 1);
							else if (b == 1)
								race.turn(2, true, true, "Orange", 1);
							else if (b == 2)
								race.turn(2, true, true, "Green", 1);
							else if (b == 3)
								race.turn(2, true, true, "White", 1);
							else if (b == 4)
								race.turn(2, true, true, "Yellow", 1);
						} else if (t > 1140 + b * 70 && t < 1190 + b * 70 && u > n + 75 / 2 && u < n + 75) {
							if (b == 0)
								race.turn(2, false, false, "Blue", 1);
							else if (b == 1)
								race.turn(2, false, false, "Orange", 1);
							else if (b == 2)
								race.turn(2, false, false, "Green", 1);
							else if (b == 3)
								race.turn(2, false, false, "White", 1);
							else if (b == 4)
								race.turn(2, false, false, "Yellow", 1);
						}
					}
				}
			}
			for (int i = 0; i < 5; i++) {
				if (t > 1025 && t < 1025 + 80 && u > 25 + i * 200 && u < 25 + i * 200 + 180) {
					race.turn(4, true, true, race.convertToColor(i), 1);
				}
			}
		}
		repaint();
	}

	public boolean withinBounds(int x, int y) {
		int play = race.getTurn() % 5;
		int xb1 = 1130;
		int xb2 = 1480;
		int yb1, yb2;
		yb1 = 25 + play * 200;
		yb2 = yb1 + 150;
		if (x > xb1 && x < xb2 && y > yb1 && y < yb2)
			return true;
		return false;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
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