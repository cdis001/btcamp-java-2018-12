package ch02;

public class Test13 {
  public static void main(String[] args) {
    
    System.out.printf("'%-10s' '%10s'\n", "홍길동", "임꺽정");
    System.out.printf("'%-10s' '%10s'\n", 12345, 12345);
    
    System.out.printf("'%010d' '%010d'\n", 12345, 12345);
    System.out.printf("'%+010d' '%+010d'\n", 12345, -12345);
  }

}
