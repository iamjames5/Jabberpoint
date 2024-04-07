package com.nhlstenden.JabberPoint.StyleManagement;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.awt.Font;
import org.junit.jupiter.api.*;

public class StyleTest {

  BasicStyle baseStyle;

  @BeforeEach
  public void setup() {
    baseStyle = new BasicStyle();
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
        new BasicStyle(baseStyle, new FontDecorator(new Font("Arial", Font.BOLD, 40)));

    assertEquals(new Font("Arial", Font.BOLD, 40), newStyle.getFont());
  }

  @Test
  public void testCreatStyle_setLeading_shouldBeExpect() {
    BasicStyle newStyle = new BasicStyle(baseStyle, new LeadingDecorator(40));

    assertEquals(40, newStyle.getLeading());
  }

  @Test
  public void testCreatStyle_setIndent_shouldBeExpect() {
    BasicStyle newStyle = new BasicStyle(baseStyle, new IndentDecorator(40));

    assertEquals(40, newStyle.getIndent());
  }

  @Test
  public void testCreatStyle_setColor_shouldBeExpect() {
    BasicStyle newStyle = new BasicStyle(baseStyle, new ColorDecorator(Color.RED));

    assertEquals(Color.RED, newStyle.getColor());
  }

  @Test
  public void testCreatStyle_setMultipleStyle_shouldBeExpect() {
    BasicStyle newStyle =
        new BasicStyle(baseStyle, new FontDecorator(new Font("Arial", Font.BOLD, 40)));
    newStyle = new BasicStyle(newStyle, new LeadingDecorator(40));
    newStyle = new BasicStyle(newStyle, new IndentDecorator(40));
    newStyle = new BasicStyle(newStyle, new ColorDecorator(Color.RED));

    assertEquals(new Font("Arial", Font.BOLD, 40), newStyle.getFont());
    assertEquals(40, newStyle.getLeading());
    assertEquals(40, newStyle.getIndent());
    assertEquals(Color.RED, newStyle.getColor());
  }
}
