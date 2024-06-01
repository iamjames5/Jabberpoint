package com.nhlstenden.JabberPoint.command;

import com.nhlstenden.JabberPoint.presentation.Presentation;
import javax.swing.*;

public class GoToCommand extends Command
{

  public GoToCommand(Presentation presentation) {
    super(presentation);
  }

  protected String getUserInputDialog() {
    return JOptionPane.showInputDialog("Page number:");
  }

  protected int getUserInput() throws NumberFormatException {
    String pageNumberStr = getUserInputDialog();
    return Integer.parseInt(pageNumberStr);
  }

  protected void showMessageDialog(JFrame frame, String message, String title, int messageType) {
    JOptionPane.showMessageDialog(frame, message, title, messageType);
  }

  @Override
  public void execute() {
    try {
      int pageNumber = getUserInput();
      // check pageNumber is in page range
      if (pageNumber < 1 || pageNumber > presentation.getSize()) {
          showMessageDialog(
              null, "Invalid page number, Out of range", "Error", JOptionPane.ERROR_MESSAGE);
          return;
      }

      presentation.setSlideNumber(pageNumber - 1);
    } catch (NumberFormatException e) {
      showMessageDialog(
          null, "Invalid page number", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
