//Wrapper 클래스
package ch11;

import java.util.Date;

public class Test09 {
  public static void main(String[] args) {
//    Integer i1 = new Integer(100); ->가능한 사용하지 말라!
    Integer i1 = Integer.valueOf(100);;
//    Character c1 = new Character('가');
    Character c1 = Character.valueOf('가');
    byte b = i1.byteValue(); //int를 byte로 바꾸어 리턴하는 메서드
    String s = i1.toString(); //int를 String로 바꾸어 리턴하는 메서드
    String str = Integer.toHexString(200); //int값을 16진수로 변환 후 문자열로 리턴하는 메서드...외에 많은 wrapper클래스가 있음
  printInt(100);
  printfloat(3.14f);
//  printInt("Hello!") -> Wrapper 클래스를 사용하면 컴파일 오류가 나지 않음
//  파라미터 변수가 값을 요구하는 primitive 타입의 변수이기 때문에 인스턴스의 주소를 넘길 수 없음
  
  Integer x = Integer.valueOf(1000);
  Float y = Float.valueOf(3.14f);
  String z = "Hello!";
  Date today = new Date();
  
  printObject(x);
  printObject(y);
  printObject(z);
  printObject(today);
  }
  
  static void printInt(int i) {
    System.out.println("값: " + i);
  }
  static void printfloat(float f) {
    System.out.println("값: " + f);
  }
  static void printObject(Object obj) {
    System.out.println("값: " + obj);
  }
}
