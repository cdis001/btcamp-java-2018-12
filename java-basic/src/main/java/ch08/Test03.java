package ch08;

class My3 {
  //클래스 필드 = 스테틱 필드(변수)
  static int sa;
  
  //인스턴스 필드
  int ia; 
}

public class Test03 {
  public static void main(String[] args) {
    My3.sa = 100; //인스턴스를 생성할 필요 없이 클래스 이름으로 바로 사용할 수 있음
    
    My3 obj1 = new My3(); //인스턴스 필드는 new명령어를 이용해야만 생성됨
    My3 obj2 = new My3();
    
    obj1.ia = 200;
    obj2.ia = 300;
    
    //My3.ia = 500; ->클래스 이름만으로는 인스턴스 필드에 접근 불가능
    
    obj1.sa = 500; //허락은 하지만, 권고하진 않음(인스턴스 필드로 착각할 수 있기 때문)
    
    System.out.println(My3.sa);
    
  }
  
}
