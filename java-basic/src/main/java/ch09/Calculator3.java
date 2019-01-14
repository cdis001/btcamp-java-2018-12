package ch09;

public class Calculator3 {

  int result = 0; //인스턴스(=논스테틱)필드

  static void plus(Calculator3 that, int a) {
    //result += a;
    that.result += a;
  }
  static void minus(Calculator3 that, int a) {
    //result -= a;
    that.result -= a;
  }
  static void multiple (Calculator3 that, int a) {
    //result *= a;
    that.result *= a;
  }
  static void divide (Calculator3 that, int a) {
    //result /= a;
    that.result /= a;
  }

}
