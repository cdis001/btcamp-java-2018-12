//싱글톤(singleton) 적용 후
package design_pattren.factory_method;
class Car2 {
  String model;
  int cc;
  
  private static Car2 instance; //인스턴스 주소를 받을 클래스 필드 선언
  
  //비공개 생성자는 외부에서 호출할 수 없으며 내부에서만 호출 가능함
  private Car2() {}
  
  public static Car2 getInstance() {
    if (Car2.instance == null) {
      Car2.instance = new Car2();
    }
    return new Car2();
  }
}

public class Test02 {
  public static void main(String[] args) {
//    Car2 c1 = new Car2(); ->접근 제한이 비공개로 되어있으므로 직접 호출할 수 없음
    Car2 c2 = Car2.getInstance();
    Car2 c3 = Car2.getInstance();
    
    if (c2 != c3) {
    System.out.println("다르다!");
    } 
    else {
      System.out.println("같다!");
    }
    }
}
