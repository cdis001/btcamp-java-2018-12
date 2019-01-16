//캡슐화의 필요성
package ch12.A;

public class Test01 {
  public static void main(String[] args) {
    //클래스를 만든 개발자의 의도에 따라 잘 사용한 예
    Calculator c = new Calculator();
    c.plus(100);
    c.plus(15);
    c.minus(27);
    
    //클래스를 만든 개발자의 의도에 벗어나 사용한 예
    Calculator c2 = new Calculator();
    c2.plus(100);
    c2.plus(15);
    
    c2.result = 100;
    
    c2.minus(27);
    
  }

}
