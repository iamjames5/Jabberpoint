package com.nhlstenden.JabberPoint.StyleManagement;

public class LeadingDecorator implements Style {

  private int leading;

  public LeadingDecorator(int leading) {
    this.leading = leading;
  }

  @Override
  public BasicStyle applyStyle(BasicStyle baseStyle) {
    baseStyle.setLeading(leading);
    return baseStyle;
  }
}
