package com.gmail.robmadeyou;

import com.abereth.event.view.ViewKeyPressEvent;
import com.abereth.event.view.transitions.FadeTransition;
import com.abereth.game.Game;
import com.abereth.game.View;
import com.abereth.input.Keyboard;

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
	public void initialize()
	{
		super.initialize();
		writeCenteredText( "Hello" );
		writeCenteredText( "I hope you're ready, we have a long adventure ahead of us..." );
		scrollUp(200, getLineAmount() / 2).onComplete( ( TextScrollView object ) ->
		{
			writeCenteredText( "Press space to continue..." );
			getEventManager().add(new ViewKeyPressEvent( Keyboard.Key.Space ) {
				@Override
				public void onKeyPress( View game, Keyboard.Key key ) {
					object.getGame().ChangeView( new GameView( object.getGame() ), new FadeTransition( 10000 ) );
				}
			}, false );
		} );
	}
}
