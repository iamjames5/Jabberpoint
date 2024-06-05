package com.nhlstenden.JabberPoint.style;

import java.awt.Font;

public class FontDecorator extends StyleDecorator {
  private static final String DEFAULT_FONT = "Helvetica";
  private final Font font;
  private final int fontSize;

  public FontDecorator(int point, Style decoratedStyle) {
    super(decoratedStyle);
    this.fontSize = point;
    this.font = new Font(DEFAULT_FONT, Font.BOLD, point);
  }

  public Font getFont() {
    return font;
  }

  public int getFontSize() {
    return fontSize;
  }

  @Override
  public BasicStyle applyStyle(BasicStyle basicStyle) {
    BasicStyle style = super.applyStyle(basicStyle);
    style.setFont(this.font);
    style.setFontSize(this.fontSize);
    return style;
  }
}
