package com.nhlstenden.JabberPoint.ControllerManagement;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import com.nhlstenden.JabberPoint.SlideItemManagement.Slide;

public class NewCommand implements Command {

  private final Presentation presentation;

  public NewCommand(Presentation presentation) {
    this.presentation = presentation;
  }

  @Override
  public void execute() {
    Slide newSlide = new Slide(0);
    presentation.clear();

    presentation.append(newSlide);
    presentation.setSlideNumber(presentation.getSize() - 1);
  }
}
