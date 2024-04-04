package com.nhlstenden.JabberPoint.StyleManagement;

public class IndentDecorator extends StyleDecorator {
  private int indent;

  public IndentDecorator(Style wrapper, int indent) {
    super(wrapper);
    this.indent = indent;
  }

  public int getIndent() {
    return indent;
  }

  public void setIndent(int indent) {
    this.indent = indent;
  }

  @Override
  public void createStyle() {
    super.createStyle();
    System.out.println("Applying Indent: " + indent);
  }
}
