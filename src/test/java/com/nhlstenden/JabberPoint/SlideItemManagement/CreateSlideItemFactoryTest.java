package com.nhlstenden.JabberPoint.SlideItemManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CreateSlideItemFactoryTest {
  @Test
  public void testSlideItemCreator_CreateTextItem_shouldBeExpect() {
    SlideItem slideItem = SlideItemCreator.createSlideItem(SlideItemType.TEXTITEM, 0, "Test");
    assertTrue(slideItem instanceof TextItem);
  }

  @Test
  public void testSlideItemCreator_CreateBitMapItem_shouldBeExpect() {
    SlideItem slideItem = SlideItemCreator.createSlideItem(SlideItemType.BITMAPITEM, 0, "Test");
    assertTrue(slideItem instanceof BitMapItem);
  }

  @Test
  public void testSlideItemCreator_CreateNullItem_shouldBeExpect() {
    SlideItem slideItem = SlideItemCreator.createSlideItem(SlideItemType.UNKNOWN, 0, "Test");
    assertNull(slideItem);
  }

  @Test
  public void testSlideItemCreator_CreateTextItemFromString_shouldBeExpect() {
    SlideItem slideItem = SlideItemCreator.createSlideItem("text", 0, "Test");
    assertTrue(slideItem instanceof TextItem);
  }

  @Test
  public void testSlideItemCreator_CreateBitMapItemFromString_shouldBeExpect() {
    SlideItem slideItem = SlideItemCreator.createSlideItem("image", 0, "Test");
    assertTrue(slideItem instanceof BitMapItem);
  }

  @Test
  public void testSlideItemCreator_CreateNullItemFromString_shouldBeExpect() {
    SlideItem slideItem = SlideItemCreator.createSlideItem("unknown", 0, "Test");
    assertNull(slideItem);
  }
}
