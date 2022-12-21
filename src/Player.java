import java.util.ArrayList;

public class Player {
	// instance variables
	private ArrayList<FinalBet> FinalBets;
	private ArrayList<Bets> roundBets;
	private int money;
	private DesertTile myTile;
	private String name;
	private int counter;
	private int place;
	public ArrayList<FinalBet> getFinalBets() {
		return FinalBets;
	}

	public void setFinalBets(ArrayList<FinalBet> finalBets) {
		FinalBets = finalBets;
	}

	public ArrayList<Bets> getRoundBets() {
		return roundBets;
	}

	public void setRoundBets(ArrayList<Bets> roundBets) {
		this.roundBets = roundBets;
	}
	public void addRoundBets(Bets bet) {
		roundBets.add(bet);
	}

	public DesertTile getMyTile() {
		return myTile;
	}

	public void setMyTile(DesertTile myTile) {
		this.myTile = myTile;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	// constructor
	public Player(String n) {
		name = n;
		FinalBets = new ArrayList<FinalBet>();
		FinalBets.add(new FinalBet(n, "Orange"));
		FinalBets.add(new FinalBet(n, "White"));
		FinalBets.add(new FinalBet(n, "Green"));
		FinalBets.add(new FinalBet(n, "Blue"));
		FinalBets.add(new FinalBet(n, "Yellow"));
		money = 3;
		roundBets = new ArrayList<Bets>();
		myTile = new DesertTile(true, false, name, -1);
		counter=0;
	}
	public FinalBet getColorBet(String str)
	{
		for(FinalBet b: FinalBets)
		{
			if(b.getCamelBetOn().equals(str))
				return b;
		}
		return null;
	}
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	// methods
	public FinalBet bet(String color) {
		for (int i = 0; i < FinalBets.size(); i++)
			if (FinalBets.get(i).getCamelBetOn().equals(color))
				return FinalBets.remove(i);
		return null;
	}

	public ArrayList<FinalBet> betsLeft() {
		return FinalBets;
	}

	public int getMoney() {
		return money;
	}

	public DesertTile placeTile(Boolean plumin, int n) {
		myTile.setPluMin(plumin);
		myTile.setUsed(true);
		myTile.setPosition(n);
		return myTile;
	}

	public void resetBets() {
		roundBets.clear();
	}

	public void addMoney(int mon) {
		money += mon;
		if(money < 0)
			money = 0;
	}

	public ArrayList<Bets> getBets() {
		return roundBets;
	}

	public String getName() {
		return name;
	}
}
