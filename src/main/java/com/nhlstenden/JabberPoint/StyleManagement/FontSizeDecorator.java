package com.nhlstenden.JabberPoint.StyleManagement;

public class FontSizeDecorator extends StyleDecorator{
    private int fontSize;

    public FontSizeDecorator (Style wrapper, int fontSize)
    {
        super(wrapper);
        this.fontSize = fontSize;
    }

    public int getFontSize ()
    {
        return fontSize;
    }

    public void setFontSize (int fontSize)
    {
        this.fontSize = fontSize;
    }

    @Override
    public void createStyle ()
    {
        super.createStyle();
        System.out.println("Applying FontSize: " + fontSize);
    }
}
