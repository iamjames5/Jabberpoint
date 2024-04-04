package com.nhlstenden.JabberPoint.StyleManagement;

abstract class StyleDecorator implements Style {
    protected Style wrapper;

    public StyleDecorator (Style wrapper)
    {
        this.wrapper = wrapper;
    }

    public Style getWrapper ()
    {
        return wrapper;
    }

    public void setWrapper (Style wrapper)
    {
        this.wrapper = wrapper;
    }

    @Override
    public void createStyle ()
    {
        wrapper.createStyle();
    }
}
