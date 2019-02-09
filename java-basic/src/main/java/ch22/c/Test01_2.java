package ch22.c;

import java.io.FileInputStream;

public class Test01_2 {
  public static void main(String[] args) {
    try {
      FileInputStream in = new FileInputStream("jls11.pdf");
      
      System.out.println("데이터 읽는 중...");
      
      long start = System.currentTimeMillis();
      
      byte[] buf = new byte[1000];
      int len = 0;
      
      while ((len = in.read(buf)) != -1) {

      }
      System.out.println();
      
      long end = System.currentTimeMillis();
      
      System.out.println(end - start);
      
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("출력완료!");
  }
}
