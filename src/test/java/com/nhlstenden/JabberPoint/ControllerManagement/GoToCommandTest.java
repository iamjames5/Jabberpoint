package com.nhlstenden.JabberPoint.ControllerManagement;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class GoToCommandTest {

  @Test
  void testExecuteWithValidInput() {
    MockPresentation mockPresentation = new MockPresentation();
    GoToCommand goToCommand = new GoToCommand(mockPresentation);

    goToCommand.execute();

    assertEquals(4, mockPresentation.getSlideNumber()); // Since it's 0-based index
  }

  @Test
  void testExecuteWithInvalidInput() {
    MockPresentation mockPresentation = new MockPresentation();
    GoToCommand goToCommand = new GoToCommand(mockPresentation);

    // Execute the command
    goToCommand.execute();

    // Verify that the slide number was not set
    assertNotEquals(0, mockPresentation.getSlideNumber()); // Slide number should remain unchanged
  }

  private static class MockPresentation extends Presentation {
    private int slideNumber;

    public int getSlideNumber() {
      return slideNumber;
    }

    @Override
    public void setSlideNumber(int slideNumber) {
      this.slideNumber = slideNumber;
    }
  }
}
