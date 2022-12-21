import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PlayerGraphics {
    public PlayerGraphics(){

    }

    public void paint(Graphics gr,GameState a){
    	gr.setFont(new Font("Arial", Font.BOLD, 25));
    	for(int i =0; i <5;i++)
    	{
    		gr.setColor(Color.lightGray);
    		if(a.getTurn()%5 == i)
    			gr.setColor(Color.DARK_GRAY);
    		gr.fillRect(1130, 25+i*200, 350, 150);
    		gr.setColor(Color.BLACK);
    		gr.drawString(a.getPlayers()[i].getName(), 1135, 50+i*200);
    		int n = 85+i*200;
    		for(int b =0;b<5;b++)
    		{
    			if(a.getPlayers()[i].betsLeft().contains(a.getPlayers()[i].getColorBet(findColors(b))))
    			{
    			gr.setColor(findColor(b));
    			gr.fillRect(1140+b*70,n, 50, 75);
    			gr.setColor(Color.black);
    			gr.drawRect(1140+b*70, n, 50, 75);
    			gr.drawLine(1140+b*70, n+75/2, 1190+b*70, n+75/2);
    			gr.drawString("W", 1143+b*70, n+32);
    			gr.drawString("L", 1143+b*70, n+62);
    			}
    			else
    			{
    		
    				gr.setColor(Color.gray);
        			gr.fillRect(1140+b*70,n, 50, 75);
        			gr.setColor(Color.black);
        			gr.drawRect(1140+b*70, n, 50, 75);
    			}
    				
    		}
    		for(int b =0; b <a.getPlayers()[i].getRoundBets().size();b++)
    		{
    			
    			gr.setColor(findColor(a.convertToNumber(a.getPlayers()[i].getRoundBets().get(b).getCamelBetOn())));
    			if(b <5 )
    			{
    			gr.fillRect(1500+b*65, 25+i*200, 50, 70);
    			gr.setColor(Color.black);
    			gr.drawString(""+a.getPlayers()[i].getRoundBets().get(b).getBetValue(), 1500+b*65, 50+i*200);
    			}
    			else if(b >=5 && b<10)
    			{
    				int m =b-5;
    			gr.fillRect(1525+m*65,65 +i*200, 50, 70);
    			gr.setColor(Color.black);
    			gr.drawString(""+a.getPlayers()[i].getRoundBets().get(b).getBetValue(), 1525+m*65, 90+i*200);
    			}
    			else
    			{
    				int m = b-10;
    			gr.fillRect(1500+m*65, 105+i*200, 50, 70);
    			gr.setColor(Color.black);
    			gr.drawString(""+a.getPlayers()[i].getRoundBets().get(b).getBetValue(), 1500+m*65, 130+i*200);
    			}
    		}
    	}
    	Player[] temp = a.getPlayers();
    	for(int i = 0;i <5;i++)
    	{
    		gr.setColor(Color.getHSBColor(30, 93, 28));
    		gr.fillRect(1260, 30+200*i, 25, 50);
    		gr.setColor(Color.getHSBColor(345,67,22));
    		int[] xPoints = {1262,1272,1282};
    		int[] yPoints = {60+200*i,40+200*i,60+200*i};
    		gr.fillPolygon(xPoints,yPoints,3);
    		gr.drawString("X" + temp[i].getCounter(), 1295, 60+200*i);
    		gr.setColor(Color.GRAY);
    		gr.fillOval(1360, 30+200*i, 50, 50);
    		gr.setColor(Color.BLACK);
    		gr.drawString("" + temp[i].getMoney(), 1380, 65+i*200);
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

