package com.nhlstenden.JabberPoint.StyleManagement;

public class FontSizeDecorator implements Style {

  int fontSize;

  public FontSizeDecorator(int fontSize) {
    this.fontSize = fontSize;
  }

  @Override
  public BasicStyle applyStyle(BasicStyle baseStyle) {
    baseStyle.setFontSize(fontSize);
    return baseStyle;
  }
}
