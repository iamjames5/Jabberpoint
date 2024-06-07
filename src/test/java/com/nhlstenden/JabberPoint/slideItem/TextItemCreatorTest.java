package com.nhlstenden.JabberPoint.slideItem;

import static org.junit.jupiter.api.Assertions.*;

import com.nhlstenden.JabberPoint.slideItem.SlideItem;
import com.nhlstenden.JabberPoint.slideItem.TextItem;
import com.nhlstenden.JabberPoint.slideItem.TextItemCreator;
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
