package design_pattren.decorate.after;

public class Hybrid extends Decorator {

  public Hybrid(Car car) {
    super(car);
  }
  
  @Override
  public void run() {
      System.out.print("전기 모터를 켜고, ");
    this.car.run();
  }
}
