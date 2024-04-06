package com.nhlstenden.JabberPoint.PresentationObservableManagement;

import static org.junit.jupiter.api.Assertions.*;

import com.nhlstenden.JabberPoint.LoaderManagement.XMLAccessor;
import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import com.nhlstenden.JabberPoint.SlideItemManagement.Slide;
import com.nhlstenden.JabberPoint.SlideItemManagement.TextItem;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import org.junit.jupiter.api.*;

public class PresentationObservableTest {
  private Path tempFile;
  private Path tempDtd;

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
        });
  }

  @Test
  public void testLoadPresentation_TestSlideUpdateWhenPresentationChange_shouldBeUpdate() {
    Presentation p = new Presentation();

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

    assertDoesNotThrow(
        () -> {
          Files.write(tempFile, Collections.singletonList(content), Charset.defaultCharset());

          XMLAccessor xmlAccessor = new XMLAccessor();

          xmlAccessor.loadFile(p, tempFile.toFile());
          p.setSlideNumber(0);

          assertEquals(1, p.getSize());

          Slide slide = p.getSlide(0);
          assertEquals("An almost empty slide", slide.getTitle());
          assertEquals(1, slide.getSlideItems().size());

          TextItem item = (TextItem) slide.getSlideItems().get(0);
          assertEquals("444", item.getText());

          String newContent =
              "<?xml version=\"1.0\"?>\n"
                  + "<!DOCTYPE presentation SYSTEM \""
                  + tempDtd.getFileName()
                  + "\">"
                  + "<presentation>\n"
                  + "<showtitle>Test Presentation for Jabberpoint</showtitle>\n"
                  + "<slide>\n"
                  + "<title>An almost empty slide</title>\n"
                  + "<item kind=\"text\"  level=\"1\">666</item>\n"
                  + "</slide>\n"
                  + "</presentation>";

          Files.write(tempFile, Collections.singletonList(newContent), Charset.defaultCharset());

          p.notifyObservers();

          TextItem newItem = (TextItem) slide.getSlideItems().get(0);

          assertEquals("666", newItem.getText());
        });
  }
}
