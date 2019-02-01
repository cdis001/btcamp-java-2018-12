package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Test01_1 {

  public static void main(String[] args) {

    try (FileOutputStream out = new FileOutputStream("data.bin");
        BufferedOutputStream out1 = new BufferedOutputStream(out);
        DataOutputStream out2 = new DataOutputStream(out1)) {
      Score s1 = new Score("홍길동", 100, 100, 100);
      Score s2 = new Score("임꺽정", 90, 90, 90);
      Score s3 = new Score("유관순", 80, 80, 80);
      
      s1.compute();
      s2.compute();
      s3.compute();

      out2.writeUTF(s1.toString());
      out2.writeUTF(s2.toString());
      out2.writeUTF(s3.toString());
      
      out2.flush();
      
      System.out.println("저장완료");
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

}
