package ch03;

public class Test10 {
  public static void main(String[] args) {
    java.io.InputStream in = System.in;
    java.util.Scanner keybord = new java.util.Scanner(in);

    
    System.out.println("나이: ");
    int age = keybord.nextInt();
    
    keybord.nextLine(); //남아있는 LF값을 날려버림
    
    System.out.println("이름: ");
    String name = keybord.nextLine();

    
    System.out.printf("%s(%d)\n", age, name);
  }
}
