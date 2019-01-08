package ch04;
//전위연산자 *내용추가*

public class Test08 {
  public static void main(String[] args) {
    
    float f1 = 0.1f;
    float f2 = 0.1f;
    
    System.out.println(f1 * f2 == 0.01f);
    System.out.println(f1 * f2);
    
    float r = f1 * f2 -0.01f;
    System.out.println(Math.abs(r) <= Float.POSITIVE_INFINITY);
  }
}
