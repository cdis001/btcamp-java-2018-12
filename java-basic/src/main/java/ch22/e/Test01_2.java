package ch22.e;

import java.io.FileInputStream;
import ch22.c.BufferedInputStream;
import ch22.c.DataInputStream;

public class Test01_2 {
 
  public static void main(String[] args) {
    Score s1 = null;
    Score s2 = null;
    Score s3 = null;
    
    try(FileInputStream in = new FileInputStream("data.bin");
        BufferedInputStream in1 = new BufferedInputStream(in);
        DataInputStream in2 = new DataInputStream(in1)) {
      
      s1 = in2.
      
      System.out.println(s1);
      System.out.println(s2);
      System.out.println(s3);
      
    } catch (Exception e) {
      e.printStackTrace();
      
    }
    
    System.out.println("출력완료!");
  }
    
  }


