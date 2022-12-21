public class Bets {
	// instance variables
	private int betValue;
	private String camelBetOn;

	public Bets(String camel, int bet) {
		betValue = bet;
		camelBetOn = camel;
	}

	public Bets(String camel) {
		betValue = 1;
		camelBetOn = camel;
	}

	public int getBetValue() {
		return betValue;
	}

	public String getCamelBetOn() {
		return camelBetOn;
	}
}
