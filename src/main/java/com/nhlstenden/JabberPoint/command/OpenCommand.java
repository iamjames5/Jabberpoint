package com.nhlstenden.JabberPoint.command;

import com.nhlstenden.JabberPoint.loader.Accessor;
import com.nhlstenden.JabberPoint.loader.XMLAccessor;
import com.nhlstenden.JabberPoint.presentation.Presentation;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class OpenCommand extends Command
{
  private final JFrame parentFrame;

  public OpenCommand(Presentation presentation, JFrame parentFrame) {
    super(presentation);
    this.parentFrame = parentFrame;
  }

  // Method to open a file
  private void openFile() {
    Accessor xmlAccessor = createXMLAccessor();
    try {
      // check if the file is a valid XML file
      File file = createFileChooser();
      if(file == null) {
        return;
      }

      if (!file.getName().endsWith(".xml")) {
        showMessageDialog(parentFrame, "Error opening file: " + "Invalid file type", "Open Error", JOptionPane.ERROR_MESSAGE);
        return;
      }

      presentation.clear();
      xmlAccessor.loadFile(presentation, file);
      presentation.setSlideNumber(0);

    } catch (IOException exc) {
      showMessageDialog(parentFrame, "Error opening file: " + exc.getMessage(), "Open Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  protected void showMessageDialog(JFrame frame, String message, String title, int messageType) {
    JOptionPane.showMessageDialog(frame, message, title, messageType);
  }

  protected File createFileChooser() {
    JFileChooser fileChooser = new JFileChooser();
    // set only show .xml file
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("XML files", "xml"));

    int returnValue = fileChooser.showOpenDialog(parentFrame);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
      return fileChooser.getSelectedFile();
    }

    return null;
  }

  protected XMLAccessor createXMLAccessor() {
    return new XMLAccessor();
  }

  @Override
  public void execute() {
    openFile();
  }
}
