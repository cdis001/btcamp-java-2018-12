package ch21.d;

public class Test05 {

  public static void main(String[] args) {
    try {
      m3();
    } catch (Exception e) {
      System.out.println(e.toString());
    }
    System.out.println("종료");
  }
  
  static void m3() throws Exception {
    m2();
  }
  
  static void m2() throws Exception {
    m1();
  }
  
  static void m1() throws Exception {
    throw new Exception();
  }
}






