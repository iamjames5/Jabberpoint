package com.nhlstenden.JabberPoint.SlideItemManagement;

public enum SlideItemType {
  TEXTITEM("text"),
  UNKNOWN("unknown"),
  BITMAPITEM("image");

  private final String ttype;

  SlideItemType(String str) {
    ttype = str;
  }

  public static SlideItemType fromString(String text) {
    for (SlideItemType b : SlideItemType.values()) {
      if (b.ttype.equalsIgnoreCase(text)) {
        return b;
      }
    }
    return null;
  }

  public String getType() {
    return ttype;
  }

  public String toString() {
    return ttype;
  }
}
