package ch06;

public class Test10 {
  public static void main(String[] args) {
    int value = 0;
    m1(++value); 
    System.out.println(value);
  }
  
  static void m1(int value) {
    m2(++value);
    System.out.println(value);
  }
  static void m2(int value) {
    m3(++value);
    System.out.println(value);
  }
  static void m3(int value) {
    System.out.println(++value);//제일 처음 실행됨
    /*process: main에서 m1(++value)메소드가 호출됨(호출되면서 value값을 1씩 더함)
     * -> m1의 m2메소드 호출 -> m2에서 m3메소드 호출 -> m3에서 ++value값을 출력
     * -> .... -> main의 value값 출력*/
  }

}

