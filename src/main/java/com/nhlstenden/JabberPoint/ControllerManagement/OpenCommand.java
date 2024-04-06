package com.nhlstenden.JabberPoint.ControllerManagement;

import com.nhlstenden.JabberPoint.LoaderManagement.Accessor;
import com.nhlstenden.JabberPoint.LoaderManagement.XMLAccessor;
import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class OpenCommand implements Command {
  private final Presentation presentation;
  private final JFrame parentFrame;

  public OpenCommand(Presentation presentation, JFrame parentFrame) {
    this.presentation = presentation;
    this.parentFrame = parentFrame;
  }

  // Method to open a file
  private void openFile() {
    JFileChooser fileChooser = new JFileChooser();
    int returnValue = fileChooser.showOpenDialog(parentFrame);
    Accessor xmlAccessor = new XMLAccessor();

    if (returnValue == JFileChooser.APPROVE_OPTION) {
      try {
        // check if the file is a valid XML file
        File file = fileChooser.getSelectedFile();
        if (!file.getName().endsWith(".xml")) {
          JOptionPane.showMessageDialog(
              parentFrame,
              "Error opening file: " + "Invalid file type",
              "Open Error",
              JOptionPane.ERROR_MESSAGE);
          return;
        }

        presentation.clear();

        xmlAccessor.loadFile(presentation, file);
        presentation.setSlideNumber(0);
      } catch (IOException exc) {
        JOptionPane.showMessageDialog(
            parentFrame,
            "Error opening file: " + exc.getMessage(),
            "Open Error",
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  @Override
  public void execute() {
    openFile();
  }
}
