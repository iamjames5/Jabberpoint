package com.nhlstenden.JabberPoint.slideItem;

public class BitMapItemCreator extends SlideItemCreator {
  public static SlideItem createSlideItem(int level, String content) {
    return new BitMapItem(level, content);
  }
}
