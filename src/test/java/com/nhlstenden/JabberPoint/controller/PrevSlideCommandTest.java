package com.nhlstenden.JabberPoint.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.nhlstenden.JabberPoint.presentation.Presentation;
import com.nhlstenden.JabberPoint.slidItem.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrevSlideCommandTest {

  private Presentation presentation;

  @BeforeEach
  public void setUp() {
    presentation = new Presentation();
    Slide slide1 = new Slide(1);
    Slide slide2 = new Slide(2);
    Slide slide3 = new Slide(3);
    presentation.append(slide1);
    presentation.append(slide2);
    presentation.append(slide3);
  }

  @Test
  public void testPrevSlide_assertEquals_1() {
    presentation.setSlideNumber(2);

    PrevSlideCommand prevSlideCommand = new PrevSlideCommand(presentation);
    prevSlideCommand.execute();

    assertEquals(1, presentation.getSlideNumber());
  }

  @Test
  public void testPrevSlideAtBeginning_assertEquals_0() {
    presentation.setSlideNumber(0);

    PrevSlideCommand prevSlideCommand = new PrevSlideCommand(presentation);
    prevSlideCommand.execute();

    assertEquals(0, presentation.getSlideNumber());
  }
}
