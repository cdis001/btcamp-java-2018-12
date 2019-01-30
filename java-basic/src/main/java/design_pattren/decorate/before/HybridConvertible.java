package design_pattren.decorate.before;

public class HybridConvertible extends Hybrid {
  
  boolean openRoof;
  
  public void open(boolean open) {
    this.openRoof = open;
  }
  public void run2() {
    if (openRoof) {
    System.out.println("뚜껑 연다");
    } else {
      System.out.println("뚜겅 닫는다");
    }
    this.run();
  }

}
