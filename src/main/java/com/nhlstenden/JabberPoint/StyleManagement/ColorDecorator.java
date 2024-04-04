package com.nhlstenden.JabberPoint.StyleManagement;

public class ColorDecorator extends StyleDecorator{
    private Color color;
    public ColorDecorator (Style wrapper, Color color)
    {
        super(wrapper);
        this.color = color;
    }

    public Color getColor ()
    {
        return color;
    }

    public void setColor (Color color)
    {
        this.color = color;
    }

    @Override
    public void createStyle ()
    {
        super.createStyle();
        System.out.println("Applying Color: " + color);
    }
}
