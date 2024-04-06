package com.nhlstenden.JabberPoint.ControllerManagement;

import static org.junit.jupiter.api.Assertions.*;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import org.junit.jupiter.api.Test;

public class ExitCommandTest {

  @Test
  public void assertEqualsTrue() {
    MockPresentation mockPresentation = new MockPresentation();

    ExitCommand exitCommand = new ExitCommand(mockPresentation);

    exitCommand.execute();

    assertEquals(0, mockPresentation.getExitCode());
  }

  private static class MockPresentation extends Presentation {
    private int exitCode;

    @Override
    public void exit(int code) {
      this.exitCode = code;
    }

    public int getExitCode() {
      return exitCode;
    }
  }
}
