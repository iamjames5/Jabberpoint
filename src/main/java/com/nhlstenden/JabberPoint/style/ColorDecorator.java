package com.nhlstenden.JabberPoint.style;

import java.awt.Color;

public class ColorDecorator extends StyleDecorator {
  private final Color color;

  public ColorDecorator(Color color, Style decoratedStyle) {
    super(decoratedStyle);
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  @Override
  public BasicStyle applyStyle(BasicStyle basicStyle) {
    BasicStyle style = super.applyStyle(basicStyle);
    style.setColor(this.color);
    return style;
  }
}
