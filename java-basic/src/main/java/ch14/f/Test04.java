package ch14.f;

public class Test04 {
  public static void main(String[] args) {
    Car c1 = new Car();
    c1 = new Sedan();
    c1 = new SUV();
    c1 = new Convertible();
    c1 = new Truck();
    c1 = new PickupTruck();
   
    //상위타입의 인스턴스를 가리킬 수 없으며, 상속관계가 없는 타입 또한 가리킬 수 없음
    Sedan c2 = new Sedan();
    c2 = new SUV();
    c2 = new Convertible();
//    c2 = new Car();
//    c2 = new Truck();
//    c2 = new PickupTruck();
   
  }

}
  
