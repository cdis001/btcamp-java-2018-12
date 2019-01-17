package ch13.f;

public class Test03 extends A, X { //컴파일 오류ㅋㅋ

  public static void main(String[] args) {
    Y obj = new Y();
    obj.m1(); 
    obj.m2();
  }

}
