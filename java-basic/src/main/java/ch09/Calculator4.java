package ch09;

public class Calculator4 {

  int result = 0; 
  
  //인스턴스 메소드들 (내장변수 this 이용)
  void plus(int a) {
    this.result += a;
  }
  void minus(int a) {
    this.result -= a;
  }
  void multiple (int a) {
    this.result *= a;
  }
  void divide (int a) {
    //this를 생략 할 수 있으며, 컴파일시 자동으로 this가 붙음
    result /= a;
  }

}
