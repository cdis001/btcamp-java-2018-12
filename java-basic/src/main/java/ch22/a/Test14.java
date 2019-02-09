//bin/main 폴더를 뒤져서 모든 클래스 파일의 이름을 출력하라
package ch22.a;

import java.io.File;

public class Test14 {
  public static void main(String[] args) throws Exception {
    //'클래스' 이름을 출력할 때 패키지 이름을 포함해야 한다
    File file = new File("bin");

    name(file, "");

  }
  static void name(File dir, String packageName) {
    File[] files = dir.listFiles((File pathname) -> {
      if(pathname.isDirectory() ||
          (pathname.isFile() && pathname.getName().endsWith(".class")))
        return true;
      else
        return false;
  });
    for(File file : files) {
    if(file.isFile()) { 
      System.out.printf("%s%s\n", packageName, file.getName().replace(".class", ""));
    } else {
      name(file, packageName + file.getName() + ".");
    }
    }
  }
}
