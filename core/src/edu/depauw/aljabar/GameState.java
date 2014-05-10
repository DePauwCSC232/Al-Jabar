package edu.depauw.aljabar;

import java.util.Random;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class GameState {
	public GameState(int numPlayers) {
		this.numPlayers = numPlayers;
		
		bag = new Player();
		for (int i = 1; i < 8; i++) {
			bag.count[i] = 10;
		}
		
		player = new Player[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			player[i] = new Player();
			for (int j = 0; j < 13; j++) {
				player[i].count[draw()]++;
			}
		}
		
		center = new Player();
		center.count[draw()] = 1;
		center.count[0] = 1;
		
		finalRound = false;
		currentPlayer = 0;
	}
	
	public int numPlayers;
	public Player[] player;
	public Player bag;
	public Player center;
	public boolean finalRound;
	public int currentPlayer;
	private Random rand = new Random();
	
	public int draw() {
		// TODO can we ever exhaust the bag?
		int total = 0;
		for (int c : bag.count) {
			total += c;
		}
		
		int choice = rand.nextInt(total);
		for (int i = 1; i < 8; i++) {
			int c = bag.count[i];
			if (choice < c) {
				bag.count[i]--;
				return i;
			} else {
				choice -= c;
			}
		}
		
		return 0; // never get here
	}
	
	public void nextPlayer() {
		int total = 0;
		for (int c : player[currentPlayer].count) {
			total += c;
		}
		
		if (total == 1) {
			AlJabarGame.lastButton.getClickListener().clicked(null, 0, 0);
		}
		
		disable(currentPlayer);
		currentPlayer++;
		if (currentPlayer == numPlayers) {
			currentPlayer = 0;
			if (finalRound) {
				// TODO game over
			}
		}
		enable(currentPlayer);
		
		for (int c : player[currentPlayer].count) {
			total += c;
		}
		
		if (total <= 3) {
			AlJabarGame.lastButton.setVisible(true);
		}
	}
	
	private void disable(int p) {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 10; col++) {
				Button b = player[p].button[row][col];
				b.setChecked(false);
				b.setVisible(col < player[p].count[row]);
				b.setDisabled(true);
			}
		}
		AlJabarGame.player[p].setBackground((Drawable) null);
	}
	
	private void enable(int p) {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 10; col++) {
				Button b = player[p].button[row][col];
				b.setChecked(false);
				b.setDisabled(false);
			}
		}
		AlJabarGame.player[p].setBackground(AlJabarGame.highlight);
	}
}
