package ch05;

public class Test12 {
  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      System.out.print(i);
      System.out.print(", ");
    };
    System.out.println();
    
    int i = 1;
    for (;;) {
      if (i > 10)
        break;
      System.out.print(i + " ");
      i++;
    };
    System.out.println();
    
    
  } //end main
} //end class
