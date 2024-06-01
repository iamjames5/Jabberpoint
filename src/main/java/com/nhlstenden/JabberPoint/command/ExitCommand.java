package com.nhlstenden.JabberPoint.command;

import com.nhlstenden.JabberPoint.command.Command;
import com.nhlstenden.JabberPoint.presentation.Presentation;

public class ExitCommand extends Command {
  public ExitCommand(Presentation presentation) {
    super(presentation);
  }

  @Override
  public void execute() {
    presentation.exit(0);
  }
}
