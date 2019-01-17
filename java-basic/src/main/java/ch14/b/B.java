package ch14.b;

public class B extends A {
  
//  @Override void m1(int xx) {  } //OK!
  
//  @Override int m1(int a) {} //컴파일 오류!; 리턴타입이 다르기 때문
  
//  @Override void m1(long a) {} //오류; 파라미터의 타입이 다르기 때문
  
//  @Override void m1(int a, int b) {} //오류; 파라미터의 개수가 다르기 때문
  
//  @Override private void m1(int a) {} //오류; 접근 범위를 축소하는것은 안 됨 
  
//  @Override public void m2(String a, int b) {} //OK!; 확대하는것은 괜찮음
}
