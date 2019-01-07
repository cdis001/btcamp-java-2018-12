package ch02;

public class Test12 {
  public static void main(String[] args) {
    System.out.printf("hello!\n");
    
    System.out.printf("이름: %s\n", "홍길동");
    System.out.printf("안녕하세요! %s입니다.\n", "임꺽정");
    
    System.out.printf("%d %x\n", 0x41, 0x42);
    System.out.printf("%d %x %c \n", 65, 65, 65);
    System.out.printf("%d %b\n", 0x41, true);
    
    System.out.printf("%2$d %2$x %2$c\n", 32, 33, 34);
  }

}
