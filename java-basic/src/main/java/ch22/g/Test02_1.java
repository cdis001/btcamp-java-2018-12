package ch22.g;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test02_1 {
  public static void main(String[] args) {
  try(ObjectOutputStream out = new ObjectOutputStream(
      new FileOutputStream("Score2.data"))) {
    
    Score2 score = new Score2();
    score.setName("홍길동");
    score.setKor(100);
    score.setEng(100);
    score.setMath(100);
    score.setSum(score.getKor() + score.getEng() + score.getMath());
    score.setAver(score.getSum() / 3f);
    
    out.writeObject(score);
    
    System.out.println("저장완료!");
  }
   catch(Exception e) {
    e.printStackTrace();
  }
  }
}
