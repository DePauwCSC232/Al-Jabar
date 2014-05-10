package edu.depauw.aljabar;

import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class Util {

	public static int getColor(Button b) {
		PlayerColor pc = (PlayerColor) b.getUserObject();
		return pc.color;
	}

}
