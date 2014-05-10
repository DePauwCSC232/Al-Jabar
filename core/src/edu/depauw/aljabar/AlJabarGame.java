package edu.depauw.aljabar;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class AlJabarGame extends ApplicationAdapter {
	private Stage stage;

	public void create () {
		Skin rbySkin = new Skin();
		rbySkin.add("playUp", new Texture("play.png"));
		rbySkin.add("playDn", new Texture("play.png"));
		rbySkin.add("playCk", new Texture("play.png"));

		rbySkin.add("passUp", new Texture("pass.png"));
		rbySkin.add("passDn", new Texture("pass.png"));
		rbySkin.add("passCk", new Texture("pass.png"));

		rbySkin.add("drawUp", new Texture("draw.png"));
		rbySkin.add("drawDn", new Texture("draw.png"));
		rbySkin.add("drawCk", new Texture("draw.png"));

		rbySkin.add("finalUp", new Texture("final.png"));
		rbySkin.add("finalDn", new Texture("final.png"));
		rbySkin.add("finalCk", new Texture("finalUnselect.png"));

	    stage = new Stage(new StretchViewport(300, 200));
	    Gdx.input.setInputProcessor(stage);

	    Table table = new Table();
	    table.setFillParent(true);
	    stage.addActor(table);

	    Table leftUp = new Table();
	    Table leftMid = new Table();
	    Table leftDown = new Table();
	    Table left = new Table();
	    
	    Table center = new Table();
	    
	    Table rightUp = new Table();
	    Table rightMid = new Table();
	    Table rightDown = new Table();
	    Table right = new Table();
	    
	    ButtonStyle playStyle = new ButtonStyle(rbySkin.getDrawable("playUp"), rbySkin.getDrawable("playDn"), rbySkin.getDrawable("playCk"));
	    Button playButton = new Button(playStyle);
	    
	    ButtonStyle passStyle = new ButtonStyle(rbySkin.getDrawable("passUp"), rbySkin.getDrawable("passDn"), rbySkin.getDrawable("passCk"));
	    Button passButton = new Button(passStyle);
	    
	    leftMid.add(playButton).width(50).height(50);
	    leftMid.add(passButton).width(50).height(50);
	    
	    left.add(leftUp); left.row();
	    left.add(leftMid); left.row();
	    left.add(leftDown);
	    
	    ButtonStyle drawStyle = new ButtonStyle(rbySkin.getDrawable("drawUp"), rbySkin.getDrawable("drawDn"), rbySkin.getDrawable("drawCk"));
	    Button drawButton = new Button(drawStyle);
	    
	    ButtonStyle finalStyle = new ButtonStyle(rbySkin.getDrawable("finalUp"), rbySkin.getDrawable("finalDn"), rbySkin.getDrawable("finalCk"));
	    Button finalButton = new Button(finalStyle);
	    
	    rightMid.add(drawButton).width(50).height(50);
	    rightMid.add(finalButton).width(50).height(50);
	    
	    right.add(rightUp); right.row();
	    right.add(rightMid); right.row();
	    right.add(rightDown);
	    
	    table.add(left).width(100);
	    table.add(center).width(100);
	    table.add(right).width(100);
	    
	    table.debug();
	}

	public void resize (int width, int height) {
	    stage.getViewport().update(width, height, true);
	}

	public void render () {
		Gdx.gl.glClearColor(0.6f, 0.6f, 0.6f, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    stage.act(Gdx.graphics.getDeltaTime());
	    stage.draw();

	    Table.drawDebug(stage); // This is optional, but enables debug lines for tables.
	}

	public void dispose() {
	    stage.dispose();
	}}
