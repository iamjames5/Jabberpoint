package com.nhlstenden.JabberPoint.ControllerManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.nhlstenden.JabberPoint.LoaderManagement.Accessor;
import com.nhlstenden.JabberPoint.LoaderManagement.XMLAccessor;
import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OpenCommandTest {

  private Presentation presentation;
  private JFrame parentFrame;
  private OpenCommand openCommand;

  @BeforeEach
  public void setUp() {
    presentation = new Presentation();
    parentFrame = new JFrame();
    openCommand = new OpenCommand(presentation, parentFrame);
  }

  @Test
  public void testOpenFileSuccess_assertTrue_returnsFileWithValidFileType() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setSelectedFile(new File("test.xml"));
    parentFrame.setVisible(true);

    Accessor xmlAccessor =
        new XMLAccessor() {
          @Override
          public void loadFile(Presentation presentation, File file) throws IOException {
            assertTrue(file.getName().endsWith(".xml"));
          }
        };

    openCommand.execute();
  }

  @Test
  public void testOpenFileInvalidFileType_assertEquals_1() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setSelectedFile(new File("test.txt"));
    parentFrame.setVisible(true);

    openCommand.execute();

    assertEquals(1, JOptionPane.getFrameForComponent(parentFrame).getComponentCount());
  }

  @Test
  public void testOpenFileIOException_assertEquals_1() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setSelectedFile(new File("test.xml"));
    parentFrame.setVisible(true);

    Accessor xmlAccessor =
        new XMLAccessor() {
          @Override
          public void loadFile(Presentation presentation, File file) throws IOException {
            throw new IOException("IO error");
          }
        };

    openCommand.execute();

    assertEquals(1, JOptionPane.getFrameForComponent(parentFrame).getComponentCount());
  }
}
