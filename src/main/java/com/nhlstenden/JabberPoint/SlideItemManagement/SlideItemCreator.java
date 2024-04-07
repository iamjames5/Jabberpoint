package com.nhlstenden.JabberPoint.SlideItemManagement;

public abstract class SlideItemCreator {
  public static SlideItem createSlideItem(SlideItemType type, int level, String content) {
    switch (type) {
      case TEXTITEM:
        return TextItemCreator.createSlideItem(level, content);
      case BITMAPITEM:
        return BitMapItemCreator.createSlideItem(level, content);
      default:
        return null;
    }
  }

  public static SlideItem createSlideItem(String type, int level, String content) {
    try {
      SlideItemType t = SlideItemType.fromString(type);
      if (t != null) {
        switch (t) {
          case TEXTITEM:
            return TextItemCreator.createSlideItem(level, content);
          case BITMAPITEM:
            return BitMapItemCreator.createSlideItem(level, content);
          default:
            return null;
        }
      }
    } catch (IllegalArgumentException e) {
      return null;
    }
    return null;
  }
}
