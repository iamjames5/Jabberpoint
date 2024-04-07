package com.nhlstenden.JabberPoint.ControllerManagement;

import java.awt.*;

public class AboutCommand implements Command {
  private Frame parent;

  public Frame getParent() {
    return parent;
  }

  public void setParent(Frame parent) {
    this.parent = parent;
  }

  @Override
  public void execute() {
    AboutBox.show(parent);
  }
}
