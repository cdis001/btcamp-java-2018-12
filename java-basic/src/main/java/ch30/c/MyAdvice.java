package ch30.c;


public class MyAdvice {
  public void advice1() {
    System.out.println("ch30.c.MyAdvice.advice1()" + this.getClass().getName());
  }
  
  public void advice2() {
    System.out.println("ch30.c.MyAdvice.advice2()" + this.getClass().getName());
  }
}
