package com.nhlstenden.JabberPoint.controller;

import com.nhlstenden.JabberPoint.presentation.Presentation;

public class ReloadCommand extends Command {

  public ReloadCommand(Presentation presentation) {
    super(presentation);
  }

  @Override
  public void execute() {
    presentation.notifyObservers();
  }
}
