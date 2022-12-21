public class FinalBet extends Bets {
//instance variables
	private String playerBet;

	// constructor
	public FinalBet(String player, String camel) {
		super(camel);
		playerBet = player;
	}

	// methods
	public String getPlayerBet() {
		return playerBet;
	}
	public boolean equals(Object o)
	{
		FinalBet a =(FinalBet)o;
		if(a.getBetValue()==getBetValue())
			if(a.getCamelBetOn().equals(getCamelBetOn()))
				if(a.getPlayerBet().equals(this.getPlayerBet()))
					return true;
		return false;
		
	}
}
