package ch13.D;

public class Test01 {

  public static void main(String[] args) {
    B obj = new B();
    
    obj.m1(); //B에서 찾지 못 하는 메소드이므로 수퍼클래스를 찾아 올라간 뒤 해당하는 값을 찾아옴 (객체지향 언어가 절차지향 언어보다 느린 이유)
    obj.m2();
  }

}
