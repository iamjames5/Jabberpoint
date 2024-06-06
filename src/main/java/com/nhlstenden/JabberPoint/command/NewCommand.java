package com.nhlstenden.JabberPoint.command;

import com.nhlstenden.JabberPoint.presentation.Presentation;
import com.nhlstenden.JabberPoint.slideItem.Slide;

public class NewCommand extends Command {

  public NewCommand(Presentation presentation) {
    super(presentation);
  }

  @Override
  public void execute() {
    Slide newSlide = new Slide(0);
    presentation.clear();

    presentation.append(newSlide);
    presentation.setSlideNumber(presentation.getSize() - 1);
  }
}
