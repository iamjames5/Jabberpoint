package com.nhlstenden.JabberPoint.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.nhlstenden.JabberPoint.presentation.Presentation;

import javax.swing.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class MenuControllerTest {

  @Test
  public void testSetupMenu_assertEquals_5() {
    JFrame frame = new JFrame();
    Presentation presentation = new Presentation();

    MenuController menuController = new MenuController(frame, presentation);

    menuController.setupMenu();

    assertEquals(5, menuController.getMenuCount());
  }

  @Test
  public void testAddMenuItem_assertEquals_1() {
    JFrame frame = new JFrame();
    Presentation presentation = new Presentation();

    MenuController menuController = new MenuController(frame, presentation);

    Menu menu = new Menu("File");
    Command testCommand = new Command(presentation) {
      @Override
      public void execute() {
        // Do nothing
      }
    };

    menuController.addMenuItem(menu, "Test Item", testCommand);

    assertEquals(1, menu.getItemCount());
  }
}
