package com.nhlstenden.JabberPoint.ControllerManagement;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import org.junit.jupiter.api.Test;
import java.awt.Frame;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaveCommandTest {

   @Test
   public void testExecuteSuccessfulSave_assertTrue_returnsNewFile() {
      Presentation presentation = new Presentation();
      SaveCommand saveCommand = new SaveCommand(presentation, new Frame());

      assertDoesNotThrow(saveCommand::execute);
      assertTrue(new File("dump.xml").exists());
   }
}
