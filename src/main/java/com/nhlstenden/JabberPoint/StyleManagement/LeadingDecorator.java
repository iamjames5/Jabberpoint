package com.nhlstenden.JabberPoint.StyleManagement;

public class LeadingDecorator extends StyleDecorator {
  private int leading;

  public LeadingDecorator(Style wrapper, int leading) {
    super(wrapper);
    this.leading = leading;
  }

  public int getLeading() {
    return leading;
  }

  public void setLeading(int leading) {
    this.leading = leading;
  }

  @Override
  public void createStyle() {
    super.createStyle();
    System.out.println("Applying Leading: " + leading);
  }
}
