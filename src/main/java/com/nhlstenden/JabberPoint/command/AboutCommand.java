package com.nhlstenden.JabberPoint.command;

import com.nhlstenden.JabberPoint.presentation.Presentation;
import java.awt.*;
import javax.swing.*;

public class AboutCommand extends Command {
  private Frame parent;

  public AboutCommand(Presentation presentation, Frame parent) {
    super(presentation);
    this.parent = parent;
  }

  public Frame getParent() {
    return parent;
  }

  public void setParent(Frame parent) {
    this.parent = parent;
  }

  public void showMessageDialog(Frame frame, String message, String title, int messageType) {
    JOptionPane.showMessageDialog(frame, message, title, messageType);
  }

  @Override
  public void execute() {
    showMessageDialog(
        getParent(),
        "JabberPoint is a primitive slide-show program in Java(tm). It\n"
            + "is freely copyable as long as you keep this notice and\n"
            + "the splash screen intact.\n"
            + "Copyright (c) 1995-1997 by Ian F. Darwin, ian@darwinsys.com.\n"
            + "Adapted by Gert Florijn (version 1.1) and "
            + "Sylvia Stuurman (version 1.2 and higher) for the Open"
            + "University of the Netherlands, 2002 -- now."
            + "Author's version available from http://www.darwinsys.com/",
        "About JabberPoint",
        JOptionPane.INFORMATION_MESSAGE);
  }
}
