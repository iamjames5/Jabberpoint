package com.nhlstenden.JabberPoint.SlideItemManagement;

public class BitMapItemCreator extends SlideItemCreator {
  public static SlideItem createSlideItem(int level, String content) {
    return new BitMapItem(level, content);
  }
}
