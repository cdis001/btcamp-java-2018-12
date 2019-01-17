package ch14.b;

public class D3 extends D2 {
  @Override
  void m1() {
    System.out.println("D3.m1()");
  }
  @Override
  void m3() {
    System.out.println("D3.m3()");
  }
  
  void test() {
    this.m4(); //D1의 m4실행
    super.m4(); //D1의 m4실행
    
    this.m3(); //D3의 m3실행
    super.m3(); //D1의 m3실행
    
    this.m1(); //D3의 m1실행
    super.m1(); //D2의 m1실행
    
    this.m2(); //D2의 m2실행
    super.m2();//D2의 m2실행 ㅜㅜ..
  }
  public static void main(String[] args) {
    D3 obj = new D3();
    obj.test();
  }
}
