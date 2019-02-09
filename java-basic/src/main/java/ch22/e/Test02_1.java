package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Test02_1 {

  public static void main(String[] args) {

    Score[] students = {new Score("홍길동", 100, 100, 100),
    new Score("임꺽정", 90, 90, 90),
    new Score("유관순", 80, 80, 80)};
    try (
        DataOutputStream out2 = new DataOutputStream
        (new BufferedOutputStream
            (new FileOutputStream("score.data")))) {
      
      out2.writeInt(students.length);
      
      for(Score s : students) {
      out2.writeUTF(s.getName());
      out2.writeInt(s.getKor());
      out2.writeInt(s.getEng());
      out2.writeInt(s.getMath());
      }
      
      out2.flush();
      
      System.out.println("저장완료");
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

}
