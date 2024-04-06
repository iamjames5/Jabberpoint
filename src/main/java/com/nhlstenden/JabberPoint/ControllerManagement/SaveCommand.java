package com.nhlstenden.JabberPoint.ControllerManagement;

import com.nhlstenden.JabberPoint.LoaderManagement.Accessor;
import com.nhlstenden.JabberPoint.LoaderManagement.XMLAccessor;
import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class SaveCommand implements Command {
  protected static final String SAVEERR = "Save Error";
  protected static final String SAVEFILE = "dump.xml";
  protected static final String IOEX = "IO Exception: ";
  private final Presentation presentation;
  private final Frame parent;

  public SaveCommand(Presentation presentation, Frame parent) {
    this.presentation = presentation;
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
