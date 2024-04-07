package com.nhlstenden.JabberPoint.ControllerManagement;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoToCommandTest {

  @Test
  public void testExecuteWithValidInput_assertEquals_4() {
    MockPresentation mockPresentation = new MockPresentation();
    GoToCommand goToCommand = new GoToCommand(mockPresentation);

    goToCommand.execute();

    // Since it's 0-based index enter 5
    assertEquals(4, mockPresentation.getSlideNumber());
  }

  @Test
  public void testExecuteWithInvalidInput_assertDoesNotEqual_0() {
    MockPresentation mockPresentation = new MockPresentation();
    GoToCommand goToCommand = new GoToCommand(mockPresentation);

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
