package com.nhlstenden.JabberPoint.ControllerManagement;

import static org.junit.jupiter.api.Assertions.*;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import org.junit.jupiter.api.Test;

public class FileCommandTest {

   @Test
   public void testOpenFile_assertEquals_0() {
      Presentation mockPresentation = new Presentation();
      MockFrame mockFrame = new MockFrame();

      FileCommand fileCommand = new FileCommand(mockPresentation, mockFrame);
      fileCommand.execute();

      fileCommand.openFile();

      assertEquals(0, mockPresentation.getSlideNumber());
   }

   @Test
   public void testSaveFile_assertTrue_returnsTrue() {
      Presentation mockPresentation = new Presentation();
      MockFrame mockFrame = new MockFrame();

      FileCommand fileCommand = new FileCommand(mockPresentation, mockFrame);
      fileCommand.execute();

      File tempFile;
      try {
         tempFile = File.createTempFile("test", ".xml");
      } catch (IOException e) {
         fail("Failed to create temporary file");
         return;
      }

      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setSelectedFile(tempFile);
      fileCommand.saveFile();

      assertTrue(tempFile.exists());
      tempFile.delete();
   }

   private static class MockFrame extends JFrame {
      private JMenuBar mockMenuBar;

      @Override
      public void setJMenuBar(JMenuBar menuBar) {
         this.mockMenuBar = menuBar;
      }

      public JMenuBar getMockMenuBar() {
         return mockMenuBar;
      }
   }
}
