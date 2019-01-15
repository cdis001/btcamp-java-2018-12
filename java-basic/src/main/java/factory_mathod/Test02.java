//팩토리 메서드 적용 후
package factory_mathod;

class Car2 {
  String model;
  int cc;
  boolean sunroof;
}

class Car2Factory {
  public static Car2 createCar2(String model) {
    Car2 c = new Car2();
    
    switch (product) {
      case "tc"
      c.model = "티코";
      c.cc = 890;
      c.sunroof = true;
      break;
      
      case "tcg"
      c.model = "티코 골드";
      c.cc = 890;
      c.sunroof = true;
      break;
      
      case "sn"
      c.model = "소나타";
      c.cc = 1980;
      c.sunroof = false;
      break;

      case "sng"
      c.model = "소나타 골드";
      c.cc = 1980;
      c.sunroof = false;
      break;
      default:
        return null;
    }
    return c;
  }
}

public class Test02 {

  public static void main(String[] args) {
    Car2 c1 = Car2Factory.createCar2("tc");
    Car2 c2 = Car2Factory.createCar2("tcg");
    Car2 c3 = Car2Factory.createCar2("cn");
    Car2 c4 = Car2Factory.createCar2("sleep");

  }

}
