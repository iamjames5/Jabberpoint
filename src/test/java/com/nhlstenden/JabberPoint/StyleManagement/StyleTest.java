package com.nhlstenden.JabberPoint.StyleManagement;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StyleTest {
    private Style basicStyle;
    @BeforeEach
    public void setup(){
        basicStyle = new BasicStyle(0, Color.BLACK, "Helvetica", 30, 20);
    }

    @Test
    public void testCreatStyle_BasicStyle_shouldBeExcept(){
        String except = "Creating style -- Indent: 0, Font: Helvetica, Color: BLACK, FontSize: 30, Leading: 20\n";
        assertStyleOutput(basicStyle, except);
    }
    @Test
    public void testCreatStyle_setFontStyle_shouldBeExcept(){
        Style colorStyle = new ColorDecorator(basicStyle, Color.BLUE);
        Style fontSizeStyle = new FontSizeDecorator(colorStyle, 45);
        Style fontStyle = new FontDecorator(fontSizeStyle, "Arial");

    String except =
        "Creating style -- Indent: 0, Font: Helvetica, Color: BLACK, FontSize: 30, Leading: 20\n"
            + "Applying Color: BLUE\n"
            + "Applying FontSize: 45\n"
            + "Applying Font: Arial\n";

    assertStyleOutput(fontStyle, except);
    }
    @Test
    public void testCreatStyle_setLeading_shouldBeExcept(){
        Style leadingStyle = new LeadingDecorator(basicStyle, 5);

        String except =
                "Creating style -- Indent: 0, Font: Helvetica, Color: BLACK, FontSize: 30, Leading: 20\n"
                        + "Applying Leading: 5\n";

        assertStyleOutput(leadingStyle, except);
    }
    private void assertStyleOutput(Style style, String expected) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        style.createStyle();
        String actual = outContent.toString();

        System.setOut(System.out);

        assertEquals(expected, actual);
    }
}
