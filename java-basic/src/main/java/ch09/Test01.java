package ch09;

public class Test01 {
  public static void main(String[] args) {
    int result = Calculator1.multiple(2, 3);
    result = Calculator1.minus(result, 2);
    result = Calculator1.plus(result, 7);
    
    System.out.println(result);
    
  }
  
}
