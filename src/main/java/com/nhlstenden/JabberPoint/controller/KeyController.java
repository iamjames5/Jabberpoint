package com.nhlstenden.JabberPoint.controller;

import com.nhlstenden.JabberPoint.command.Command;
import com.nhlstenden.JabberPoint.command.ExitCommand;
import com.nhlstenden.JabberPoint.command.NextSlideCommand;
import com.nhlstenden.JabberPoint.command.PrevSlideCommand;
import com.nhlstenden.JabberPoint.presentation.Presentation;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * This is the KeyController (KeyListener)
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class KeyController extends KeyAdapter {
  private final Presentation presentation; // Commands are given to the presentation

  private final HashMap<Integer, Command> commandMap;

  public KeyController(Presentation presentation) {
    this.presentation = presentation;
    this.commandMap = new HashMap<>();
    initializeCommands();
  }

  private void initializeCommands() {
    // Initialize the command map
    commandMap.put(KeyEvent.VK_PAGE_DOWN, new NextSlideCommand(presentation));
    commandMap.put(KeyEvent.VK_DOWN, new NextSlideCommand(presentation));
    commandMap.put(KeyEvent.VK_ENTER, new NextSlideCommand(presentation));
    commandMap.put(KeyEvent.VK_RIGHT, new NextSlideCommand(presentation));
    commandMap.put((int) '+', new NextSlideCommand(presentation));

    commandMap.put(KeyEvent.VK_PAGE_UP, new PrevSlideCommand(presentation));
    commandMap.put(KeyEvent.VK_UP, new PrevSlideCommand(presentation));
    commandMap.put(KeyEvent.VK_LEFT, new PrevSlideCommand(presentation));
    commandMap.put((int) '-', new PrevSlideCommand(presentation));

    commandMap.put(KeyEvent.VK_Q, new ExitCommand(presentation));
  }

  public void keyPressed(KeyEvent keyEvent) {
    Command command = commandMap.get(keyEvent.getKeyCode());
    if (command != null) {
      command.execute();
    }

    presentation.notifyObservers();
  }
}
