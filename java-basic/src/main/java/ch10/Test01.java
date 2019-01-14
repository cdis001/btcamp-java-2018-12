package ch10;

class My1 {
  //인스턴스에 상관없이 공유하는 값이라면 static 필드로 선언
  static int a;
  
  //개별적으로 관리되어야 할 값이라면 인스턴스 필드로 선언
  int b;
}

public class Test01 {
  public static void main(String[] args) {
    My1 obj1 = new My1();
    My1 obj2 = new My1();
    My1 obj3 = new My1();
    
    My1.a = 100;
    
    obj1.a = 200; // = My1.a
    obj2.a = 300; // = My1.a
    obj3.a = 400; // = My1.a
    
    System.out.println(My1.a); //권장하지 않음
    
    obj1.b = 100;
    obj2.b = 200;
    obj3.b = 300;
    
    System.out.println(obj1.b);
    System.out.println(obj2.b);
    System.out.println(obj3.b);
    
  }  
}
