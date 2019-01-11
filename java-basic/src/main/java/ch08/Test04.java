package ch08;

class My4 {
  //클래스 필드 = 스테틱 필드(변수)
  static int a;
  
  //클래스 블록 = 스테틱 블록
  static {
    System.out.println("스테틱 블록입니다!");
  }
  static {
    System.out.println("여러개 선언할 수 있습니다!");
  }
  
  //클래스 메서드
  static void m1() {
    System.out.println("m1이라고 하는 스테틱 메서드입니다");
  }
  
}

public class Test04 {
  public static void main(String[] args) {
    System.out.println("*******************");
    
    My4 obj1; //레퍼런스를 선언한다고 클래스가 로딩되지 않음
    System.out.println("-------------------");

    //My4.a = 300;
    
    My4.m1();
    
  }
  
}
