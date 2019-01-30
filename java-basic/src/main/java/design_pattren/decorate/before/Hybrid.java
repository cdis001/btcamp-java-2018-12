package design_pattren.decorate.before;

public class Hybrid extends Car {

  @Override
  public void run() {
    if(this.speed <= 60) {
      System.out.println("모터로 달린다");
    }
    System.out.println("달린다~~");
  }

}
