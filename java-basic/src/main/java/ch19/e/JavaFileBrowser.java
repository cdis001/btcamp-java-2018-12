package ch19.e;

import java.io.File;

public class JavaFileBrowser {
  File dir;
  
  public JavaFileBrowser(String path) {
    dir = new File(path);
  }
  
  public void list() {
    String[] filenames = dir.list();
    
    for (String filename : filenames) {
      System.out.println(filename);
    }
  }
}
