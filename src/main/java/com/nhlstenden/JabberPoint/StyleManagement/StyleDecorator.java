package com.nhlstenden.JabberPoint.StyleManagement;

import java.awt.Color;
import java.awt.Font;

public abstract class StyleDecorator implements Style {
  static BasicStyle[] styles; // de styles

  int indent;
  Color color;
  Font font;
  int fontSize;
  int leading;

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
}
