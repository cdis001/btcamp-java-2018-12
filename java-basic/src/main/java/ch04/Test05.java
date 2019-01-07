package ch04;
//연산자 우선순위

public class Test05 {
  public static void main(String[] args) {
    
    float r = 3.2f + 5 / 2;
    System.out.println(r);
    
    float r2 = (3.2f + 5) / 2;
    System.out.println(r2);
    
    int a = 2; //r3가 연산되는 동안 a값은 5가 됨
    int r3 = a++ + a++ * a++; // r3 = 2 + 3 * 4 = 14
    System.out.println(r3);
    System.out.println(a); //'♡'!!
    
  }
}
