package ch13.f;

public class Y extends X {
  private int v2 = 200;
  
  public Y() {
    super(500);//X클래스에는 기본 생성자가 없으므로 개발자가 직접 호출할 수퍼 클래스의 생성자를 명시해야 함
    v2 = 220;
    System.out.println("Y.Y()");
  }
  
  public void m2() {
    System.out.printf("Y.v1 = %d\n", this.v2);
  }
}
