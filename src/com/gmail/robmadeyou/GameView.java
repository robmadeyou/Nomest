package com.gmail.robmadeyou;

import com.abereth.game.Game;

/**
 * Created by exfos on 28/01/15.
 */
public class GameView extends TextScrollView
{
	public GameView( Game game )
	{
		super( game );
	}

	@Override
	public void initialize() {
		super.initialize();

		writeCenteredText( "Looks like you've had  the misfortune to venture here... Let's get along with it then, shall we?" );
	}
}
