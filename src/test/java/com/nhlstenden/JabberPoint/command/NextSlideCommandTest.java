package com.nhlstenden.JabberPoint.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.nhlstenden.JabberPoint.presentation.Presentation;
import com.nhlstenden.JabberPoint.slideItem.Slide;
import org.junit.jupiter.api.Test;

public class NextSlideCommandTest {

  @Test
  public void testNextSlide_assertEquals_1() {
    Presentation presentation = new Presentation();
    presentation.append(new Slide(0));
    presentation.append(new Slide(1));

    presentation.setSlideNumber(0);

    NextSlideCommand nextSlideCommand = new NextSlideCommand(presentation);

    nextSlideCommand.execute();

    assertEquals(1, presentation.getSlideNumber());
  }

  @Test
  public void testNextSlideNoNextSlideAvailable_assertEquals_0() {
    Presentation presentation = new Presentation();
    presentation.append(new Slide(0));

    presentation.setSlideNumber(0);

    NextSlideCommand nextSlideCommand = new NextSlideCommand(presentation);

    nextSlideCommand.execute();

    assertEquals(0, presentation.getSlideNumber());
  }
}
