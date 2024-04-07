package com.nhlstenden.JabberPoint.SlideItemManagement;

import com.nhlstenden.JabberPoint.StyleManagement.BasicStyle;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * De klasse voor een Bitmap item
 *
 * <p>Bitmap items have the responsibility to draw themselves.
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class BitMapItem extends SlideItem {
  protected static final String FILE = "File ";
  protected static final String NOTFOUND = " not found";
  private final String imageName;
  private BufferedImage bufferedImage;

  // level is equal to item-level; name is the name of the file with the Image
  public BitMapItem(int level, String name) {
    super(level);
    imageName = name;
    try {
      bufferedImage = ImageIO.read(new File(imageName));
    } catch (IOException e) {
      System.err.println(FILE + imageName + NOTFOUND);
    }
  }

  // An empty bitmap-item
  public BitMapItem() {
    this(0, null);
  }

  public BufferedImage getBufferedImage() {
    return bufferedImage;
  }

  // give the filename of the image
  public String getName() {
    return imageName;
  }

  // give the  bounding box of the image
  public Rectangle getBoundingBox(
      Graphics g, ImageObserver observer, float scale, BasicStyle myStyle) {
    if (bufferedImage == null) {
      return new Rectangle(0, 0, 0, 0);
    }
    return new Rectangle(
        (int) (myStyle.getIndent() * scale),
        0,
        (int) (bufferedImage.getWidth(observer) * scale),
        ((int) (myStyle.getLeading() * scale)) + (int) (bufferedImage.getHeight(observer) * scale));
  }

  // draw the image
  public void draw(
      int x, int y, float scale, Graphics g, BasicStyle myStyle, ImageObserver observer) {
    if (bufferedImage == null) {
      return;
    }
    int width = x + (int) (myStyle.getIndent() * scale);
    int height = y + (int) (myStyle.getLeading() * scale);
    g.drawImage(
        bufferedImage,
        width,
        height,
        (int) (bufferedImage.getWidth(observer) * scale),
        (int) (bufferedImage.getHeight(observer) * scale),
        observer);
  }

  public String toString() {
    return "BitmapItem[" + getLevel() + "," + imageName + "]";
  }
}
