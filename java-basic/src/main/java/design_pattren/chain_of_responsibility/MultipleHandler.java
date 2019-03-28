package design_pattren.chain_of_responsibility;

public class MultipleHandler extends AbstractHandler {

  @Override
  public void handle(int a, int b, String op) {

    if (op.equals("*")) {
      System.out.printf("%d * %d = %d\n", a, b, (a * b));
    }
    next.handle(a, b, op);
  }
}
