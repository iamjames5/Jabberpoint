package com.nhlstenden.JabberPoint.command;

import static org.junit.jupiter.api.Assertions.*;

import com.nhlstenden.JabberPoint.command.ExitCommand;
import com.nhlstenden.JabberPoint.presentation.Presentation;
import org.junit.jupiter.api.Test;

public class ExitCommandTest {

  @Test
  public void testExecute_assertEquals_0() {
    MockPresentation mockPresentation = new MockPresentation();

    ExitCommand exitCommand = new ExitCommand(mockPresentation);

    exitCommand.execute();
    mockPresentation.exit(0);

    assertEquals(0, mockPresentation.getExitCode());
    assertEquals(0, mockPresentation.exit(0));
  }

  private class MockPresentation extends Presentation {
    private int exitCode;

    @Override
    public int exit(int code) {
      this.exitCode = code;
      return code;
    }

    public int getExitCode() {
      return exitCode;
    }
  }
}
