package com.nhlstenden.JabberPoint.SlideViewerManagement;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SlideViewerFrameTest {

  @Test
  public void testTitle_assertEquals_correctTitleName() {
    Presentation presentation = new Presentation();
    SlideViewerFrame frame = new SlideViewerFrame("Test Title", presentation);

    assertEquals("Jabberpoint 1.6 - OU", frame.getTitle());
  }

  @Test
  public void testSlideViewerComponent_assertTrue_returnsTrue() {
    Presentation presentation = new Presentation();
    SlideViewerFrame frame = new SlideViewerFrame("Test Title", presentation);
    SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, frame);

    frame.setupWindow(slideViewerComponent, presentation);

    assertTrue(frame.getContentPane().getComponent(0) instanceof SlideViewerComponent);
  }

  @Test
  public void testWindowAdapter_assertTrue_windowAdapterIsAdded() {
    Presentation presentation = new Presentation();
    SlideViewerFrame frame = new SlideViewerFrame("Test Title", presentation);

    frame.setupWindow(new SlideViewerComponent(presentation, frame), presentation);

    WindowListener[] windowListeners = frame.getWindowListeners();
    boolean containsWindowAdapter = false;
    for (WindowListener listener : windowListeners) {
      if (listener instanceof WindowAdapter) {
        containsWindowAdapter = true;
        break;
      }
    }
    assertTrue(containsWindowAdapter);
  }

  @Test
  public void testControllers_assertEquals_OneKeyController() {
    Presentation presentation = new Presentation();
    SlideViewerFrame frame = new SlideViewerFrame("Test Title", presentation);

    assertEquals(1, frame.getKeyListeners().length);
  }

  @Test
  public void testSizeAndVisibility_assertEquals_expectFrameSizeIsActualFrameSize() {
    Presentation presentation = new Presentation();
    SlideViewerFrame frame = new SlideViewerFrame("Test Title", presentation);

    frame.setupWindow(new SlideViewerComponent(presentation, frame), presentation);

    assertEquals(new Dimension(SlideViewerFrame.WIDTH, SlideViewerFrame.HEIGHT), frame.getSize());
  }
}
