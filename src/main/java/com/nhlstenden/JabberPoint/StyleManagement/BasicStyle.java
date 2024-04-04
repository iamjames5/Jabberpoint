package com.nhlstenden.JabberPoint.StyleManagement;

public class BasicStyle implements Style {
  private static final int DEFAULT_INDENT = 0;
  private static final String DEFAULT_FONT = "Helvetica";
  private static final int DEFAULT_FONTSIZE = 30;
  private static final int DEFAULT_LEADING = 20;
  private int indent;
  private Color color;
  private String font;
  private int fontSize;
  private int leading;

  public BasicStyle(int indent, Color color, String font, int fontSize, int leading) {
    this.indent = DEFAULT_INDENT;
    this.color = color;
    this.font = DEFAULT_FONT;
    this.fontSize = DEFAULT_FONTSIZE;
    this.leading = DEFAULT_LEADING;
  }

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

  public String getFont() {
    return font;
  }

  public void setFont(String font) {
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
  public void createStyle() {
    System.out.println(
        "Creating style -- Indent: "
            + indent
            + ", Font: "
            + font
            + ", Color: "
            + color
            + ", FontSize: "
            + fontSize
            + ", Leading: "
            + leading);
  }
}
