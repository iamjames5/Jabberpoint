package com.nhlstenden.JabberPoint.ControllerManagement;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Frame;
import org.junit.jupiter.api.Test;

public class AboutCommandTest {

  @Test
  public void testExecute() {
    MockFrame mockFrame = new MockFrame();

    AboutCommand aboutCommand = new AboutCommand();
    aboutCommand.setParent(mockFrame);

    aboutCommand.execute();

    assertTrue(mockFrame.isShowCalled());
  }

  private static class MockFrame extends Frame {
    private boolean showCalled = false;

    @Override
    public void show() {
      showCalled = true;
    }

    public boolean isShowCalled() {
      return showCalled;
    }
  }
}
