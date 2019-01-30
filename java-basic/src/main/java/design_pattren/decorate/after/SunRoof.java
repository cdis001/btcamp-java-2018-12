package design_pattren.decorate.after;

public class SunRoof extends Decorator {

  boolean openSunRoof;
  
  public SunRoof(Car car) {
    super(car);
  }
  
  @Override
  public void run() {
    if(openSunRoof) {
      System.out.print("선루프 열고 ");
    } else {
      System.out.print("선루프 닫고 ");
    }
    this.car.run();
  }
  
  public void openSunRoof() {
    this.openSunRoof = true;
  }

  public void closeSunRoof() {
    this.openSunRoof = false;
  }
}
