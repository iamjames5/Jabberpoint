package com.nhlstenden.JabberPoint.command;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import com.nhlstenden.JabberPoint.presentation.Presentation;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ExitCommandTest {

  @Test
  public void testExecute_assertEquals_0() {
    Presentation mockPresentation = Mockito.mock(Presentation.class);
    ExitCommand exitCommand = new ExitCommand(mockPresentation);
    exitCommand.execute();
    verify(mockPresentation).exit(0);
  }
}
