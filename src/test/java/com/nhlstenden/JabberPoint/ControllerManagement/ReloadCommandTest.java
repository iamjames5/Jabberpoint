package com.nhlstenden.JabberPoint.ControllerManagement;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import org.junit.jupiter.api.Test;

public class ReloadCommandTest {
  @Test
  public void testExecute_assertDoesNotThrow_noThrownException() {
    Presentation presentation = new Presentation();

    ReloadCommand reloadCommand = new ReloadCommand(presentation);

    assertDoesNotThrow(reloadCommand::execute);
  }
}
