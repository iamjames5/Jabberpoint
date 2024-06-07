package com.nhlstenden.JabberPoint;

import com.nhlstenden.JabberPoint.loader.XMLAccessor;
import com.nhlstenden.JabberPoint.presentation.Presentation;
import com.nhlstenden.JabberPoint.slideViewer.SlideViewerFrame;
import com.nhlstenden.JabberPoint.style.StyleFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

public class JabberPoint {

  protected static final String IOERR = "IO Error: ";
  protected static final String JABERR = "Jabberpoint Error ";
  protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

  public static void main(String[] argv) {

    StyleFactory.createStyles();
    Presentation presentation = new Presentation();
    new SlideViewerFrame(JABVERSION, presentation);

    try {
      String filename = "test.xml";
      if (argv.length > 0) {
        filename = argv[0];
      }

      File file = Paths.get(filename).toFile();
      new XMLAccessor().loadFile(presentation, file);
      presentation.setSlideNumber(0);
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
    }
  }
}
