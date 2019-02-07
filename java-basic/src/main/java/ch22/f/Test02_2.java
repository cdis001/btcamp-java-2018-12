package ch22.f;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test02_2 {
  public static void main(String[] args) {
  try(ObjectInputStream in = new ObjectInputStream(
      new FileInputStream("Score2.data"))) {
    Score2 score = (Score2) in.readObject();
    System.out.println(score);
    
    System.out.println("출력완료!");
  }
   catch(Exception e) {
    e.printStackTrace();
  }
  }
}
