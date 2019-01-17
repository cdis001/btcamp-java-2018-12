package ch13.f;

public class X {
  private int v1 = 100;
  
  public X(int value) {
    System.out.println("X.X()");
    this.v1 = value;
  }
  
  public void m1() {
    System.out.printf("X.v1 = %d\n", this.v1);
  }
}
