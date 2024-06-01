package com.nhlstenden.JabberPoint.command;

import com.nhlstenden.JabberPoint.command.Command;
import com.nhlstenden.JabberPoint.loader.Accessor;
import com.nhlstenden.JabberPoint.loader.XMLAccessor;
import com.nhlstenden.JabberPoint.presentation.Presentation;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class SaveCommand extends Command {
  protected static final String SAVEERR = "Save Error";
  protected static final String SAVEFILE = "dump.xml";
  protected static final String IOEX = "IO Exception: ";
  private final Frame parent;

  public SaveCommand(Presentation presentation, Frame parent) {
    super(presentation);
    this.parent = parent;
  }

  @Override
  public void execute() {
    Accessor xmlAccessor = new XMLAccessor();
    try {
      File file = new File(SAVEFILE);
      xmlAccessor.saveFile(presentation, file);
    } catch (IOException exc) {
      JOptionPane.showMessageDialog(parent, IOEX + exc, SAVEERR, JOptionPane.ERROR_MESSAGE);
    }
  }
}
