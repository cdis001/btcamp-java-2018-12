//bin 폴더를 삭제하라!
package ch22.a;

import java.io.File;

public class Test13 {
  public static void main(String[] args) throws Exception {

    File file = new File("bin");

    remove(file);
    System.out.println("삭제 완료!");
  }
  static void remove(File dir) {
    File[] files = dir.listFiles();
    
    for(File file : files) {
    if(file.isFile()) { 
    file.delete();
    } else {
      remove(file);
    }
    }
    dir.delete();
  }
}
