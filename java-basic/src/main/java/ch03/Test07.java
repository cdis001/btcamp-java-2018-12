package ch03;

public class Test07 {
  public static void main(String[] args) {
    java.io.InputStream in = System.in;
    java.util.Scanner keybord = new java.util.Scanner(in);
    
    System.out.println("이름을 입력하세요: ");
    java.lang.String name = keybord.nextLine();
    
    System.out.println("나이를 입력하세요: ");
    java.lang.String age = keybord.nextLine();
    
    System.out.printf("당신의 이름은 %s 입니다\n", name);
    System.out.printf("당신의 나이는 %s 입니다", age);
  }
}
