package ch14.d;

public class A {
  public void m1() {}
  
  
  //public int m1(return 0;) {}
  
  public void m1(int a) {}
  //public void m1 (int b) {} ->이름은 상관없이 파라미터의 타입과 개수가 같으므로 오류
  public void m1(float a) {}
  public void m1(long a) {}
  
  public void m1(float a, float b) {}
  
  private void m1(int a, String b) {}
  

}
