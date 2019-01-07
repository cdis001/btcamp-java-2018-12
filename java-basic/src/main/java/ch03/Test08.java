package ch03;

public class Test08 {
  public static void main(String[] args) {
    java.io.InputStream in = System.in;
    java.util.Scanner keybord = new java.util.Scanner(in);
    
    System.out.println("a? ");
    int a = keybord.nextInt();
    
    System.out.println("b? ");
    int b = keybord.nextInt();
    
    System.out.printf("%d * %d = %d\n", a, b, a*b);
  }
}
