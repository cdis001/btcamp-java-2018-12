package ch21.d;

public class Test07 {

  public static void main(String[] args) {
    try {
      m3();
    } catch (Exception e) {
      System.out.println(e.toString());
    }
    System.out.println("종료");
  }
  
  static void m3() {
    m2();
  }
  
  static void m2() {
    m1();
  }
  
  static void m1() {
    throw new RuntimeException();
  }
}






