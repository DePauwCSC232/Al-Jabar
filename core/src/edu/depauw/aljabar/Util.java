package edu.depauw.aljabar;

import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class Util {

	public static int getColor(Button b) {
		PlayerColor pc = (PlayerColor) b.getUserObject();
		return pc.color;
	}

}

// Keep a to-do list here
// TODO add disabled button images; use disabled instead of invisible for controls
// TODO put colors in an array
// TODO swappable themes? Gems, paint drops, ...
// TODO refactor, refactor, refactor
// TODO animated dealing & playing?
// TODO put cancelled tokens into bag
// TODO bug with cancelling black tokens
