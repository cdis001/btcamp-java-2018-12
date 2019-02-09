package ch22.c;

import java.io.FileOutputStream;

public class Test02_3 {
  public static void main(String[] args) {

    try (FileOutputStream out = new FileOutputStream("data.bin");
        BufferedOutputStream out2 = new BufferedOutputStream(out);) {
      
      System.out.println("데이터 쓰는 중...");
      
      long start = System.currentTimeMillis();
      
      int b;
      int count = 0;
      
      for (int i = 0; i < 1000000; i++) {
        out2.write(0x55);
      }
      out2.flush();
      
      System.out.println();
      
      long end = System.currentTimeMillis();
      
      System.out.println(end - start);
      System.out.println(count);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("출력완료!");
  }
}
