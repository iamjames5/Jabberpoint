package com.nhlstenden.JabberPoint.style;

import java.awt.Color;
import java.awt.Font;

public class StyleFactory {
  protected static BasicStyle[] styles;

  public static BasicStyle getStyle(int level) {
    if (level >= styles.length) {
      level = styles.length - 1;
    }
    return styles[level];
  }

  public static void createStyles() {
    styles = new BasicStyle[5];
    BasicStyle basicStyle =
        new BasicStyle(0, Color.black, new Font("Helvetica", Font.PLAIN, 12), 12, 0);

    styles[0] =
        new ColorDecorator(
                Color.blue,
                new IndentDecorator(
                    20, new FontDecorator(40, new LeadingDecorator(10, basicStyle))))
            .applyStyle(
                new BasicStyle(0, Color.black, new Font("Helvetica", Font.PLAIN, 12), 12, 0));

    styles[1] =
        new ColorDecorator(
                Color.blue,
                new IndentDecorator(
                    10, new FontDecorator(40, new LeadingDecorator(20, basicStyle))))
            .applyStyle(
                new BasicStyle(0, Color.black, new Font("Helvetica", Font.PLAIN, 12), 12, 0));

    styles[2] =
        new ColorDecorator(
                Color.black,
                new IndentDecorator(
                    50, new FontDecorator(36, new LeadingDecorator(10, basicStyle))))
            .applyStyle(
                new BasicStyle(0, Color.black, new Font("Helvetica", Font.PLAIN, 12), 12, 0));

    styles[3] =
        new ColorDecorator(
                Color.black,
                new IndentDecorator(
                    70, new FontDecorator(30, new LeadingDecorator(10, basicStyle))))
            .applyStyle(
                new BasicStyle(0, Color.black, new Font("Helvetica", Font.PLAIN, 12), 12, 0));

    styles[4] =
        new ColorDecorator(
                Color.orange,
                new IndentDecorator(
                    90, new FontDecorator(24, new LeadingDecorator(10, basicStyle))))
            .applyStyle(
                new BasicStyle(0, Color.black, new Font("Helvetica", Font.PLAIN, 12), 12, 0));
  }
}
