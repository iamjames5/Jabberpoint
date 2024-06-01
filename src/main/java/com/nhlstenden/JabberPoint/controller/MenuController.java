package com.nhlstenden.JabberPoint.controller;

import com.nhlstenden.JabberPoint.command.*;
import com.nhlstenden.JabberPoint.presentation.Presentation;
import java.awt.*;
import javax.swing.*;

public class MenuController extends MenuBar {

  private final Frame parent;
  private final Presentation presentation;

  public MenuController(Frame frame, Presentation pres) {
    this.parent = frame;
    this.presentation = pres;
    setupMenu();
  }

  public void setupMenu() {
    // Add menus to the MenuBar
    add(setupFileMenu());
    add(setupViewMenu());
    setHelpMenu(setupHelpMenu());
  }

  public Menu setupFileMenu() {
    // Create the File menu
    Menu fileMenu = new Menu("File");
    addMenuItem(fileMenu, "Open", new OpenCommand(presentation, (JFrame) parent));
    addMenuItem(fileMenu, "New", new NewCommand(presentation));
    addMenuItem(fileMenu, "Save", new SaveCommand(presentation, parent));
    fileMenu.addSeparator();
    addMenuItem(fileMenu, "Exit", new ExitCommand(presentation));

    return fileMenu;
  }

  public Menu setupViewMenu() {
    // Create the View menu
    Menu viewMenu = new Menu("View");
    addMenuItem(viewMenu, "Next", new NextSlideCommand(presentation));
    addMenuItem(viewMenu, "Prev", new PrevSlideCommand(presentation));
    addMenuItem(viewMenu, "Go to", new GoToCommand(presentation));
    addMenuItem(viewMenu, "Reload", new ReloadCommand(presentation));

    return viewMenu;
  }

  public Menu setupHelpMenu() {
    // Create the Help menu
    Menu helpMenu = new Menu("Help");
    addMenuItem(helpMenu, "About", new AboutCommand(presentation));

    return helpMenu;
  }

  public void addMenuItem(Menu menu, String label, Command command) {
    MenuItem menuItem = new MenuItem(label, new MenuShortcut(label.charAt(0)));
    menuItem.addActionListener(e -> command.execute());
    menu.add(menuItem);
  }
}
