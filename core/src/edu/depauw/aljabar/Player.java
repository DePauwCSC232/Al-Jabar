package edu.depauw.aljabar;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class Player {
	public int[] count = new int[8];
	
	public List<Button> selected = new ArrayList<Button>();

	public void handle(Button button, int oldColor) {
		if (selected.contains(button)) {
			selected.remove(button);
			button.setStyle(AlJabarGame.bStyles[oldColor]);
		} else {
			if (selected.size() < 3 || isSpectrum(button)) {
				selected.add(button);
			} else {
				button.setChecked(false);
			}
		}
		
		int color = 0;
		for (Button b : selected) {
			color = color ^ getColor(b);
		}
		
		for (Button b : selected) {
			b.setStyle(AlJabarGame.bStyles[color]);
		}
	}

	private boolean isSpectrum(Button button) {
		int[] count = new int[8];
		
		count[getColor(button)] = 1;
		for (Button b : selected) {
			count[getColor(b)] = 1;
		}
		
		return count[4]*count[2]*count[1]*count[7] == 1;
	}
	
	private int getColor(Button b) {
		PlayerColor pc = (PlayerColor) b.getUserObject();
		return pc.color;
	}
}
