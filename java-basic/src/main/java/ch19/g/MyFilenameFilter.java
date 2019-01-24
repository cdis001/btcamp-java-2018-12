package ch19.g;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilenameFilter implements FilenameFilter{

  @Override
  public boolean accept(File dir, String name) {
    System.out.println("필터 확인중: " + name);
    if (name.endsWith(".txt"))
      return true;
    else
      return false;
  }

}
