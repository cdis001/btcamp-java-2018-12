package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Test01_1 {

  public static void main(String[] args) {

    try (
        DataOutputStream out2 = new DataOutputStream
        (new BufferedOutputStream
            (new FileOutputStream("score.data")))) {
      Score s1 = new Score("홍길동", 100, 100, 100);
      Score s2 = new Score("임꺽정", 90, 90, 90);
      Score s3 = new Score("유관순", 80, 80, 80);
      
      out2.writeUTF(s1.getName());
      out2.writeInt(s1.getKor());
      out2.writeInt(s1.getEng());
      out2.writeInt(s1.getMath());
      
      out2.writeUTF(s2.getName());
      out2.writeInt(s2.getKor());
      out2.writeInt(s2.getEng());
      out2.writeInt(s2.getMath());
      
      out2.writeUTF(s3.getName());
      out2.writeInt(s3.getKor());
      out2.writeInt(s3.getEng());
      out2.writeInt(s3.getMath());
      
      out2.flush();
      
      System.out.println("저장완료");
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

}
