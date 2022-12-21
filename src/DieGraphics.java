import java.awt.*;

public class DieGraphics {

    private int xOff, yOff, X, Y;

    public DieGraphics(){
        X=950;
        Y=100;
        xOff=0;
        yOff=175;
    }

    public void paint(Graphics g, int i){
        g.setColor(findColor(i));
        getOffSet(i);
        g.fillRect(X+xOff,Y+yOff,50,50);
        g.setColor(Color.BLACK);
        g.drawRect(X+xOff,Y+yOff,50,50);
    }

    public void drawNumber(Graphics g, String color,int roll, int i){
        g.setFont(new Font("Arial", Font.BOLD, 25));
        getOffSet(i);
        g.setColor(Color.BLACK);
        switch (color) {
            case "Blue":
                g.drawString(roll + "", 967, 135);
                break;
            case "Green":
                g.drawString(roll + "", 967, 135+yOff);
                break;
            case "Orange":
                g.drawString(roll + "", 967,135+yOff);
                break;
            case "Yellow":
                g.drawString(roll + "", 967,135+yOff);
                break;
            case "White":
                g.drawString(roll + "", 967, 135+yOff);
                break;
        }
    }
    public Color findColor(int a) {
		if (a == 0)
			return Color.BLUE;
		if (a ==1)
			return Color.ORANGE;
		if (a == 2)
			return Color.GREEN;
		if (a ==3)
			return Color.WHITE;
		if (a==4)
			return Color.YELLOW;
		return Color.BLACK;
	}
    public void getOffSet(int a) {
		if (a == 0) {
			xOff = 0;
			yOff = 0;
			
		} else if (a == 1) {
			xOff = 0;
			yOff = 175;
	
		} else if (a == 2) {
			xOff = 0;
			yOff = 175*2;
			
		} else if (a == 3) {
			xOff = 0;
			yOff = 175*3;
			
		} else if (a == 4) {
			xOff = 0;
			yOff = 175*4;
			
		} else if (a == 5) {
			xOff = 0;
			yOff = 50;
		
		}
	}
}
