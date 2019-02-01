package ch22.d;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.CharBuffer;

public class Test03_2 {
  public static void main(String[] args) {
    
    try(FileReader in = new FileReader("data.txt");
        BufferedReader in2 = new BufferedReader(in)) {

      System.out.println(in2.readLine());
      
      CharBuffer cbuf = CharBuffer.allocate(1024);
      int len = in.read(cbuf);
      
      System.out.println(len);
      
    }catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("출력완료");
  }
}
