package ch30.c;


public class MyAdvice2 {
  public void advice1() {
    System.out.println("ch30.c.MyAdvice2.advice1()" + this.getClass().getName());
  }
  
  public void advice2() {
    System.out.println("ch30.c.MyAdvice2.advice2()" + this.getClass().getName());
  }
}
