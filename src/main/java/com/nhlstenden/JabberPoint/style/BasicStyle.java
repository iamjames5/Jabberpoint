package com.nhlstenden.JabberPoint.style;

import java.awt.Color;
import java.awt.Font;

public class BasicStyle implements Style {
  private int indent;
  private Color color;
  private Font font;
  private int fontSize;
  private int leading;

  public BasicStyle(int indent, Color color, Font font, int fontSize, int leading) {
    this.indent = indent;
    this.color = color;
    this.font = font;
    this.fontSize = fontSize;
    this.leading = leading;
  }

  // Getters and setters for the properties
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
  public BasicStyle applyStyle(BasicStyle basicStyle) {
    basicStyle.setIndent(this.indent);
    basicStyle.setColor(this.color);
    basicStyle.setFont(this.font);
    basicStyle.setFontSize(this.fontSize);
    basicStyle.setLeading(this.leading);
    return basicStyle;
  }

  @Override
  public String toString() {
    String str =
        "Indent: "
            + indent
            + ", Color: "
            + color
            + ", Leading: "
            + leading
            + ", FontSize: "
            + fontSize;
    if (font != null) {
      str += ", Font: " + font.getFontName() + ", FontStyle: " + font.getStyle();
    }
    return str;
  }

  public Font getFont(float scale) {
    return font.deriveFont(fontSize * scale);
  }
}
