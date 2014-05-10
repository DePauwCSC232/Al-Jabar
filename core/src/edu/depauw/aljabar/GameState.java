package edu.depauw.aljabar;

public class GameState {
	public GameState(int numPlayers) {
		player = new Player[numPlayers];
		bag = new Player();
		center = new Center();
		finalRound = false;
	}
	
	public Player getPlayer(int i)
	{
		if (player[i] == null) {
			player[i] = new Player();
		}
		
		return player[i];
	}
	
	private Player[] player;
	private Player bag;
	private Center center;
	private boolean finalRound;
}
