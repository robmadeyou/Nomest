package com.gmail.robmadeyou.leveleditor;

import com.abereth.game.Game;

public class Editor
{

	public static void main( String[] args )
	{
		Game g = new Game();
		g.addView( new AreaEditView( g ) );
		g.Start();
	}

}
