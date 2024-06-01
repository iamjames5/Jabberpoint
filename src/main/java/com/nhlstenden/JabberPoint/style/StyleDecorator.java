package com.nhlstenden.JabberPoint.style;

import java.awt.Color;
import java.awt.Font;

public abstract class StyleDecorator implements Style {

  protected int indent;
  protected Color color;
  protected Font font;
  protected int fontSize;
  protected int leading;
  protected Style decoratedStyle;

  public StyleDecorator(Style decoratedStyle) {
    this.decoratedStyle = decoratedStyle;
  }

  // default getter and setter
  public int getIndent() {
    return indent;
  }

  public void setIndent(int indent) {
    this.indent = indent;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Font getFont() {
    return font;
  }

  public void setFont(Font font) {
    this.font = font;
  }

  public int getFontSize() {
    return fontSize;
  }

  public void setFontSize(int fontSize) {
    this.fontSize = fontSize;
  }

  public int getLeading() {
    return leading;
  }

  public void setLeading(int leading) {
    this.leading = leading;
  }

  @Override
  public BasicStyle applyStyle(BasicStyle baseStyle) {
    return decoratedStyle.applyStyle(baseStyle);
  }
}
