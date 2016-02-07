package com.gmail.robmadeyou;

import com.abereth.game.Game;
import com.abereth.game.View;
import com.abereth.objects.living.PhysicalBox;

/**
 * Created by exfos on 28/01/15.
 */
public class GameView extends View
{
	public GameView( Game game )
	{
		super( game );
	}

	@Override
	public void initialize() {
		PhysicalBox box = new PhysicalBox( 20, 50, 50, 50 );
		add( box );
	}

	@Override
	public void update(int delta) {

	}
}
