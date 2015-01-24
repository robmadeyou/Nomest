package com.gmail.robmadeyou;

import com.abereth.draw.Color;
import com.abereth.draw.shapes.Square;
import com.abereth.game.Game;
import com.abereth.game.View;
import com.abereth.gui.Text;
import com.abereth.input.Keyboard;
import com.abereth.input.Mouse;


/**
 * Created by exfos on 23/01/15.
 */
public class Nomest extends View
{
	public Nomest( Game game )
	{
		super( game );
	}

	public static void main( String[] args )
	{
		Game g = new Game( );
		g.addView( new Nomest( g ) );
		g.Start();
	}

	private Text text;

	@Override
	public void Initialize()
	{
		super.Initialize();
		text = new Text( "HQWASD QWDEASX&!4asd&!1asdwdqdQWDQWD", 50, 50 );
		text.setColor( Color.RED );
		Square s = new Square( 40, 40, 40, 40 );
		add( s );
		add( text );
		s.setLayer( 1 );
	}

	@Override
	public void update( int delta )
	{
		text.setDrawX( Mouse.getX() + 20 );
		text.setDrawY( Mouse.getY() );
	}
}