package com.nhlstenden.JabberPoint.StyleManagement;

import java.awt.Color;

public class ColorDecorator implements Style {

  private final Color color;

  public ColorDecorator(Color color) {
    this.color = color;
  }

  @Override
  public BasicStyle applyStyle(BasicStyle baseStyle) {
    baseStyle.setColor(color);
    return baseStyle;
  }
}
