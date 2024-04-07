package com.nhlstenden.JabberPoint.SlideItemManagement;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BitMapItemTest {

    @Test
    public void testConstructor_withValidFile_shouldCreateBitMapItem() {
        BitMapItem bitmapItem = new BitMapItem(1, "test");

        assertNotNull(bitmapItem);
        assertEquals(1, bitmapItem.getLevel());
        assertEquals("test", bitmapItem.getName());
    }
    @Test
    public void testConstructor_withInvalidFile_shouldCreateBitMapItemWithNullBufferedImage() {
        BitMapItem bitmapItem = new BitMapItem(1, "invalid/test");

        assertNotNull(bitmapItem);

        assertEquals(1, bitmapItem.getLevel());
        assertEquals("invalid/test", bitmapItem.getName());

        assertNull(bitmapItem.getBufferedImage());
    }
}
