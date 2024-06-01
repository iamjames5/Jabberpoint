package com.nhlstenden.JabberPoint.command;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.nhlstenden.JabberPoint.presentation.Presentation;
import java.awt.Frame;
import java.io.File;
import org.junit.jupiter.api.Test;

public class SaveCommandTest {

  @Test
  public void testExecuteSuccessfulSave_assertTrue_returnsNewFile() {
    Presentation presentation = new Presentation();
    SaveCommand saveCommand = new SaveCommand(presentation, new Frame());

    assertDoesNotThrow(saveCommand::execute);
    assertTrue(new File("dump.xml").exists());
  }
}
