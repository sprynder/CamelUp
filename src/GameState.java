import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GameState {
	private Queue<FinalBet> winners;
	private Queue<FinalBet> losers;
	private Player[] players;
	private Camel[] camels;
	private Track track;
	private int turn;
	private HashMap<String, Queue<Bets>> rounds;
	private ArrayList<Camel> places;
	private Player[] pplaces;

	public GameState() {
		winners = new <FinalBet>LinkedList();
		losers = new <FinalBet>LinkedList();
		players = new Player[5];
		players[0] = new Player("Player 1");
		players[1] = new Player("Player 2");
		players[2] = new Player("Player 3");
		players[3] = new Player("Player 4");
		players[4] = new Player("Player 5");
		camels = new Camel[5];
		camels[0] = new Camel("Blue");
		camels[1] = new Camel("Orange");
		camels[2] = new Camel("Green");
		camels[3] = new Camel("White");
		camels[4] = new Camel("Yellow");
		track = new Track();
		turn = 0;
		rounds = new HashMap<String, Queue<Bets>>();
		rounds.put("Blue", new LinkedList<Bets>());
		rounds.put("Orange", new LinkedList<Bets>());
		rounds.put("Green", new LinkedList<Bets>());
		rounds.put("White", new LinkedList<Bets>());
		rounds.put("Yellow", new LinkedList<Bets>());
		resetBets();
		pplaces = new Player[5];
		for (int i = 0; i < 5; i++) {
			pplaces[i] = players[i];
		}
	}

	public void sortPlayers() {
		for (int i = 0; i < 5; i++) {
			int min_idx = i;
			for (int j = i + 1; j < 5; j++)
				if (pplaces[j].getMoney() > pplaces[min_idx].getMoney())
					min_idx = j;
			Player temp = pplaces[i];
			pplaces[i] = pplaces[min_idx];
			pplaces[min_idx] = temp;

		}
	}

	public String convertToColor(int a) {
		if (a == 0)
			return "Blue";
		if (a == 1)
			return "Orange";
		if (a == 2)
			return "Green";
		if (a == 3)
			return "White";
		if (a == 4)
			return "Yellow";
		return null;

	}

	public String convertToName(int a) {
		if (a == 0)
			return "Player 1";
		if (a == 1)
			return "Player 2";
		if (a == 2)
			return "Player 3";
		if (a == 3)
			return "Player 4";
		if (a == 4)
			return "Player 5";
		return null;

	}

	public int convertToNumber(String col) {
		if (col.equalsIgnoreCase("Blue"))
			return 0;
		if (col.equalsIgnoreCase("Orange"))
			return 1;
		if (col.equalsIgnoreCase("Green"))
			return 2;
		if (col.equalsIgnoreCase("White"))
			return 3;
		if (col.equalsIgnoreCase("Yellow"))
			return 4;
		return -1;
	}

	public int convertToNumbers(String col) {
		if (col.equalsIgnoreCase("Player 1"))
			return 0;
		if (col.equalsIgnoreCase("Player 2"))
			return 1;
		if (col.equalsIgnoreCase("Player 3"))
			return 2;
		if (col.equalsIgnoreCase("Player 4"))
			return 3;
		if (col.equalsIgnoreCase("Player 5"))
			return 4;
		return -1;
	}

	public void getPlaces() {
		places = new ArrayList<Camel>();
		for (int i = 0; i < 5; i++) {
			places.add(camels[i]);
		}
		for (int i = 0; i < 5; i++) {
			Camel max = places.get(i);

			for (int j = i + 1; j < 5; j++)
				if (max.getPos() < places.get(j).getPos()) {
					max = places.get(j);
				} else if (max.getPos() > places.get(j).getPos()) {

				} else {
					if (track.getTiles()[max.getPos()].getCamels().indexOf(
							max) < track.getTiles()[places.get(j).getPos()].getCamels().indexOf(places.get(j))) {
						max = places.get(j);
					}
				}
			Camel temp = max;
			places.remove(max);
			places.add(i, temp);

		}
		for (int i = 0; i < 5; i++) {
			camels[i].setPlace(places.indexOf(camels[i]) + 1);
		}
	}

	public void leg(int b) {
		getPlaces();
		if (b != 1)
			resetBoard();
		for (int i = 0; i < 5; i++) {
			for (int a = 0; a < players[i].getRoundBets().size(); a++) {
				if (players[i].getRoundBets().get(a).getCamelBetOn().equalsIgnoreCase(places.get(0).getColor())) {
					players[i].addMoney(players[i].getRoundBets().get(a).getBetValue());
				} else if (players[i].getRoundBets().get(a).getCamelBetOn()
						.equalsIgnoreCase(places.get(1).getColor())) {
					players[i].addMoney(1);
				} else
					players[i].addMoney(-1);
			}
		}
		if (b == 2)
			for (int i = 0; i < 5; i++) {
				players[i].addMoney(players[i].getCounter());
				players[i].setCounter(0);
			}
		resetBets();
	}

	public Player endGame() {
		leg(2);
		getPlaces();
		Camel winner = places.get(0);
		Camel loser = places.get(places.size() - 1);
		int mon = 8;
		int wins = 0;
		int mont = 8;
		int los = 0;
		while (!winners.isEmpty()) {
			if (winners.peek().getCamelBetOn().equals(winner.getColor())) {
				mon = 8;
				if (wins == 1)
					mon = 5;
				if (wins == 2)
					mon = 3;
				if (wins == 3)
					mon = 2;
				if (wins > 3)
					mon = 1;
				wins++;
				players[convertToNumbers(winners.peek().getPlayerBet())].addMoney(mon);
			} else if (!winners.peek().getCamelBetOn().equals(winner.getColor())) {
				players[convertToNumbers(winners.peek().getPlayerBet())].addMoney(-1);
			}
			winners.poll();
		}
		while (!losers.isEmpty()) {
			if (losers.peek().getCamelBetOn().equals(loser.getColor())) {
				mont = 8;
				if (los == 1)
					mont = 5;
				if (los == 2)
					mont = 3;
				if (los == 3)
					mont = 2;
				if (los > 3)
					mont = 1;
				los++;
				players[convertToNumbers(losers.peek().getPlayerBet())].addMoney(mont);
			} else if (!losers.peek().getCamelBetOn().equals(loser.getColor())) {
				players[convertToNumbers(losers.peek().getPlayerBet())].addMoney(-1);
			}
			losers.poll();
		}
		Player winer = new Player("blah");
		winer.addMoney(Integer.MIN_VALUE);
		for (int i = 0; i < 5; i++) {
			if (players[i].getMoney() > winer.getMoney())
				winer = players[i];
		}
		return winer;
	}
	public Bets getRoundBets(String col) {

		return rounds.get(col).poll();

	}

	public boolean checkDie() {
		int a = 0;
		for (int i = 0; i < 5; i++) {
			if (camels[i].getDice().isRolled() == true) {
				a++;
			}
		}
		if (a % 5 == 0 && a != 0) {
			leg(2);
			return true;
		}
		return false;
	}

	public void resetDie() {
		for (int i = 0; i < 5; i++) {
			camels[i].getDice().setRolled(false);
		}
		leg(2);
	}

	public String chooseCamel() {
		int choice = (int) (Math.random() * 5);
		if (camels[choice].getDice().isRolled())
			while (camels[choice].getDice().isRolled())
				choice = (int) (Math.random() * 5);
		return camels[choice].getColor();
	}

	public Queue<FinalBet> getWinners() {
		return winners;
	}

	public void setWinners(Queue<FinalBet> winners) {
		this.winners = winners;
	}

	public Queue<FinalBet> getLosers() {
		return losers;
	}

	public void setLosers(Queue<FinalBet> losers) {
		this.losers = losers;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public Camel[] getCamels() {
		return camels;
	}

	public void setCamels(Camel[] camels) {
		this.camels = camels;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public HashMap<String, Queue<Bets>> getRounds() {
		return rounds;
	}

	public ArrayList<Camel> returnPlaces() {
		return places;
	}

	public void setRounds(HashMap<String, Queue<Bets>> rounds) {
		this.rounds = rounds;
	}

	public void setPlaces(ArrayList<Camel> places) {
		this.places = places;
	}

	public void moveCamel(Camel play, int roll) {
		int offset = 0;
		ArrayList<Camel> subList = track.getTiles()[play.getPos()].removeCamels(play.getColor());
		if ((play.getPos() + roll <= 16) && track.getTiles()[play.getPos() + roll].hasDesertTile())
			if (track.getTiles()[play.getPos() + roll].getMyTile().getValue() == true) {
		
				offset = 1;
				players[convertToNumbers(track.getTiles()[play.getPos() + roll].getMyTile().getPlayerName())]
						.addMoney(1);
			} else if (track.getTiles()[play.getPos() + roll].getMyTile().getValue() == false) {
			
				offset = -1;
				players[convertToNumbers(track.getTiles()[play.getPos() + roll].getMyTile().getPlayerName())]
						.addMoney(1);
			}
		int val = play.getPos() + roll + offset;
		if (val > 16)
			val = 17;
		if (offset == 1)
			track.getTiles()[val].getCamels().addAll(subList);
		else if (offset == -1) {
			ArrayList<Camel> temp = track.getTiles()[play.getPos() + roll + offset].getCamels();
			subList.addAll(temp);
			track.getTiles()[val].setCamels(subList);
		} else
			track.getTiles()[val].getCamels().addAll(subList);
		for (Camel c : subList) {
			c.setPos(val);
		}
		if (checkWinner()) {
			getPlaces();
			leg(1);
			endGame();
		}
	}

	public boolean checkWinner() {
		for (int i = 0; i < 5; i++) {
			if (camels[i].getPos() > 16)
				return true;
		}
		return false;
	}

	public void setBoard() {
		for (int i = 0; i < 5; i++) {
			int roll = camels[i].getDice().roll();
			
			track.getTiles()[camels[i].getPos() + roll].getCamels().add(camels[i]);
			camels[i].setPos(camels[i].getPos() + roll);

		}
		checkDie();
		resetDie();
	}

	public Player[] getPplaces() {
		return pplaces;
	}

	public void setPplaces(Player[] pplaces) {
		this.pplaces = pplaces;
	}

	public void resetBoard() {
		for (int i = 0; i < 18; i++) {
			if (track.getTiles()[i].hasDesertTile())
				track.getTiles()[i].removeTile();
		}
	}

	public void resetBets() {
		for (int i = 0; i < 5; i++) {
			players[i].setRoundBets(new ArrayList<Bets>());
		}
		for (String key : rounds.keySet()) {
			Queue<Bets> blah = new LinkedList<Bets>();
			rounds.put(key, blah);
		}
		for (String key : rounds.keySet()) {
			rounds.get(key).offer(new Bets(key, 5));
			rounds.get(key).offer(new Bets(key, 3));
			rounds.get(key).offer(new Bets(key, 2));
		}
	}

	public void turn(int c, boolean plumin, boolean winner, String color, int tileNumber) {
		if (checkDie() == true) {
			resetDie();
		}
		int play = turn % 5;
		if (c == 1) {
			String col = chooseCamel();
			players[play].setCounter(players[play].getCounter() + 1);
			moveCamel(camels[convertToNumber(col)], camels[convertToNumber(col)].getDice().roll());
		}
		if (c == 2) {
			if (players[play].getColorBet(color) != null)
				if (winner == false)
					losers.offer(players[play].bet(color));
				else if (winner == true)
					winners.offer(players[play].bet(color));
				else {
					return;
				}
			else {
				return;
			}
		}
		if (c == 3) {
			if (track.emptyTile(tileNumber)) {
				if (players[play].getMyTile().getPosition() != -1)
					track.getTiles()[players[play].getMyTile().getPosition()].removeTile();
				track.getTiles()[tileNumber].setTile(players[play].placeTile(plumin, tileNumber));
			} else {
				return;
			}
		}
		if (c == 4) {
			Bets use = getRoundBets(color);
			if (use == null)
				return;
			players[play].addRoundBets(use);
		}
		turn++;
		checkDie();
		sortPlayers();
	}
}

