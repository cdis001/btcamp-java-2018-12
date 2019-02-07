package ch22.g;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test03_2 {
  public static void main(String[] args) {
  try(ObjectInputStream in = new ObjectInputStream(
      new FileInputStream("Score3.data"))) {
    Score3 score = (Score3) in.readObject();
    score.compute();
    System.out.println(score);
    
    System.out.println("출력완료!");
  }
   catch(Exception e) {
    e.printStackTrace();
  }
  }
}
