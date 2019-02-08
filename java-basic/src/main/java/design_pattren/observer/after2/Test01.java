package design_pattren.observer.after2;

public class Test01 {
  public static void main(String[] args) {
    Car car = new Car();
    

    System.out.println("-------------------");
    car.addObserver(new SafeBeltCarObserver());
    car.start();
    car.run();
    car.stop();
    
    System.out.println("-------------------");
    car.addObserver(new EngineOilCarObserver());
    car.start();
    car.run();
    car.stop();
    
    System.out.println("-------------------");
    car.addObserver(new BreakOilCarObserver());
    car.start();
    car.run();
    car.stop();
    
    System.out.println("-------------------");
    car.addObserver(new LightOffCarObserver());
    car.start();
    car.run();
    car.stop();
    
    System.out.println("-------------------");
    car.addObserver(new SunRoofCloseCarObserver());
    car.start();
    car.run();
    car.stop();
    
    
  }
}
