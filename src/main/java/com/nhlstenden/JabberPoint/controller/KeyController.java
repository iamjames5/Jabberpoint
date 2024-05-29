package com.nhlstenden.JabberPoint.controller;

import com.nhlstenden.JabberPoint.presentation.Presentation;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This is the KeyController (KeyListener)
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class KeyController extends KeyAdapter {
  private final Presentation presentation; // Commands are given to the presentation

  public KeyController(Presentation p) {
    this.presentation = p;
  }

  public void keyPressed(KeyEvent keyEvent) {
    switch (keyEvent.getKeyCode()) {
      case KeyEvent.VK_PAGE_DOWN:
      case KeyEvent.VK_DOWN:
      case KeyEvent.VK_ENTER:
      case KeyEvent.VK_RIGHT:
      case '+':
        NextSlideCommand nextSlideCommand = new NextSlideCommand(presentation);
        nextSlideCommand.execute();
        break;
      case KeyEvent.VK_PAGE_UP:
      case KeyEvent.VK_UP:
      case KeyEvent.VK_LEFT:
      case '-':
        PrevSlideCommand prevSlideCommand = new PrevSlideCommand(presentation);
        prevSlideCommand.execute();
        break;
      case 'q':
      case 'Q':
        System.exit(0);
        break; // Probably never reached!!
      default:
        break;
    }

    presentation.notifyObservers();
  }
}
