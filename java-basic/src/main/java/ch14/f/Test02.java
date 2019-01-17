package ch14.f;

public class Test02 {
  public static void main(String[] args) {
    A obj = new B();
//    obj.m2(); ->컴파일 오류
    obj.m1(); // 
    
//    B obj2 = obj; ->컴파일 오류
    B obj2 = (B)obj;
    
    obj2.m2();
    
    if ( obj == obj2 ) {
      System.out.println("같다");
    }
    
    A obj3 = new A();
    B obj4 = (B) obj3; //이미 A타입의 인스턴스라고 선언해놨기 때문에 B 타입이라고 우길 수 없음;
    
    obj3.m1();
    obj4.m2();
    }
}
