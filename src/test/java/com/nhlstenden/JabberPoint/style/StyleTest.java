package com.nhlstenden.JabberPoint.style;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.awt.Font;
import org.junit.jupiter.api.*;

public class StyleTest {

  BasicStyle baseStyle;
  Style style;

  @BeforeEach
  public void setup() {
    style = new BasicStyleImplement();
    baseStyle = new BasicStyle(new BasicStyleImplement());
    baseStyle.setColor(Color.BLACK);
    baseStyle.setFontSize(30);
    baseStyle.setFont(new Font("Helvetica", Font.PLAIN, 30));
  }

  @Test
  public void testBasicStyle_BasicStyle_shouldBeEqual() {
    assertEquals(Color.BLACK, baseStyle.getColor());
    assertEquals(new Font("Helvetica", Font.PLAIN, 30), baseStyle.getFont());
  }

  @Test
  public void testBasicStyle_getFontWithScale_shouldBeEqual() {
    float scale = 10f;
    Font scaledFont = baseStyle.getFont(scale);
    assertEquals(baseStyle.getFont().getSize() * scale, scaledFont.getSize(), 0.001);
  }

  @Test
  public void testCreatStyle_setFontStyle_shouldBeExpect() {
    BasicStyle newStyle =
        new BasicStyle(new FontDecorator(40, new BasicStyleImplement())).applyStyle(baseStyle);

    assertEquals(new Font("Helvetica", Font.BOLD, 40), newStyle.getFont());
  }

  @Test
  public void testCreatStyle_setLeading_shouldBeExpect() {
//    BasicStyle newStyle = new BasicStyle(baseStyle, new LeadingDecorator(40));
    BasicStyle newStyle = new BasicStyle(new LeadingDecorator(40, style)).applyStyle(baseStyle);

    assertEquals(40, newStyle.getLeading());
  }

  @Test
  public void testCreatStyle_setIndent_shouldBeExpect() {
//    BasicStyle newStyle = new BasicStyle(baseStyle, new IndentDecorator(40));

    BasicStyle newStyle = new BasicStyle(new IndentDecorator(40, style)).applyStyle(baseStyle);

    assertEquals(40, newStyle.getIndent());
  }

  @Test
  public void testCreatStyle_setColor_shouldBeExpect() {
//    BasicStyle newStyle = new BasicStyle(baseStyle, new ColorDecorator(Color.RED));

    BasicStyle newStyle = new BasicStyle(new ColorDecorator(Color.RED, style)).applyStyle(baseStyle);
    assertEquals(Color.RED, newStyle.getColor());
  }

  @Test
  public void testCreatStyle_setMultipleStyle_shouldBeExpect() {

    BasicStyle newStyle =
        new BasicStyle(new ColorDecorator(Color.RED,
            new IndentDecorator(40,
                new LeadingDecorator(40,
                    new FontDecorator(40, style)
                )
            )
        )).applyStyle(baseStyle);

    assertEquals(new Font("Helvetica", Font.BOLD, 40), newStyle.getFont());
    assertEquals(40, newStyle.getLeading());
    assertEquals(40, newStyle.getIndent());
    assertEquals(Color.RED, newStyle.getColor());
  }
}
