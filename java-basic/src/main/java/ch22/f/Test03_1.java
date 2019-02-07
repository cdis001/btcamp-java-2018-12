package ch22.f;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test03_1 {
  public static void main(String[] args) {
  try(ObjectOutputStream out = new ObjectOutputStream(
      new FileOutputStream("Score3.data"))) {
    out.writeObject(new Score3("홍길동", 100, 100, 100));
    
    System.out.println("저장완료!");
  }
   catch(Exception e) {
    e.printStackTrace();
  }
  }
}
