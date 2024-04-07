package com.nhlstenden.JabberPoint.StyleManagement;

import java.awt.Font;

public class FontDecorator implements Style {

  private static final String FONTNAME = "Helvetica";

  private Font font;
  private int fontSize;

  public FontDecorator(Font font) {
    this.font = font;
  }

  public FontDecorator(int points) {
    this.font = new Font(FONTNAME, Font.BOLD, points);
    this.fontSize = points;
  }

  public FontDecorator(String name, int points, int bold) {
    this.font = new Font(name, bold, fontSize = points);
  }

  @Override
  public BasicStyle applyStyle(BasicStyle baseStyle) {
    baseStyle.setFont(font);
    baseStyle.setFontSize(fontSize);

    return baseStyle;
  }
}
