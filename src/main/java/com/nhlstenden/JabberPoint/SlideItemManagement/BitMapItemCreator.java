package com.nhlstenden.JabberPoint.SlideItemManagement;

public class BitMapItemCreator {
  public static SlideItem createSlideItem(int level, String content) {
    return new BitMapItem(level, content);
  }
}
