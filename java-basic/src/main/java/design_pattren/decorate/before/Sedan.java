package design_pattren.decorate.before;

public class Sedan extends Car {

  @Override
  public void run() {
    System.out.println("달린다~~");
  }
  
  public void openSunRoof() {
    System.out.println("선루프 연다");
  }

  public void closeSunRoof() {
    System.out.println("선루프 닫는다");
  }
}
