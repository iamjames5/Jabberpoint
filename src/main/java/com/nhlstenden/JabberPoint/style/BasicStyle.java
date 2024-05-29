package com.nhlstenden.JabberPoint.style;

import java.awt.Color;
import java.awt.Font;

public class BasicStyle extends StyleDecorator {
  protected static BasicStyle[] styles; // de styles

  public BasicStyle(Style decoratedStyle) {
    super(decoratedStyle);
  }

  public static void createStyles() {
    styles = new BasicStyle[5];

    Style basicStyleImplement = new BasicStyleImplement();
    BasicStyle bs = new BasicStyle(basicStyleImplement);

    Style s1 = new BasicStyle(new LeadingDecorator(10,
            new FontDecorator(40,
                    new ColorDecorator(Color.blue,
                            new IndentDecorator(20, basicStyleImplement)
                    )
            )
    ));
    styles[0] = s1.applyStyle(bs);

    styles[1] = (new BasicStyle(new LeadingDecorator(20,
            new FontDecorator(40,
                    new ColorDecorator(Color.blue,
                            new IndentDecorator(10, basicStyleImplement)
                    )
            )
    ))).applyStyle(new BasicStyle(basicStyleImplement));

    styles[2] = (new BasicStyle(new LeadingDecorator(10,
            new FontDecorator(36,
                    new ColorDecorator(Color.black,
                            new IndentDecorator(50, basicStyleImplement)
                    )
            )
    ))).applyStyle(new BasicStyle(basicStyleImplement));

    styles[3] = (new BasicStyle(new LeadingDecorator(10,
            new FontDecorator(30,
                    new ColorDecorator(Color.black,
                            new IndentDecorator(70, basicStyleImplement)
                    )
            )
    ))).applyStyle(new BasicStyle(basicStyleImplement));

    styles[4] = (new BasicStyle(new LeadingDecorator(10,
            new FontDecorator(24,
                    new ColorDecorator(Color.orange,
                            new IndentDecorator(90, basicStyleImplement)
                    )
            )
    ))).applyStyle(new BasicStyle(basicStyleImplement));
  }

  public static BasicStyle getStyle(int level) {
    if (level >= styles.length) {
      level = styles.length - 1;
    }
    return styles[level];
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
