package com.nhlstenden.JabberPoint.ControllerManagement;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;

public class ViewCommand implements Command {
  private final Presentation presentation;

  public ViewCommand(Presentation presentation) {
    this.presentation = presentation;
  }

  @Override
  public void execute() {
    Command prevSlideCommand = new PrevSlideCommand(presentation);
    Command goToCommand = new GoToCommand(presentation);
    Command nextSlideCommand = new NextSlideCommand(presentation);

    prevSlideCommand.execute();
    goToCommand.execute();
    nextSlideCommand.execute();
  }
}
