package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Test03_1 {

  public static void main(String[] args) {

    ArrayList<Score> students = new ArrayList<>();
    students.add(new Score("홍길동", 100, 100, 100));
    students.add(new Score("임꺽정", 90, 90, 90));
    students.add(new Score("유관순", 80, 80, 80));
    
    try (DataOutputStream out2 = new DataOutputStream
        (new BufferedOutputStream
            (new FileOutputStream("score.data")))) {
      
      out2.writeInt(students.size());
      
      for(Score s : students) {
      out2.writeUTF(s.getName());
      out2.writeInt(s.getKor());
      out2.writeInt(s.getEng());
      out2.writeInt(s.getMath());
      }
      
      out2.flush();
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    System.out.println("저장완료");
  }

}
