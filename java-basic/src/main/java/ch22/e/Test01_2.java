package ch22.e;

import java.io.FileInputStream;
import ch22.c.BufferedInputStream;
import ch22.c.DataInputStream;

public class Test01_2 {
 
  public static void main(String[] args) {
    Score s1 = null;
    Score s2 = null;
    Score s3 = null;
    
    try(DataInputStream in2 = 
        new DataInputStream(new BufferedInputStream
            (new FileInputStream("score.data")))) {
      

//      s1 = new Score (in2.readUTF(), in2.readInt(), in2.readInt(), in2.readInt());
//      
//      s2 = new Score (in2.readUTF(), in2.readInt(), in2.readInt(), in2.readInt());
//      s2.compute();
//      
//      s3 = new Score (in2.readUTF(), in2.readInt(), in2.readInt(), in2.readInt());
//      s3.compute();
      
      s1 = new Score();
      s1.setName(in2.readUTF());
      s1.setKor(in2.readInt());
      s1.setEng(in2.readInt());
      s1.setMath(in2.readInt());
      
      s2 = new Score();
      s2.setName(in2.readUTF());
      s2.setKor(in2.readInt());
      s2.setEng(in2.readInt());
      s2.setMath(in2.readInt());
      
      s3 = new Score();
      s3.setName(in2.readUTF());
      s3.setKor(in2.readInt());
      s3.setEng(in2.readInt());
      s3.setMath(in2.readInt());
      
//      System.out.println(s1);
//      System.out.println(s2);
//      System.out.println(s3);
      
      System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
          s1.getName(), s1.getKor(), s1.getEng(), s1.getMath(),
          s1.getSum(), s1.getAver());
      
      System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
          s2.getName(), s2.getKor(), s2.getEng(), s2.getMath(),
          s2.getSum(), s2.getAver());
      
      System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
          s3.getName(), s3.getKor(), s3.getEng(), s3.getMath(),
          s3.getSum(), s3.getAver());
      
    } catch (Exception e) {
      e.printStackTrace();
      
    }
    
    System.out.println("출력완료!");
  }
    
  }


