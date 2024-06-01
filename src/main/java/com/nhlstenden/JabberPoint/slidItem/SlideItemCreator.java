package com.nhlstenden.JabberPoint.slidItem;

public abstract class SlideItemCreator {
  public static SlideItem createSlideItem(String type, int level, String content) {
    SlideItemType itemType;

    // Try to convert the string to a SlideItemType enum
    try {
      itemType = SlideItemType.fromString(type);
    } catch (IllegalArgumentException e) {
      return null;
    }

    if (itemType == null) {
      return null;
    }

    // Create a SlideItem based on the converted SlideItemType enum
    switch (itemType) {
      case TEXTITEM:
        return TextItemCreator.createSlideItem(level, content);
      case BITMAPITEM:
        return BitMapItemCreator.createSlideItem(level, content);
      default:
        return null;
    }
  }
}
