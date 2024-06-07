package com.nhlstenden.JabberPoint.command;

import static org.mockito.Mockito.*;

import com.nhlstenden.JabberPoint.loader.XMLAccessor;
import com.nhlstenden.JabberPoint.presentation.Presentation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OpenCommandTest {

  @Mock private Presentation presentation;
  @Mock private JFrame parentFrame;
  @Mock private XMLAccessor xmlAccessor;
  @InjectMocks private OpenCommand openCommand;

  @BeforeEach
  public void setUp() {

    MockitoAnnotations.openMocks(this);
    openCommand = spy(new OpenCommand(presentation, parentFrame));
    doNothing()
        .when(openCommand)
        .showMessageDialog(any(JFrame.class), anyString(), anyString(), anyInt());
  }

  @Test
  public void testOpenFileSuccess_assertTrue_returnsFileWithValidFileType() throws Exception {
    File mockFile = new File("test.xml");
    doReturn(mockFile).when(openCommand).createFileChooser();

    // Execute the method under test
    SwingUtilities.invokeAndWait(() -> openCommand.execute());

    // Verify that the presentation's properties are updated as expected
    verify(presentation).clear();
    verify(presentation).setSlideNumber(0);
  }

  @Test
  public void testOpenFileInvalidFileType_assertEquals_1() throws Exception {

    File mockFile = new File("JabberPoint.gif");
    doReturn(mockFile).when(openCommand).createFileChooser();

    SwingUtilities.invokeAndWait(() -> openCommand.execute());

    verify(presentation, never()).clear();
    verify(presentation, never()).setSlideNumber(0);
    verify(openCommand)
        .showMessageDialog(
            eq(parentFrame),
            eq("Error opening file: Invalid file type"),
            eq("Open Error"),
            eq(JOptionPane.ERROR_MESSAGE));
  }

  @Test
  public void testOpenFileIOException_assertEquals_1() throws IOException {
    XMLAccessor xmlAccessor = mock(XMLAccessor.class);
    doReturn(xmlAccessor).when(openCommand).createXMLAccessor();

    File mockFile = mock(File.class);
    doReturn("null.xml").when(mockFile).getName();
    doReturn(mockFile).when(openCommand).createFileChooser();
    doThrow(new FileNotFoundException("File not found"))
        .when(xmlAccessor)
        .loadFile(presentation, mockFile);

    openCommand.execute();

    verify(openCommand)
        .showMessageDialog(
            eq(parentFrame),
            eq("Error opening file: File not found"),
            eq("Open Error"),
            eq(JOptionPane.ERROR_MESSAGE));
  }
}
