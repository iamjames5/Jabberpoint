package com.nhlstenden.JabberPoint.slideItem;

public class TextItemCreator extends SlideItemCreator {
  public static SlideItem createSlideItem(int level, String content) {
    return new TextItem(level, content);
  }
}
