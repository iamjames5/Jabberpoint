package com.nhlstenden.JabberPoint.controller;

import com.nhlstenden.JabberPoint.command.*;
import com.nhlstenden.JabberPoint.presentation.Presentation;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class MenuController extends MenuBar {

  private final Frame parent;
  private final Presentation presentation;
  private final HashMap<String, Command> commandMap;

  public MenuController(Frame frame, Presentation pres) {
    this.parent = frame;
    this.presentation = pres;
    this.commandMap = new HashMap<>();
    initCommandMap();
    setupMenu();
  }

  private void initCommandMap() {
    // Initialize the command map
    commandMap.put("Open", new OpenCommand(presentation, (JFrame) parent));
    commandMap.put("New", new NewCommand(presentation));
    commandMap.put("Save", new SaveCommand(presentation, parent));
    commandMap.put("Exit", new ExitCommand(presentation));
    commandMap.put("Next", new NextSlideCommand(presentation));
    commandMap.put("Prev", new PrevSlideCommand(presentation));
    commandMap.put("Go to", new GoToCommand(presentation));
    commandMap.put("Reload", new ReloadCommand(presentation));
    commandMap.put("About", new AboutCommand(presentation, parent));
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
    addMenuItem(fileMenu, "Open");
    addMenuItem(fileMenu, "New");
    addMenuItem(fileMenu, "Save");
    fileMenu.addSeparator();
    addMenuItem(fileMenu, "Exit");

    return fileMenu;
  }

  public Menu setupViewMenu() {
    // Create the View menu
    Menu viewMenu = new Menu("View");
    addMenuItem(viewMenu, "Next");
    addMenuItem(viewMenu, "Prev");
    addMenuItem(viewMenu, "Go to");
    addMenuItem(viewMenu, "Reload");

    return viewMenu;
  }

  public Menu setupHelpMenu() {
    // Create the Help menu
    Menu helpMenu = new Menu("Help");
    addMenuItem(helpMenu, "About");

    return helpMenu;
  }

  public void addMenuItem(Menu menu, String label) {
    MenuItem menuItem = new MenuItem(label, new MenuShortcut(label.charAt(0)));
    menuItem.addActionListener(createMenuItemListener(label));
    menu.add(menuItem);
  }

  private ActionListener createMenuItemListener(String label) {
    return e -> {
      Command command = commandMap.get(label);
      if (command != null) {
        command.execute();
      }
    };
  }
}
