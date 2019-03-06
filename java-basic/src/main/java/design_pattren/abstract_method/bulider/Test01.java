package design_pattren.abstract_method.bulider;

public class Test01 {
  
  public static void main(String[] args) {
    
    CarBuilder carBuilder = new CarBuilder();
    Car c1 = carBuilder.bulid("비트자동차 모델1");
    System.out.println(c1);
    System.out.println("-------------------------");
    
    carBuilder = new CarBuilder();
    Car c2 = carBuilder.bulid("비트자동차 모델2");
    System.out.println(c2);
    System.out.println("-------------------------");
    
    carBuilder = new CarBuilder();
    Car c3 = carBuilder.bulid("비트자동차 모델3");
    System.out.println(c3);
    System.out.println("-------------------------");
  }
}
