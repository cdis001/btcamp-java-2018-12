//++a, a++ 
package test;

public class A3 {
  public static void main(String[] args) {
    for(int a = 0; a < 11; ) {
      int a1 = ++a;
      System.out.printf("%d, ", a1);
    }
    System.out.println();

    for(int b = 0; b < 11; ) {
      int b1 = b++;
      System.out.printf("%d, ", b1);
    }
    System.out.println();

  }

}
