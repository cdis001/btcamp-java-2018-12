package ch22.g;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test01_2 {
  public static void main(String[] args) {
  try(ObjectInputStream in = new ObjectInputStream(
      new FileInputStream("Score1.data"))) {
    Score1 score = (Score1) in.readObject();
    System.out.println(score);
    
    System.out.println("출력완료!");
  }
   catch(Exception e) {
    e.printStackTrace();
  }
  }
}
