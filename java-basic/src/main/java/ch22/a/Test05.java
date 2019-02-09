package ch22.a;

import java.io.File;

public class Test05 {
  public static void main(String[] args) throws Exception {
    
    File dir = new File("temp2/test.txt");
    if (dir.createNewFile()) {
      System.out.println("파일 생성 성공!");
    } else {
      System.out.println("파일 생성 실패");
    }
    
  }
}
