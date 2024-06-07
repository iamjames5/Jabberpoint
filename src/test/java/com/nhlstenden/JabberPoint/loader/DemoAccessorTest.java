package com.nhlstenden.JabberPoint.loader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.nhlstenden.JabberPoint.presentation.Presentation;
import com.nhlstenden.JabberPoint.slideItem.Slide;
import java.io.File;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DemoAccessorTest {
  private DemoAccessor demoAccessor;
  private Presentation presentation;

  @BeforeEach
  void setUp() {
    demoAccessor = new DemoAccessor();
    presentation = new Presentation();
  }

  @Test
  public void testLoadFile_assertEquals_3() {
    File file = new File("Test");
    demoAccessor.loadFile(presentation, file);

    assertEquals("Demo Presentation", presentation.getTitle());
    List<Slide> slides = presentation.getShowList();
    assertEquals(3, slides.size());
  }

  @Test
  public void testSaveFile_assertThrows_exceptionThrown() {
    File file = new File("Test");

    assertThrows(IllegalStateException.class, () -> demoAccessor.saveFile(presentation, file));
  }
}
