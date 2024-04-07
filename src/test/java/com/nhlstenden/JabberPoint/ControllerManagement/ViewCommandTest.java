package com.nhlstenden.JabberPoint.ControllerManagement;

import static org.junit.jupiter.api.Assertions.*;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import org.junit.jupiter.api.Test;

public class ViewCommandTest {

  @Test
  public void testExecute_assertDoesNotThrow_noExceptionThrown() {
    Presentation presentation = new Presentation();

    ViewCommand viewCommand = new ViewCommand(presentation);

    assertDoesNotThrow(viewCommand::execute);
  }
}
