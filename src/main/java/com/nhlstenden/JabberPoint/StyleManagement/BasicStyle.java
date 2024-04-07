package com.nhlstenden.JabberPoint.StyleManagement;

import java.awt.Color;
import java.awt.Font;

public class BasicStyle extends StyleDecorator {

  public BasicStyle(Style... decorators) {
    for (Style decorator : decorators) {
      decorator.applyStyle(this);
    }
  }

  public BasicStyle(BasicStyle baseStyle, Style... decorators) {
    // copy the base style
    indent = baseStyle.indent;
    color = baseStyle.color;
    font = baseStyle.font;
    fontSize = baseStyle.fontSize;
    leading = baseStyle.leading;

    // apply base style to this style
    for (Style decorator : decorators) {
      decorator.applyStyle(this);
    }
  }

  public static void createStyles() {
    styles = new BasicStyle[5];
    styles[0] =
        new BasicStyle(
            new IndentDecorator(0),
            new ColorDecorator(Color.RED),
            new FontDecorator(48),
            new LeadingDecorator(20));

    styles[1] =
        new BasicStyle(
            new IndentDecorator(20),
            new ColorDecorator(Color.blue),
            new FontDecorator(40),
            new LeadingDecorator(10));

    styles[2] =
        new BasicStyle(
            new IndentDecorator(50),
            new ColorDecorator(Color.black),
            new FontDecorator(36),
            new LeadingDecorator(10));

    styles[3] =
        new BasicStyle(
            new IndentDecorator(70),
            new ColorDecorator(Color.black),
            new FontDecorator(30),
            new LeadingDecorator(10));

    styles[4] =
        new BasicStyle(
            new IndentDecorator(90),
            new ColorDecorator(Color.orange),
            new FontDecorator(24),
            new LeadingDecorator(10));
  }

  public static BasicStyle getStyle(int level) {
    if (level >= styles.length) {
      level = styles.length - 1;
    }
    return styles[level];
  }

  @Override
  public BasicStyle applyStyle(BasicStyle baseStyle) {
    return baseStyle;
  }

  public String toString() {
    String str =
        "Indent: "
            + indent
            + ", Color: "
            + color
            + ", Leading: "
            + leading
            + ", FontSize: "
            + fontSize;

    if (font != null) {
      str += ", Font: " + font.getFontName() + ", FontStyle: " + font.getStyle();
    }

    return str;
  }

  public Font getFont(float scale) {
    return font.deriveFont(fontSize * scale);
  }
}
