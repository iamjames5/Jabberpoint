package com.nhlstenden.JabberPoint.slideItem;

import com.nhlstenden.JabberPoint.loader.XMLAccessor;
import com.nhlstenden.JabberPoint.presentation.Observer;
import com.nhlstenden.JabberPoint.presentation.Presentation;
import com.nhlstenden.JabberPoint.style.BasicStyle;
import com.nhlstenden.JabberPoint.style.StyleFactory;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 * A slide. This class has a drawing functionality.
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class Slide implements Observer {
  public static final int WIDTH = 1200;
  public static final int HEIGHT = 800;
  protected String title; // title is saved separately
  protected Vector<SlideItem> items; // slide items are saved in a Vector
  protected int slideNumber;

  public Slide(int slideNumber) {
    items = new Vector<SlideItem>();
    setSlideNumber(slideNumber);
  }

  // Add a slide item
  public void append(SlideItem anItem) {
    items.addElement(anItem);
  }

  public int getSlideNumber() {
    return slideNumber;
  }

  public void setSlideNumber(int slideNumber) {
    this.slideNumber = slideNumber;
  }

  // give the title of the slide
  public String getTitle() {
    return title;
  }

  // change the title of the slide
  public void setTitle(String newTitle) {
    title = newTitle;
  }

  // Create TextItem of String, and add the TextItem
  public void append(int level, String message) {
    append(new TextItem(level, message));
  }

  // give the  SlideItem
  public SlideItem getSlideItem(int number) {
    return items.elementAt(number);
  }

  // give all SlideItems in a Vector
  public Vector<SlideItem> getSlideItems() {
    return items;
  }

  // give the size of the Slide
  public int getSize() {
    return items.size();
  }

  // draw the slide
  public void draw(Graphics g, Rectangle area, ImageObserver view) {
    float scale = getScale(area);
    int y = area.y;
    // Title is handled separately
    SlideItem slideItem = new TextItem(0, getTitle());
    BasicStyle style = StyleFactory.getStyle(slideItem.getLevel());
    slideItem.draw(area.x, y, scale, g, style, view);
    y += slideItem.getBoundingBox(g, view, scale, style).height;
    for (int number = 0; number < getSize(); number++) {
      slideItem = getSlideItems().elementAt(number);
      style = StyleFactory.getStyle(slideItem.getLevel());
      slideItem.draw(area.x, y, scale, g, style, view);
      y += slideItem.getBoundingBox(g, view, scale, style).height;
    }
  }

  // Give the scale for drawing
  public float getScale(Rectangle area) {
    return Math.min(
        ((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
  }

  @Override
  public void update(Presentation presentation) {
    try {
      if (presentation.getSlideNumber() != getSlideNumber()) {
        return;
      }

      System.out.println("Slide update: " + getSlideNumber());
      Slide slide = new XMLAccessor().loadPartSlide(presentation.getFilename(), getSlideNumber());
      this.items = slide.getSlideItems();

    } catch (IOException ex) {
      JOptionPane.showMessageDialog(
          null, "IO Error: " + ex, "Presentation update error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
