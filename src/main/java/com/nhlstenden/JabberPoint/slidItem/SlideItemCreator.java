package com.nhlstenden.JabberPoint.slidItem;

public abstract class SlideItemCreator {
  public static SlideItem createSlideItem(String type, int level, String content) {
    SlideItemType itemType;

    // 尝试将字符串转换为 SlideItemType 枚举
    try {
      itemType = SlideItemType.fromString(type);
    } catch (IllegalArgumentException e) {
      return null;
    }

    if (itemType == null) {
      return null;
    }

    // 根据转换后的 SlideItemType 枚举创建 SlideItem
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
