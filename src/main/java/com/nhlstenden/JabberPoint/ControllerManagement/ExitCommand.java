package com.nhlstenden.JabberPoint.ControllerManagement;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;

public class ExitCommand implements Command {
  private final Presentation presentation;

  public ExitCommand(Presentation presentation) {
    this.presentation = presentation;
  }

  @Override
  public void execute() {
    presentation.exit(0);
  }
}
