package com.nhlstenden.JabberPoint.LoaderManagement;

import com.nhlstenden.JabberPoint.PresentationManagement.Presentation;
import java.io.File;
import java.io.IOException;

/**
 * Een Accessor maakt het mogelijk om gegevens voor een presentatie te lezen of te schrijven.
 *
 * <p>Niet-abstracte subklassen moeten de load en de save methode implementeren.
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public abstract class Accessor {
  public static final String DEMO_NAME = "Demonstration presentation";
  public static final String DEFAULT_EXTENSION = ".xml";

  public Accessor() {}

  public static Accessor getDemoAccessor() {
    return new DemoAccessor();
  }

  public abstract void loadFile(Presentation p, File fn) throws IOException;

  public abstract void saveFile(Presentation p, File fn) throws IOException;
}
