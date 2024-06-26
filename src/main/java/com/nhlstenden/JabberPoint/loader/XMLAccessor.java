package com.nhlstenden.JabberPoint.loader;

import com.nhlstenden.JabberPoint.presentation.Presentation;
import com.nhlstenden.JabberPoint.slideItem.BitMapItem;
import com.nhlstenden.JabberPoint.slideItem.Slide;
import com.nhlstenden.JabberPoint.slideItem.SlideItem;
import com.nhlstenden.JabberPoint.slideItem.SlideItemCreator;
import com.nhlstenden.JabberPoint.slideItem.TextItem;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * XMLAccessor, reads and writes XML files
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class XMLAccessor extends Accessor {

  /** Default API to use. */
  protected static final String DEFAULT_API_TO_USE = "dom";

  /** namen van xml tags of attributen */
  protected static final String SHOWTITLE = "showtitle";

  protected static final String SLIDETITLE = "title";
  protected static final String SLIDE = "slide";
  protected static final String ITEM = "item";
  protected static final String LEVEL = "level";
  protected static final String KIND = "kind";
  protected static final String TEXT = "text";
  protected static final String IMAGE = "image";

  /** tekst van messages */
  protected static final String PCE = "Parser Configuration Exception";

  protected static final String UNKNOWNTYPE = "Unknown Element type";
  protected static final String NFE = "Number Format Exception";

  public String getTitle(Element element, String tagName) {
    NodeList titles = element.getElementsByTagName(tagName);
    return titles.item(0).getTextContent();
  }

  public Document loadFileDocument(File file)
      throws IOException, SAXException, ParserConfigurationException {
    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    return builder.parse(file); // Create a JDOM document
  }

  public void loadFile(Presentation presentation, File file) throws IOException {
    int slideNumber, itemNumber, max = 0, maxItems = 0;
    try {
      Document document = loadFileDocument(file);
      Element doc = document.getDocumentElement();
      presentation.setTitle(getTitle(doc, SHOWTITLE));
      presentation.setFilename(file);

      NodeList slides = doc.getElementsByTagName(SLIDE);
      max = slides.getLength();
      for (slideNumber = 0; slideNumber < max; slideNumber++) {
        Element xmlSlide = (Element) slides.item(slideNumber);
        Slide slide = new Slide(slideNumber);
        slide.setTitle(getTitle(xmlSlide, SLIDETITLE));
        presentation.append(slide);

        NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
        maxItems = slideItems.getLength();
        for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
          Element item = (Element) slideItems.item(itemNumber);
          loadSlideItem(slide, item);
        }
      }
    } catch (IOException iox) {
      System.err.println(iox);
    } catch (SAXException sax) {
      System.err.println(sax.getMessage());
    } catch (ParserConfigurationException pcx) {
      System.err.println(PCE);
    }
  }

  public Slide loadPartSlide(File file, int targetSlideNumber) throws IOException {
    Slide slide = null;
    int slideNumber, itemNumber, max = 0, maxItems = 0;
    try {
      Document document = loadFileDocument(file);
      Element doc = document.getDocumentElement();

      NodeList slides = doc.getElementsByTagName(SLIDE);
      max = slides.getLength();
      for (slideNumber = 0; slideNumber < max; slideNumber++) {
        if (targetSlideNumber != slideNumber) {
          continue;
        }

        Element xmlSlide = (Element) slides.item(slideNumber);
        slide = new Slide(slideNumber);
        slide.setTitle(getTitle(xmlSlide, SLIDETITLE));

        NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
        maxItems = slideItems.getLength();
        for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
          Element item = (Element) slideItems.item(itemNumber);
          loadSlideItem(slide, item);
        }

        break;
      }

      if (slide == null) {
        throw new IOException("Slide not found");
      }
    } catch (IOException iox) {
      System.err.println(iox);
    } catch (SAXException sax) {
      System.err.println(sax.getMessage());
    } catch (ParserConfigurationException pcx) {
      System.err.println(PCE);
    }

    return slide;
  }

  public void loadSlideItem(Slide slide, Element item) {
    int level = 1; // default
    NamedNodeMap attributes = item.getAttributes();
    String leveltext = attributes.getNamedItem(LEVEL).getTextContent();
    if (leveltext != null) {
      try {
        level = Integer.parseInt(leveltext);
      } catch (NumberFormatException x) {
        System.err.println(NFE);
      }
    }
    String type = attributes.getNamedItem(KIND).getTextContent();

    SlideItem slideitem = SlideItemCreator.createSlideItem(type, level, item.getTextContent());
    if (slideitem == null) {
      System.err.println(UNKNOWNTYPE);
    } else {
      slide.append(slideitem);
    }
  }

  public void saveFile(Presentation presentation, File filename) throws IOException {
    PrintWriter out = new PrintWriter(new FileWriter(filename));
    out.println("<?xml version=\"1.0\"?>");
    out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
    out.println("<presentation>");
    out.print("<showtitle>");
    out.print(presentation.getTitle());
    out.println("</showtitle>");
    for (int slideNumber = 0; slideNumber < presentation.getSize(); slideNumber++) {
      Slide slide = presentation.getSlide(slideNumber);
      out.println("<slide>");
      out.println("<title>" + slide.getTitle() + "</title>");
      Vector<SlideItem> slideItems = slide.getSlideItems();
      for (int itemNumber = 0; itemNumber < slideItems.size(); itemNumber++) {
        SlideItem slideItem = slideItems.elementAt(itemNumber);
        out.print("<item kind=");
        if (slideItem instanceof TextItem) {
          out.print("\"text\" level=\"" + slideItem.getLevel() + "\">");
          out.print(((TextItem) slideItem).getText());
        } else {
          if (slideItem instanceof BitMapItem) {
            out.print("\"image\" level=\"" + slideItem.getLevel() + "\">");
            out.print(((BitMapItem) slideItem).getName());
          } else {
            System.out.println("Ignoring " + slideItem);
          }
        }
        out.println("</item>");
      }
      out.println("</slide>");
    }
    out.println("</presentation>");
    out.close();
  }
}
