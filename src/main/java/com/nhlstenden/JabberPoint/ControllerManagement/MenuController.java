package com.nhlstenden.JabberPoint.ControllerManagement;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import javax.swing.*;

public class MenuController extends MenuBar {
  protected static final String TESTFILE = "test.xml";
  protected static final String SAVEFILE = "dump.xml";
  protected static final String IOEX = "IO Exception: ";
  protected static final String LOADERR = "Load Error";
  protected static final String SAVEERR = "Save Error";
  private final Frame parent;
  private final Presentation presentation;

  public MenuController(Frame frame, Presentation pres) {
    this.parent = frame;
    this.presentation = pres;
    setupMenu();
  }

  void setupMenu() {
    // Create the File menu
    Menu fileMenu = new Menu("File");
    addMenuItem(fileMenu, "Open", new FileCommand(presentation, (JFrame) parent));
    addMenuItem(fileMenu, "New", new NewCommand(presentation));
    addMenuItem(fileMenu, "Save", new SaveCommand(presentation, parent));
    fileMenu.addSeparator();
    addMenuItem(fileMenu, "Exit", new ExitCommand(presentation));

    // Create the View menu
    Menu viewMenu = new Menu("View");

    addMenuItem(viewMenu, "Next", new NextSlideCommand(presentation));
    addMenuItem(viewMenu, "Prev", new PrevSlideCommand(presentation));
    addMenuItem(viewMenu, "Go to", new GoToCommand(presentation));
    addMenuItem(viewMenu, "Reload", new ReloadCommand(presentation));

    // Create the Help menu
    Menu helpMenu = new Menu("Help");
    addMenuItem(helpMenu, "About", new AboutCommand());

    // Add menus to the MenuBar
    add(fileMenu);
    add(viewMenu);
    setHelpMenu(helpMenu);
  }

  void addMenuItem(Menu menu, String label, Command command) {
    MenuItem menuItem = new MenuItem(label, new MenuShortcut(label.charAt(0)));
    menuItem.addActionListener(e -> command.execute());
    menu.add(menuItem);
  }
}
