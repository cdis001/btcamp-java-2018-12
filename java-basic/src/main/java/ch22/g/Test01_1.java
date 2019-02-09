package ch22.g;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test01_1 {
  public static void main(String[] args) {
  try(ObjectOutputStream out = new ObjectOutputStream(
      new FileOutputStream("Score1.data"))) {
    
    Score1 score = new Score1();
    score.name = "홍길동";
    score.kor = 100;
    score.eng = 100;
    score.math = 100;
    score.sum = score.kor + score.eng + score.math;
    score.aver = score.sum / 3f;
    
    out.writeObject(score);
    
    System.out.println("저장완료!");
  }
   catch(Exception e) {
    e.printStackTrace();
  }
  }
}
