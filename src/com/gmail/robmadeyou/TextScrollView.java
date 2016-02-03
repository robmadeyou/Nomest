package com.gmail.robmadeyou;

import com.abereth.G;
import com.abereth.draw.Color;
import com.abereth.event.TimedEvent;
import com.abereth.game.Game;
import com.abereth.game.View;
import com.abereth.gui.text.Text;
import com.abereth.gui.text.TextInputSingleLine;
import com.abereth.helpers.StringTools;
import com.abereth.input.Keyboard;

import java.util.ArrayList;

/**
 * Created by exfos on 25/01/15.
 */
public class TextScrollView extends View
{
	private ArrayList<Text> textGrid = new ArrayList<>( );
	private TextInputSingleLine input;
	private int textLimit;
	public TextScrollView( Game game )
	{
		super( game );
	}

	@Override
	public void Initialize()
	{
		super.Initialize();
		this.input = new TextInputSingleLine( 0, G.HEIGHT - 8, G.WIDTH, 8 );
		textLimit = G.WIDTH / 8;
		input.setIsAlwaysSelected( true );
		input.getText().setCharacterLimit( textLimit );
		add( input );
		input.setColor( Color.BLACK );
		for( int i = 0; i < G.HEIGHT / 12; i++ )
		{
			Text t = new Text( "", 2, 12 * i, 0, 0 );
			t.setCharacterLimit( textLimit );
			add( t );
			textGrid.add( t );
		}
		getGame().GetEventManager().CreateNewLogger( "FPS: ", 1000 );
	}

	public void writeCenteredText( String text )
	{
		int charsLeft = this.textLimit - text.length();
		String str = "";
		for( int i = 0; i < charsLeft / 2; i++ )
		{
			str += " ";
		}
		write( str + text + str );
	}

	/**
	 * Returns the number of lines available to print on the screen
	 * @return Integer
	 */
	public int getLineAmount()
	{
		return this.textGrid.size();
	}

	public TimedEvent<TextScrollView> scrollUp( final long delay, final int amount )
	{
		TimedEvent<TextScrollView> event = new TimedEvent<TextScrollView>()
		{
			private int left = 0;
			@Override
			public void eachInterval(int delta, TextScrollView view)
			{
				if( left != 0 )
				{
					view.write( "" );
					left--;
				}
			}

			@Override
			public void init( TextScrollView textScrollView )
			{
				super.init( textScrollView );
				setInterval(delay);
				left = amount;
			}

			@Override
			public boolean isDone( TextScrollView view )
			{
				return left == 0;
			}
		};
		getEventManager().add( event , false );
		return event;
	}

	public TimedEvent<TextScrollView> clearScreenScrollUp( long delay )
	{
		return scrollUp( delay, getLineAmount() );
	}

	public void write( String text, String color )
	{
		this.write( color + text );
	}

	public void write( String text )
	{
		this.write( text, false );
	}

	private void write( String text, boolean parsed )
	{
		for( int i = 0; i < textGrid.size(); i++ )
		{
			if( i != textGrid.size() - 1 )
			{
				textGrid.get( i ).set( textGrid.get( i + 1 ).getText() );
			}
			else
			{
				if( !parsed )
				{
					text = StringTools.insertEvery( textLimit, "\n", text );
					String[] multipleLines = text.split( "\n" );
					if( multipleLines.length > 1 )
					{
						for( int j = 0; j < multipleLines.length; j++ )
						{
							write( multipleLines[ j ] );
						}
					}
					else
					{
						textGrid.get( i ).set( text );
					}
				}
				else
				{
					textGrid.get( i ).set( text );
				}
			}
		}
	}

	public ArrayList<Text> getTextGrid()
	{
		return this.textGrid;
	}

	@Override
	public void update( int delta )
	{
		if( Keyboard.isKeyPressed( Keyboard.Key.Return ))
		{
			if( !input.getText().getText().equals( "" ) )
			{
				write( "&!!>" + input.getText().getText() );
				input.getText().set( "" );
			}
		}
	}
}
