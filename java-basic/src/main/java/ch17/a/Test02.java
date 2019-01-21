package ch17.a;

class abstract My1 extends A {
  
}
class abstract My2 extends A{
  
  public void m2(String name) {
    
  }
  
}
publie void m3()


public class Test02 {

  public static void main(String[] args) {
    
    A.obj = new A();
    My1 obj2 = new My1();
    
    Mt2 obj3 = new My2();
    obj3.m2("홍길동");
    
    A obj4 = new My2();
    
    obj4.m2("임꺽정");
  }

}
