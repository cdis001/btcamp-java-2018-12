package ch06;

public class Test02 {
  public static void main(String[] args) {
    //m1(20, "홍길동"); ->순서가 틀렸으므로 컴파일 오류
    m1("홍길동",20);
  }
  static void m1(String name, int age) {
    System.out.printf("이름: %s\n", name);
    System.out.printf("나이: %s\n", age);
  }
}
