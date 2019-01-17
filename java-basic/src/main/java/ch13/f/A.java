package ch13.f;

public class A {
  private int v1 = 100;
  
  public A() {
    v1 = 120;
    System.out.println("A.A()");
  }
  
  public void m1() {
    System.out.printf("A.v1 = %d\n", this.v1);
  }
}
