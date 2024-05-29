package com.nhlstenden.JabberPoint.style;

public class LeadingDecorator extends StyleDecorator {

  public LeadingDecorator(int leading, Style decoratedStyle) {
    super(decoratedStyle);
    this.setLeading(leading);
  }

  @Override
  public BasicStyle applyStyle(BasicStyle baseStyle) {
    BasicStyle style = super.applyStyle(baseStyle);
    style.setLeading(this.getLeading());
    return style;
  }
}
