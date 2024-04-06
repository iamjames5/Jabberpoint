package com.nhlstenden.JabberPoint.SlideItemManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CreateSlideItemFactoryTest {
  // Test if the createSlideItem method returns a TextItem object
  @Test
  public void testSlideItemCreator_CreateTextItem_shouldBeExpect() {
    SlideItem slideItem = SlideItemCreator.createSlideItem(SlideItemType.TEXTITEM, 0, "Test");
    assertTrue(slideItem instanceof TextItem);
  }

  // Test if the createSlideItem method returns a BitMapItem object
  @Test
  public void testSlideItemCreator_CreateBitMapItem_shouldBeExpect() {
    SlideItem slideItem = SlideItemCreator.createSlideItem(SlideItemType.BITMAPITEM, 0, "Test");
    assertTrue(slideItem instanceof BitMapItem);
  }

  // Test if the createSlideItem method returns null
  @Test
  public void testSlideItemCreator_CreateNullItem_shouldBeExpect() {
    SlideItem slideItem = SlideItemCreator.createSlideItem(SlideItemType.UNKNOWN, 0, "Test");
    assertNull(slideItem);
  }

  // Test if the createSlideItem method returns a TextItem object
  @Test
  public void testSlideItemCreator_CreateTextItemFromString_shouldBeExpect() {
    SlideItem slideItem = SlideItemCreator.createSlideItem("text", 0, "Test");
    assertTrue(slideItem instanceof TextItem);
  }
}
