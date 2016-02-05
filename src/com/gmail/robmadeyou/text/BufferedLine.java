package com.gmail.robmadeyou.text;

import com.abereth.gui.text.Text;

/**
 * Model for a line of string
 * Created by r on 04/02/2016.
 */
public class BufferedLine {

    Text text;
    public BufferedLine( Text s )
    {
        this.text = s;
    }

    public Text getLine()
    {
        return this.text;
    }

    public String getText()
    {
        return this.text.getText();
    }

    public String setText( String text )
    {
        this.text.set( text );
        return text;
    }

    public Text appendText( String s )
    {
        this.text.set( getText() + s );
        return this.text;
    }

    public Text prependText( String s )
    {
        this.text.set( s + getText() );
        return this.text;
    }
}
