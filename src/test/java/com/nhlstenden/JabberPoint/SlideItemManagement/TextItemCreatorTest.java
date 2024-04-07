package com.nhlstenden.JabberPoint.SlideItemManagement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TextItemCreatorTest {
  @Test
  public void testCreateSlideItem_CreatTextItem_shouldReturnTextItem() {
    SlideItem slideItem = TextItemCreator.createSlideItem(1, "test");
    assertNotNull(slideItem);
    assertTrue(slideItem instanceof TextItem);
    assertEquals(1, slideItem.getLevel());
  }
}
