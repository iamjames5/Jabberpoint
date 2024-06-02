package com.nhlstenden.JabberPoint.style;

public class IndentDecorator extends StyleDecorator {

  public IndentDecorator(int indent, Style decoratedStyle) {
    super(decoratedStyle);
    this.setIndent(indent);
  }

  @Override
  public BasicStyle applyStyle(BasicStyle baseStyle) {
    BasicStyle style = super.applyStyle(baseStyle);
    style.setIndent(this.getIndent());
    return style;
  }
}
