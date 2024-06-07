package com.nhlstenden.JabberPoint.style;

public class LeadingDecorator extends StyleDecorator {
  private final int leading;

  public LeadingDecorator(int leading, Style decoratedStyle) {
    super(decoratedStyle);
    this.leading = leading;
  }

  public int getLeading() {
    return leading;
  }

  @Override
  public BasicStyle applyStyle(BasicStyle basicStyle) {
    BasicStyle style = super.applyStyle(basicStyle);
    style.setLeading(this.leading);
    return style;
  }
}
