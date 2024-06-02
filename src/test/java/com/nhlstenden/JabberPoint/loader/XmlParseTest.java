package com.nhlstenden.JabberPoint.loader;

import static org.junit.jupiter.api.Assertions.*;

import com.nhlstenden.JabberPoint.presentation.Presentation;
import com.nhlstenden.JabberPoint.slidItem.Slide;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import org.junit.jupiter.api.*;

public class XmlParseTest {
  private Path tempFile;
  private Path tempDtd;

  // test load xml file
  @BeforeEach
  public void setup() {
    assertDoesNotThrow(
        () -> {
          // create temp file for testing
          tempFile = Files.createTempFile("TestTempFile", ".xml");
          tempDtd = Files.createTempFile("jabberpoint", ".dtd");

          // delete temp file on exit
          tempFile.toFile().deleteOnExit();
          tempDtd.toFile().deleteOnExit();

          // open the dtd file and write the tempfile
          Files.write(
              tempDtd,
              Collections.singletonList(
                  "<!ELEMENT showtitle (#PCDATA)>\n"
                      + //
                      "<!ELEMENT presentation (showtitle,slide+)>\n"
                      + //
                      "<!ELEMENT title (#PCDATA)>\n"
                      + //
                      "<!ELEMENT slide (title, item*)>\n"
                      + //
                      "<!ELEMENT item (#PCDATA)>\n"
                      + //
                      "<!ATTLIST item kind CDATA #REQUIRED>\n"
                      + //
                      "<!ATTLIST item level CDATA #REQUIRED>"),
              Charset.defaultCharset());

          String content =
              "<?xml version=\"1.0\"?>\n"
                  + "<!DOCTYPE presentation SYSTEM \""
                  + tempDtd.getFileName()
                  + "\">"
                  + "<presentation>\n"
                  + "<showtitle>Test Presentation for Jabberpoint</showtitle>\n"
                  + "<slide>\n"
                  + "<title>An almost empty slide</title>\n"
                  + "<item kind=\"text\"  level=\"1\">444</item>\n"
                  + "</slide>\n"
                  + "</presentation>";

          Files.write(tempFile, Collections.singletonList(content), Charset.defaultCharset());
        });
  }

  @Test
  public void testLoadXMLFile_LoadFromFile_shouldBeExcept() {
    // expect not exception throw
    assertDoesNotThrow(
        () -> {
          Presentation p = new Presentation();
          XMLAccessor xmlAccessor = new XMLAccessor();
          xmlAccessor.loadFile(p, tempFile.toFile());
          assertEquals(p.getTitle(), "Test Presentation for Jabberpoint");
          assertEquals(p.getSize(), 1);
        });
  }

  @Test
  public void testLoadXMLFile_PartSlide_shouldBeExcept() {
    String except = "An almost empty slide";

    // expect not exception throw
    assertDoesNotThrow(
        () -> {
          Slide slide = new XMLAccessor().loadPartSlide(tempFile.toFile(), 0);
          assertEquals(slide.getTitle(), except);
        });
  }
}
