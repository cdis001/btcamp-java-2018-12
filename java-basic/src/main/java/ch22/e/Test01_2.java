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
      

      s1 = new Score (in2.readUTF(), in2.readInt(), in2.readInt(), in2.readInt());
      s1.compute();
      
      s2 = new Score (in2.readUTF(), in2.readInt(), in2.readInt(), in2.readInt());
      s2.compute();
      
      s3 = new Score (in2.readUTF(), in2.readInt(), in2.readInt(), in2.readInt());
      s3.compute();
     
      
      System.out.println(s1);
      System.out.println(s2);
      System.out.println(s3);
      
    } catch (Exception e) {
      e.printStackTrace();
      
    }
    
    System.out.println("출력완료!");
  }
    
  }


