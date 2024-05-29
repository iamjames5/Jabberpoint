package com.nhlstenden.JabberPoint.controller;

import com.nhlstenden.JabberPoint.presentation.Presentation;

public abstract class Command {
  protected Presentation presentation;

  public Command (Presentation presentation)
  {
    this.presentation = presentation;
  }

  public abstract void execute();
}
