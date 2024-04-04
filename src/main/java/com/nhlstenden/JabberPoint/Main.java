package com.nhlstenden.JabberPoint;

import com.nhlstenden.JabberPoint.StyleManagement.BasicStyle;
import com.nhlstenden.JabberPoint.StyleManagement.Color;
import com.nhlstenden.JabberPoint.StyleManagement.ColorDecorator;
import com.nhlstenden.JabberPoint.StyleManagement.Style;

public class Main {
  public static void main(String[] args) {
    Style basicStyle = new BasicStyle(0, Color.BLACK, "Helvetica", 30, 20);
    Style colorStyle = new ColorDecorator(basicStyle, Color.RED);
    colorStyle.createStyle();
  }
}
