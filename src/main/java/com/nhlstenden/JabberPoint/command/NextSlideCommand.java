package com.nhlstenden.JabberPoint.command;

import com.nhlstenden.JabberPoint.presentation.Presentation;

public class NextSlideCommand extends Command {

  public NextSlideCommand(Presentation presentation) {
    super(presentation);
  }

  @Override
  public void execute() {
    presentation.nextSlide();
  }
}
