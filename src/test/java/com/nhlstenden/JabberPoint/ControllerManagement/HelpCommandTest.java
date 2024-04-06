package com.nhlstenden.JabberPoint.ControllerManagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class HelpCommandTest {

  @Test
  void testExecute() {
    HelpCommand helpCommand = new HelpCommand();

    assertDoesNotThrow(helpCommand::execute);
  }
}
