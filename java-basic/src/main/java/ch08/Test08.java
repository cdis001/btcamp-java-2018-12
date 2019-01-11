package ch08;

import java.util.Scanner;

public class Test08 {
      
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    
    System.out.println("계산식? ");
    int a = kb.nextInt();
    String op = kb.next();
    int b = kb.nextInt();

    kb.close();
    
    int result = 0;
    switch (op) {
      case "+": result = ch08.util.Calculator2.plus(a, b); break;
      case "-": result = ch08.util.Calculator2.minus(a, b); break;
      case "*": result = ch08.util.Calculator2.multiple(a, b); break;
      case "|": result = ch08.util.Calculator2.abs(a); break;
      default:
        System.out.println("지원하지 않는 명령어입니다");
        return;
        
    }
    
    System.out.printf("%d %s %d = %d\n ", a, op, b, result);
  }
  }

