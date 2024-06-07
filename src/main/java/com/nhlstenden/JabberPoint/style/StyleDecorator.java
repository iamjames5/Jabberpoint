package com.nhlstenden.JabberPoint.style;

public abstract class StyleDecorator implements Style {
  protected Style decoratedStyle;

  public StyleDecorator(Style decoratedStyle) {
    this.decoratedStyle = decoratedStyle;
  }

  @Override
  public BasicStyle applyStyle(BasicStyle basicStyle) {
    return decoratedStyle.applyStyle(basicStyle);
  }
}
