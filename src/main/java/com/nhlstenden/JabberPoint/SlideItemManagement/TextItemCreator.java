package com.nhlstenden.JabberPoint.SlideItemManagement;

public class TextItemCreator {
  public static SlideItem createSlideItem(int level, String content) {
    return new TextItem(level, content);
  }
}
