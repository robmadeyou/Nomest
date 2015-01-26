package com.gmail.robmadeyou;

import com.abereth.game.Game;

/**
 * Created by exfos on 25/01/15.
 */
public class WelcomeView extends TextScrollView
{
	public WelcomeView( Game game )
	{
		super( game );
	}

	@Override
	public void Initialize()
	{
		super.Initialize();
		writeCenteredText( "Hello" );
		writeCenteredText( "I hope you're ready, we have a long adventure ahead of us..." );
	}
}
