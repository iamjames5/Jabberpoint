package com.nhlstenden.JabberPoint.SlideItemManagement;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class BitMapItemTest {

  @Test
  public void testConstructor_withValidFile_shouldCreateBitMapItemWithBufferedImage() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    BitMapItem bitmapItem = new BitMapItem(1, "valid/test.png");

    assertNotNull(bitmapItem);
    assertEquals(1, bitmapItem.getLevel());
    assertEquals("valid/test.png", bitmapItem.getName());
    assertEquals("", outContent.toString());
    System.setOut(System.out);
    assertEquals("", outContent.toString());
  }

  @Test
  public void testToString_WithName_shouldBeEqual() {
    BitMapItem bitmapItem = new BitMapItem(1, "test.png");
    String expected = "BitmapItem[1,test.png]";
    assertEquals(expected, bitmapItem.toString());
  }

  @Test
  public void testGetName_withValidName_shouldReturnName() {
    String expectedName = "test.png";
    BitMapItem bitmapItem = new BitMapItem(1, expectedName);
    String actualName = bitmapItem.getName();
    assertEquals(expectedName, actualName);
  }
  @Test
  public void testGetName_withEmptyName_shouldReturnEmptyString() {
    BitMapItem bitmapItem = new BitMapItem(1, "");
    String actualName = bitmapItem.getName();
    assertEquals("", actualName);
  }
}
