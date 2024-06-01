package com.nhlstenden.JabberPoint.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.nhlstenden.JabberPoint.presentation.Presentation;
import java.awt.*;
import java.awt.event.KeyEvent;
import org.junit.jupiter.api.Test;

public class KeyControllerTest {

  @Test
  public void testKeyPressedNextSlide_assertEquals_negative1() {
    Presentation presentation = new Presentation();
    KeyController keyController = new KeyController(presentation);

    Component component = new Component() {};

    keyController.keyPressed(
        new KeyEvent(
            component,
            KeyEvent.KEY_PRESSED,
            System.currentTimeMillis(),
            0,
            KeyEvent.VK_PAGE_DOWN,
            ' '));

    assertEquals(
        -1,
        presentation.getSlideNumber(),
        "Expected slide number should be 1 after pressing next slide key");
  }

  @Test
  public void testKeyPressedPreviousSlide_assertEquals_0() {
    Presentation presentation = new Presentation();
    presentation.setSlideNumber(1); // Set the current slide to slide number 1
    KeyController keyController = new KeyController(presentation);

    Component component = new Component() {};

    keyController.keyPressed(
        new KeyEvent(
            component,
            KeyEvent.KEY_PRESSED,
            System.currentTimeMillis(),
            0,
            KeyEvent.VK_PAGE_UP,
            ' '));

    assertEquals(
        0,
        presentation.getSlideNumber(),
        "Expected slide number should be 0 after pressing previous slide key");
  }

  @Test
  public void testKeyPressedExit_assertEquals_0() {
    Presentation presentation = new Presentation();
    KeyController keyController = new KeyController(presentation);

    Component component = new Component() {};

    keyController.keyPressed(
        new KeyEvent(
            component, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_Q, ' '));

    assertEquals(
        0,
        presentation.getSlideNumber(),
        "Expected slide number should be 0 after calling exit method");
  }

}
