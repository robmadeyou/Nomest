package com.gmail.robmadeyou;


import com.abereth.game.Game;

/**
 * Created by exfos on 23/01/15.
 */
public class Nomest
{

	public static int LETTER_SIZE = 12;

	public static void main( String[] args )
	{
		Game g = new Game( 1000, 1000 );
		g.addView( new WelcomeView( g ) );
		g.Start();
	}
}