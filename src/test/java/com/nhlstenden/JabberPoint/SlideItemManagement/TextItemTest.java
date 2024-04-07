package com.nhlstenden.JabberPoint.SlideItemManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TextItemTest {
  @Test
  public void testConstructor_withValidText_shouldCreateTextItem() {
    TextItem textItem = new TextItem(1, "Valid text");

    assertNotNull(textItem);
    assertEquals(1, textItem.getLevel());
    assertEquals("Valid text", textItem.getText());
  }

  @Test
  public void testConstructor_withEmptyText_shouldCreateTextItemWithEmptyText() {
    TextItem textItem = new TextItem(1, "");

    assertNotNull(textItem);
    assertEquals(1, textItem.getLevel());
    assertEquals("", textItem.getText());
  }

  @Test
  public void testConstructor_withNullText_shouldCreateTextItemWithEmptyText() {
    TextItem textItem = new TextItem(1, null);

    assertNotNull(textItem);
    assertEquals(1, textItem.getLevel());
    assertEquals("", textItem.getText());
  }

  @Test
  public void testToString_WithText_shouldReturnCorrectStringRepresentation() {
    TextItem textItem = new TextItem(1, "Test text");
    String result = textItem.toString();

    assertEquals("TextItem[1,Test text]", result);
  }

  @Test
  public void testToString_WithoutText_shouldReturnCorrectStringRepresentation() {
    TextItem textItem = new TextItem(1, null);
    String result = textItem.toString();

    assertEquals("TextItem[1,]", result);
  }
}
