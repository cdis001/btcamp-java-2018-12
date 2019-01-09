package ch06;

public class Test03 {
  public static void main(String[] args) {
    String s;
    s = m1();
    System.out.println(s);

    int i;
    i = m2();
    System.out.println(i);
    
    m1();
    m2();
    
  }
  static String m1() {
    return "홍길동";
  }
  static int m2() {
    return 100;
  }

}
