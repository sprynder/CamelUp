
import java.util.Scanner;

public class TextRunner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GameState race = new GameState();
		race.setBoard();
		
		while (race.checkWinner() != true) {
			System.out.println(race.getPlayers()[race.getTurn() % 5].getName());
			int c = sc.nextInt();
			boolean plumin = sc.nextBoolean();
			boolean win = sc.nextBoolean();
			sc.nextLine();
			String col = sc.nextLine();
			int tile = sc.nextInt();
			// System.out.println(race.getPlayers()[race.getTurn()%5].getMyTile().getUsed());
			race.turn(c, plumin, win, col, tile);
			// System.out.println(race.getPlayers()[race.getTurn()%5].getMyTile().getUsed());
			// System.out.println(race.getPlayers()[(race.getTurn()-1)%5].getName()+
			// " "+ race.getPlayers()[(race.getTurn()-1)%5].getMoney());
			// System.out.println(race.getPlayers()[(race.getTurn()-1)%5].getName()
			// + " "+ race.getPlayers()[(race.getTurn()-1)%5].betsLeft());
			// System.out.println(race.getPlayers()[(race.getTurn()-1)%5].getName()
			// + " "+ race.getWinners());
			// System.out.println(race.getPlayers()[(race.getTurn()-1)%5].getName()
			// + " "+ race.getLosers());
			for (int i = 0; i < 18; i++) {
				System.out.println(i + " " + race.getTrack().getTiles()[i].getCamels());
				if (race.getTrack().getTiles()[i].hasDesertTile() == true){
					System.out.println(race.getTrack().getTiles()[i].getMyTile().getValue());
				System.out.println(race.getTrack().getTiles()[i].getMyTile().getPlayerName());
			}
			}
		}
		System.out.println(race.endGame().getName());
		for(Camel c: race.returnPlaces())	
			System.out.println(c.getColor());
		for(int i =0; i<5;i++)
	{
		System.out.println(race.getPlayers()[i].getName()+ " "+race.getPlayers()[i].getMoney());
	}
	}

}
