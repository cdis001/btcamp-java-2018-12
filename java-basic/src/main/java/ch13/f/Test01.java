package ch13.f;

public class Test01 {

  public static void main(String[] args) {
    B obj = new B();
    //클래스를 로딩할 때 super 클래스부터 로딩되므로, A의 초기화를 먼저 실행함
    obj.m1(); 
    obj.m2();
  }

}
