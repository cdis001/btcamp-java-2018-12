package ch14.f;

public class Test01 {
  public static void main(String[] args) {
    A obj; // class A라는 타입
    
    obj = new A(); // class A를 인스턴스로 가져옴
    obj.m1();
    
    obj = new B(); // class B를 인스턴스로 가져옴(class A에 있는 것만 가져옴)
//    obj.m2();
    
    obj.m1(); // 
    }
}
