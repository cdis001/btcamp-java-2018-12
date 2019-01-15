package ch10;

class A {
  static int a = 7;
  
  /*static*/ {
    System.out.println("A.static{}");
    a += B.b;
  }
}

class B {
  // A클래스에서 b값을 요구하였기 때문에 B 클래스를 모두 로딩한 뒤에 a = B.b값으로 돌아감
  // 이후 B클래스는 한 번 로딩 되었기 때문에 두번 로딩 하지 않으므로 값은 29로 고정
  static int b = 22;
  
  /*static*/ {
    System.out.println("B.static{}");
    b += A.a;
  }
}

public class Test13 {
  public static void main(String[] args) {
    System.out.println(A.a); // 예상값: 22 ㅜㅜ..
    System.out.println(B.b); // 예상값: 29
        
  }  
}
