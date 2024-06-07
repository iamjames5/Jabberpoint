package com.nhlstenden.JabberPoint.style;

public class IndentDecorator extends StyleDecorator {
  private final int indent;

  public IndentDecorator(int indent, Style decoratedStyle) {
    super(decoratedStyle);
    this.indent = indent;
  }

  public int getIndent() {
    return indent;
  }

  @Override
  public BasicStyle applyStyle(BasicStyle basicStyle) {
    BasicStyle style = super.applyStyle(basicStyle);
    style.setIndent(this.indent);
    return style;
  }
}
