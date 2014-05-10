package edu.depauw.aljabar;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class Player {
	public int[] count = new int[8];
	public Button[][] button = new Button[8][10];

	public List<Button> selected = new ArrayList<Button>();

	public void handle(Button button, int oldColor, GameState state) {
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
			color = color ^ Util.getColor(b);
		}

		for (Button b : selected) {
			b.setStyle(AlJabarGame.bStyles[color]);
		}

		Player p = state.player[state.currentPlayer];
		if (!p.selected.isEmpty()
				&& !state.center.selected.isEmpty()
				&& p.selected.get(0).getStyle() == state.center.selected.get(0).getStyle()) {
			AlJabarGame.playButton.setVisible(true);
		} else {
			AlJabarGame.playButton.setVisible(false);
		}
	}

	private boolean isSpectrum(Button button) {
		int[] count = new int[8];

		count[Util.getColor(button)] = 1;
		for (Button b : selected) {
			count[Util.getColor(b)] = 1;
		}

		return count[4] * count[2] * count[1] * count[7] == 1;
	}
}
