import java.awt.Color;
import java.awt.Font;
//Team James
import java.awt.Graphics;

public class BetDrawer {
	 private int xOff, yOff, X, Y;
    public BetDrawer(){
    }

    public void paint(Graphics gr,GameState a){
    	for(int i =0; i <5;i++)
    	{
    		if(a.getRounds().get(findColors(i)).peek() != null){
    		gr.setColor(findColor(i));
    		gr.fillRect(1025, 25+i*200, 80, 150);
    		gr.setColor(Color.BLACK);
    		gr.drawString(""+a.getRounds().get(findColors(i)).peek().getBetValue(),1025,50+i*200);
    		}
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
    public String findColors(int a) {
		if (a == 0)
			return "Blue";
		if (a ==1)
			return "Orange";
		if (a == 2)
			return "Green";
		if (a ==3)
			return "White";
		if (a==4)
			return "Yellow";
		return null;
	}
}

