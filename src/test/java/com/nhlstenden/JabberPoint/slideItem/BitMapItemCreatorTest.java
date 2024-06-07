package com.nhlstenden.JabberPoint.slideItem;

import static org.junit.jupiter.api.Assertions.*;

import com.nhlstenden.JabberPoint.slideItem.BitMapItem;
import com.nhlstenden.JabberPoint.slideItem.BitMapItemCreator;
import com.nhlstenden.JabberPoint.slideItem.SlideItem;
import org.junit.jupiter.api.Test;

public class BitMapItemCreatorTest {
  @Test
  public void testCreateSlideItem_CreatBitMapItem_shouldReturnBitMapItem() {
    SlideItem slideItem = BitMapItemCreator.createSlideItem(1, "test");
    assertNotNull(slideItem);
    assertTrue(slideItem instanceof BitMapItem);
    assertEquals(1, slideItem.getLevel());
  }
}
