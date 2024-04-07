package com.nhlstenden.JabberPoint.SlideViewerManagement;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import com.nhlstenden.JabberPoint.SlideItemManagement.Slide;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SlideViewerComponentTest {

  private Presentation presentation;
  private SlideViewerComponent slideViewerComponent;

  @BeforeEach
  void setUp() {
    presentation = new Presentation();
    JFrame frame = new JFrame();
    slideViewerComponent = new SlideViewerComponent(presentation, frame);
  }

  @Test
  public void testGetPreferredSize_assertEquals_slideWidth() {
    Dimension preferredSize = slideViewerComponent.getPreferredSize();
    assertEquals(Slide.WIDTH, preferredSize.width);
  }

  @Test
  public void testGetPreferredSize_assertEquals_slideHeight() {
    Dimension preferredSize = slideViewerComponent.getPreferredSize();
    assertEquals(Slide.HEIGHT, preferredSize.height);
  }

  @Test
  public void testUpdate_assertEquals_emptyTitleName() {
    Slide slide = new Slide(1);
    slideViewerComponent.update(presentation, slide);
    assertEquals("", slideViewerComponent.getFrame().getTitle());
  }

  @Test
  public void testPaintComponent_assertDoesNotThrow_correctGraphics() {
    Slide slide = new Slide(1);
    Presentation presentation = new Presentation();

    BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

    Graphics2D graphics = image.createGraphics();
    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    JFrame frame = new JFrame();

    SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, frame);

    assertDoesNotThrow(() -> slideViewerComponent.paintComponent(graphics));
  }
}
