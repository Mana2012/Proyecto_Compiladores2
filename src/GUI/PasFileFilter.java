/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import javax.swing.filechooser.FileFilter;



/**
 * A class that implements the Java FileFilter interface.
 */
public class PasFileFilter extends FileFilter {

  public boolean accept(File f) {
    if (f.isDirectory())
      return true;
    String s = f.getName();
    int i = s.lastIndexOf('.');

    if (i > 0 && i < s.length() - 1)
      if (s.substring(i + 1).toLowerCase().equals("pas"))
        return true;

    return false;
  }

  public String getDescription() {
    return "*.pas";
  }
}
