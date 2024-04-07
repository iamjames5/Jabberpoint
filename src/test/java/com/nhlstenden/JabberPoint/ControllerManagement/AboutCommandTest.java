package com.nhlstenden.JabberPoint.ControllerManagement;

import java.awt.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AboutCommandTest {

  @Test
  public void testExecute_assertDoesNotThrow_noExceptionThrown() {
    TestFrame parentFrame = new TestFrame();

    AboutCommand aboutCommand = new AboutCommand();
    aboutCommand.setParent(parentFrame);

    assertDoesNotThrow(aboutCommand::execute);
  }

  private static class TestFrame extends Frame {
    private boolean aboutBoxShown;

    @Override
    public void setVisible(boolean b) {
      super.setVisible(b); // Call super method to actually set visibility
      aboutBoxShown = b;
    }

    public boolean isAboutBoxShown() {
      return aboutBoxShown;
    }
  }
}
