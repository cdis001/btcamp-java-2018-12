package ch30.d;

import org.springframework.stereotype.Component;

@Component
public class X {
  public String hello(String name) {
    System.out.println("X.hello(String)");
    return name + "님 반갑습니다!";
  }
  
  public int calculate(int a, int b, String op) {
    System.out.println("X.calculate(int, int, String)");
    switch(op) {
      case "+": return a + b;
      case "-": return a - b;
      case "*": return a * b;
      case "/": return a / b;
      case "%": return a % b;
      default:
          throw new RuntimeException("지원하지 않는 연산자입니다");
    }
  }
}
