package com.nhlstenden.JabberPoint.ControllerManagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class HelpCommandTest {

  @Test
  public void testExecute_assertDoesNotThrow_noExceptionThrown() {
    HelpCommand helpCommand = new HelpCommand();

    assertDoesNotThrow(helpCommand::execute);
  }
}
