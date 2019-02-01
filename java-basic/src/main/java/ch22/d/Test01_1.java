package ch22.d;

import java.io.FileWriter;

public class Test01_1 {
  public static void main(String[] args) {
    
    try(FileWriter out = new FileWriter("data.txt")) {
      out.write('A'); //0x41 1바이트 출력
      out.write('B'); //0x42 1바이트 출력
      out.write('C'); //0x43 1바이트 출력
      out.write('가'); //0xEAB080 3바이트 출력
      out.write('각'); //0xEAB081 3바이트 출력
      out.write('간'); //0xEAB084 3바이트 출력
    }catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("읽기완료");
  }
}
