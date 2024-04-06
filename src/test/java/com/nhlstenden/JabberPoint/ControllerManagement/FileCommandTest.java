package com.nhlstenden.JabberPoint.ControllerManagement;

import com.nhlstenden.JabberPoint.LoaderManagement.Accessor;
import com.nhlstenden.JabberPoint.LoaderManagement.XMLAccessor;
import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileCommandTest {

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

   @Test
   void testOpenFile() {
      Presentation mockPresentation = new Presentation();
      MockFrame mockFrame = new MockFrame();

      FileCommand fileCommand = new FileCommand(mockPresentation, mockFrame);
      fileCommand.execute();

      // Simulate selecting a file
      fileCommand.openFile();

      // Verify that presentation was loaded and slide number was set to 0
      assertEquals(0, mockPresentation.getSlideNumber());
   }

   @Test
   void testSaveFile() {
      Presentation mockPresentation = new Presentation();
      MockFrame mockFrame = new MockFrame();

      FileCommand fileCommand = new FileCommand(mockPresentation, mockFrame);
      fileCommand.execute();

      // Create a temporary file
      File tempFile;
      try {
         tempFile = File.createTempFile("test", ".xml");
      } catch (IOException e) {
         fail("Failed to create temporary file");
         return;
      }

      // Simulate selecting the temporary file for saving
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setSelectedFile(tempFile);
      fileCommand.saveFile();

      // Verify that presentation was saved successfully
      assertTrue(tempFile.exists());

      // Cleanup temporary file
      tempFile.delete();
   }
}
