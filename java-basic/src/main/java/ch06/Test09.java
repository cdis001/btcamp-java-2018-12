package ch06;

public class Test09 {
  public static void main(String[] args) {
    int value = 100;
    m1(value);
    System.out.println(value);
    m1(value + 15); //예상값: 215 
    /*process=> main의 value에 15를 더함 = m1(115); -> m1 메소드에 115값이 들어감
     * -> m1메소드에서 value값이 200으로 설정됨 => 값: 200*/  
    System.out.println(value);
    m1(value + 15); 
    System.out.println(value);
  }
  static void m1(int value) {
    value = 200;
    System.out.printf("m1(): %d\n", value);
  }

}

