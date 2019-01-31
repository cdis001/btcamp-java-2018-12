package ch22.a;

import java.io.File;

public class Test07 {
  public static void main(String[] args) throws Exception {
    
    File file = new File("temp2/a/b/c/test.txt");
    
    File dir = file.getParentFile();
    
    if(dir.mkdirs()) { 
      System.out.println("디렉토리 생성 성공!");
    } else {
      System.out.println("디렉토리 생성 실패");
    }
    
    if (file.createNewFile()) {
      System.out.println("파일 생성 성공!");
    } else {
      System.out.println("파일 생성 실패");
    }
    
  }
}
