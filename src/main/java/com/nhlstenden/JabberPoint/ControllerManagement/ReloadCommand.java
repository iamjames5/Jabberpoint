package com.nhlstenden.JabberPoint.ControllerManagement;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;

public class ReloadCommand implements Command {
  private final Presentation presentation;

  public ReloadCommand(Presentation presentation) {
    this.presentation = presentation;
  }

  @Override
  public void execute() {
    presentation.notifyObservers();
  }
}
