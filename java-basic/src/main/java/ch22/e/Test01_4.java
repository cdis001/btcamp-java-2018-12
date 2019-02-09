package ch22.e;

import java.io.FileInputStream;
import ch22.c.BufferedInputStream;
import ch22.c.DataInputStream;

public class Test01_4 {
 
  public static void main(String[] args) {
    Score s1 = null;
    Score s2 = null;
    Score s3 = null;
    
    try(FileInputStream in = new FileInputStream("data.bin");
        BufferedInputStream in1 = new BufferedInputStream(in);
        DataInputStream in2 = new DataInputStream(in1)) {
      
      String st1 = in2.readUTF();
      String st2 = in2.readUTF();
      String st3 = in2.readUTF();
      
      System.out.println(st1);
      System.out.println(st2);
      System.out.println(st3);
      
    } catch (Exception e) {
      e.printStackTrace();
      
    }
    
    System.out.println("출력완료!");
  }
    
  }


