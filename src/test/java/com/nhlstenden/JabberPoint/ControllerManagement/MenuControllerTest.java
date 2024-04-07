package com.nhlstenden.JabberPoint.ControllerManagement;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

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

      Menu menu = new Menu("Test Menu");
      Command testCommand = () -> System.out.println("Test command executed");

      menuController.addMenuItem(menu, "Test Item", testCommand);

      assertEquals(1, menu.getItemCount());
   }
}
