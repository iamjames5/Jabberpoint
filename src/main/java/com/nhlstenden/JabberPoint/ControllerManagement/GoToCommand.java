package com.nhlstenden.JabberPoint.ControllerManagement;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import javax.swing.*;

public class GoToCommand implements Command {
  private final Presentation presentation;

  public GoToCommand(Presentation presentation) {
    this.presentation = presentation;
  }

  @Override
  public void execute() {
    String pageNumberStr = JOptionPane.showInputDialog("Page number:");
    try {
      int pageNumber = Integer.parseInt(pageNumberStr);
      presentation.setSlideNumber(pageNumber - 1);
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(
          null, "Invalid page number", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
