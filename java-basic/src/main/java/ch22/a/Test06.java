package ch22.a;

import java.io.File;

public class Test06 {
  public static void main(String[] args) throws Exception {
    
    File dir = new File("temp2/test.txt");
    if (dir.delete()) {
      System.out.println("파일 삭제 성공!");
    } else {
      System.out.println("파일 삭제 실패");
    }
    
  }
}
