package com.nhlstenden.JabberPoint.style;

import java.awt.Font;

public class FontDecorator extends StyleDecorator {

  private static final String DEFAULT_FONT = "Helvetica";

  public FontDecorator(int point, Style decoratedStyle) {
    super(decoratedStyle);
    Font font = new Font(DEFAULT_FONT, Font.BOLD, point);
    this.setFontSize(point);
    this.setFont(font);
  }

  @Override
  public BasicStyle applyStyle(BasicStyle baseStyle) {
    BasicStyle style = super.applyStyle(baseStyle);
    style.setFont(this.getFont());
    style.setFontSize(this.getFontSize());
    return style;
  }
}
