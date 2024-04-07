package com.nhlstenden.JabberPoint.StyleManagement;

public class IndentDecorator implements Style {
  private final int indent;

  public IndentDecorator(int indent) {
    this.indent = indent;
  }

  @Override
  public BasicStyle applyStyle(BasicStyle baseStyle) {
    baseStyle.setIndent(indent);
    return baseStyle;
  }
}
