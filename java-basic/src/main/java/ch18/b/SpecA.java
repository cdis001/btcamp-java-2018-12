package ch18.b;

public interface SpecA {

//  private abstract void m1(); 
//  protected abstract void m1(); =>접근제한자가 public이 아니기 때문에 오류 
  
  abstract void m1(); //default가 아니라 public을 생략한 것
  
  void m2(); // abstract도 생략 가능함
}
