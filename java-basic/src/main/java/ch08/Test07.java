package ch08;

import java.util.Scanner;

public class Test07 {
      
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    
    System.out.println("계산식? ");
    int a = kb.nextInt();
    String op = kb.next();
    int b = kb.nextInt();

    kb.close();
    
    int result = 0;
    switch (op) {
      case "+": result = Calculator.plus(a, b); break;
      case "-": result = Calculator.minus(a, b); break;
      case "*": result = Calculator.multiple(a, b); break;
      case "|": result = Calculator.abs(a); break;
      default:
        System.out.println("지원하지 않는 명령어입니다");
        return;
        
    }
    
    System.out.printf("%d %s %d = %d\n ", a, op, b, result);
  }
  }

