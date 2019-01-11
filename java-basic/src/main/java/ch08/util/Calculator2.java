package ch08.util;

public class Calculator2 {

  public static int plus(int a, int b) {
    return a + b;
  }
  public static int minus(int a, int b) {
    return a - b;
  }
  public static int multiple (int a, int b) {
    return a * b;
  }
  public static int abs (int a) {
    /*if (a >= 0)
      return 0;
    else
      return a * -1;*/
    return (a >= 0) ? a : a * -1;
  }
  
  /*public static void main(String[] args) {
    System.out.println(abs (100));
    System.out.println(abs (-100));
  }*/
}
