package com.nhlstenden.JabberPoint.ControllerManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import org.junit.jupiter.api.Test;

public class NewCommandTest {

  @Test
  public void testSlideAdded_assertEquals_1() {
    Presentation presentation = new Presentation();
    NewCommand newCommand = new NewCommand(presentation);

    newCommand.execute();

    assertEquals(1, presentation.getSize());
  }

  @Test
  public void testCurrentSlide_assertNotNull_returnsNotNull() {
    Presentation presentation = new Presentation();
    NewCommand newCommand = new NewCommand(presentation);

    newCommand.execute();

    assertNotNull(presentation.getCurrentSlide());
  }

  @Test
  public void testSlideNumberSetToZero_assertEquals_0() {
    Presentation presentation = new Presentation();
    NewCommand newCommand = new NewCommand(presentation);

    newCommand.execute();

    assertEquals(0, presentation.getSlideNumber());
  }
}
