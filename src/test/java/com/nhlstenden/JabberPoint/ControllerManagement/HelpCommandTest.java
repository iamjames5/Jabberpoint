package com.nhlstenden.JabberPoint.ControllerManagement;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class HelpCommandTest {

  @Test
  public void testExecute_assertDoesNotThrow_noExceptionThrown() {
    HelpCommand helpCommand = new HelpCommand();

    assertDoesNotThrow(helpCommand::execute);
  }
}
