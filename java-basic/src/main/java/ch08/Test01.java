package ch08;

//공통으로 사용하는 인스턴스 필드는 일일히 생성하는것이 비효율적이여서 클래스 필드를 생성함
class My1 {
  //new 명령을 실행 시 힙 메모리에 생성되는 변수; 인스턴스 필드
  static String manager = "관리자";
  static String member = "회원";
  static String guset = "손님"; //클래스 필드; 클래스 안에 로딩될 때 생성됨
  String name;
  int age; 
  String userType; //인스턴스 필드;
}

public class Test01 {
  public static void main(String[] args) {
    
    My1 obj1 = new My1();
    obj1.name = "홍길동";
    obj1.age = 20;
    obj1.userType = My1.member;
    
    My1 obj2 = new My1();
    obj2.name = "임꺽정";
    obj2.age = 30;
    obj2.userType = My1.manager;
    
    My1 obj3 = new My1();
    obj3.name = "유관순";
    obj3.age = 17;
    obj3.userType = My1.guset;
    
    My1 obj4 = new My1();
    obj4.name = "윤봉길";
    obj4.age = 22;
    obj4.userType = My1.member;
    
    
  }
  
}
