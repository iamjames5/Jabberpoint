package com.nhlstenden.JabberPoint.controller;

import com.nhlstenden.JabberPoint.presentation.Presentation;

public class PrevSlideCommand extends Command {

  public PrevSlideCommand(Presentation presentation) {
    super(presentation);
  }

  @Override
  public void execute() {
    presentation.prevSlide();
  }
}
