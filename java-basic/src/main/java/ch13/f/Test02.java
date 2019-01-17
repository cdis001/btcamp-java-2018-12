package ch13.f;

public class Test02 {

  public static void main(String[] args) {
    Y obj = new Y();
    //클래스를 로딩할 때 super 클래스부터 로딩되므로, A의 초기화를 먼저 실행함
    obj.m1(); 
    obj.m2();
  }

}
