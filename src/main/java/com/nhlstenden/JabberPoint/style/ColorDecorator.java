package com.nhlstenden.JabberPoint.style;

import java.awt.Color;

public class ColorDecorator extends StyleDecorator {

  public ColorDecorator(Color color, Style decoratedStyle) {
    super(decoratedStyle);
    this.setColor(color);
  }

  @Override
  public BasicStyle applyStyle(BasicStyle baseStyle) {
    BasicStyle style = super.applyStyle(baseStyle);
    style.setColor(this.getColor());
    return style;
  }
}
