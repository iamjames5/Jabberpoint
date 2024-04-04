package com.nhlstenden.JabberPoint.StyleManagement;

public class FontDecorator extends StyleDecorator {
  private String font;

  public FontDecorator(Style wrapper, String font) {
    super(wrapper);
    this.font = font;
  }

  public String getFont() {
    return font;
  }

  public void setFont(String font) {
    this.font = font;
  }

  @Override
  public void createStyle() {
    super.createStyle();
    System.out.println("Applying Font: " + font);
  }
}
