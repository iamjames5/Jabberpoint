package com.nhlstenden.JabberPoint.slideViewer;

import com.nhlstenden.JabberPoint.controller.KeyController;
import com.nhlstenden.JabberPoint.controller.MenuController;
import com.nhlstenden.JabberPoint.presentation.Presentation;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 * The application window for a slideviewcomponent
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class SlideViewerFrame extends JFrame {
  public static final int WIDTH = 1200;
  public static final int HEIGHT = 737;
  private static final long serialVersionUID = 3227L;
  private static final String JABTITLE = "Jabberpoint 1.6 - OU";

  public SlideViewerFrame(String title, Presentation presentation) {
    super(title);
    SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, this);
    presentation.setShowView(slideViewerComponent);
    setupWindow(slideViewerComponent, presentation);
  }

  // Setup GUI
  public void setupWindow(SlideViewerComponent slideViewerComponent, Presentation presentation) {
    setTitle(JABTITLE);
    addWindowListener(
        new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        });
    getContentPane().add(slideViewerComponent);
    addKeyListener(new KeyController(presentation)); // add a controller
    setMenuBar(new MenuController(this, presentation)); // add another controller
    setSize(new Dimension(WIDTH, HEIGHT)); // Same sizes as Slide has.
    setVisible(true);
  }
}
