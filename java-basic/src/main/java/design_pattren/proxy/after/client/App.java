package design_pattren.proxy.after.client;

import java.util.Scanner;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;
import design_pattren.proxy.after.server.CalculatorStub;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);
    CalculatorStub calc = new CalculatorStub();
    while (true) {
      System.out.println("계산식>(예: 100 + 200) ");
      String input = keyboard.nextLine();
      if (input.equalsIgnoreCase("quit")) {
        break;
      }
      String[] values = input.split(" ");
      int a = Integer.parseInt(values[0]);
      int b = Integer.parseInt(values[2]);
      try {
        switch (values[1]) {
          case "+":
            System.out.println(calc.plus(a, b));
            break;
          case "-":
            System.out.println(calc.minus(a, b));
            break;
            default: System.out.println("해당 연산자를 지원하지 않습니다.");
        }
      } catch (Exception e) {
        System.out.println("식 또는 계산 오류: " + e.getMessage());
      }
    }

  }
}
