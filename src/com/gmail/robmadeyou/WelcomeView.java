package com.gmail.robmadeyou;

import com.abereth.game.Game;
import com.abereth.gui.text.Text;

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
		write( "Hello\nThis is your life now!AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", Text.PINK );
	}
}
