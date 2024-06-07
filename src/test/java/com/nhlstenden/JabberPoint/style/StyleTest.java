package com.nhlstenden.JabberPoint.style;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.awt.Font;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StyleTest {

  BasicStyle basicStyle;
  Style style;

  @BeforeEach
  public void setup() {
    style = new BasicStyle(0, Color.BLACK, new Font("Helvetica", Font.PLAIN, 30), 30, 0);
    basicStyle = new BasicStyle(0, Color.BLACK, new Font("Helvetica", Font.PLAIN, 30), 30, 0);
  }

  @Test
  public void testBaseStyle_Getters_ShouldReturnCorrectValues() {
    assertEquals(Color.BLACK, basicStyle.getColor());
    assertEquals(new Font("Helvetica", Font.PLAIN, 30), basicStyle.getFont());
  }

  @Test
  public void testBaseStyle_GetFontWithScale_ShouldReturnScaledFont() {
    float scale = 10f;
    Font scaledFont = basicStyle.getFont(scale);
    assertEquals(basicStyle.getFont().getSize() * scale, scaledFont.getSize(), 0.001);
  }

  @Test
  public void testCreateStyle_SetFontStyle_ShouldApplyFontDecorator() {
    BasicStyle newStyle = new FontDecorator(40, style).applyStyle(basicStyle);
    assertEquals(new Font("Helvetica", Font.BOLD, 40), newStyle.getFont());
  }

  @Test
  public void testCreateStyle_SetLeading_ShouldApplyLeadingDecorator() {
    BasicStyle newStyle = new LeadingDecorator(40, style).applyStyle(basicStyle);
    assertEquals(40, newStyle.getLeading());
  }

  @Test
  public void testCreateStyle_SetIndent_ShouldApplyIndentDecorator() {
    BasicStyle newStyle = new IndentDecorator(40, style).applyStyle(basicStyle);
    assertEquals(40, newStyle.getIndent());
  }

  @Test
  public void testCreateStyle_SetColor_ShouldApplyColorDecorator() {
    BasicStyle newStyle = new ColorDecorator(Color.RED, style).applyStyle(basicStyle);
    assertEquals(Color.RED, newStyle.getColor());
  }

  @Test
  public void testCreateStyle_SetMultipleStyles_ShouldApplyAllDecorators() {
    BasicStyle newStyle =
        new ColorDecorator(
                Color.RED,
                new IndentDecorator(40, new LeadingDecorator(40, new FontDecorator(40, style))))
            .applyStyle(basicStyle);

    assertEquals(new Font("Helvetica", Font.BOLD, 40), newStyle.getFont());
    assertEquals(40, newStyle.getLeading());
    assertEquals(40, newStyle.getIndent());
    assertEquals(Color.RED, newStyle.getColor());
  }
}
