package com.gmail.robmadeyou.text;

/**
 * Model for a line of string
 * Created by r on 04/02/2016.
 */
public class BufferedLine {

    String text;
    public BufferedLine( String s )
    {
        this.text = s;
    }

    public String getLine()
    {
        return this.text;
    }

    public String setText( String text )
    {
        this.text = text;
        return text;
    }

    public String appendText( String s )
    {
        this.text += s;
        return this.text;
    }

    public String prependText( String s )
    {
        this.text = s + this.text;
        return this.text;
    }
}
