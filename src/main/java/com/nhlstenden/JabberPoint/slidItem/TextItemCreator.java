package com.nhlstenden.JabberPoint.slidItem;

public class TextItemCreator extends SlideItemCreator {
  public static SlideItem createSlideItem(int level, String content) {
    return new TextItem(level, content);
  }
}
