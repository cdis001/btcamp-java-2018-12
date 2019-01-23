package design_pattren.abstract_method;

public class Test02 {

  public static void main(String[] args) {
    UnitFactory unitFactory = new UnitFactory();
    
    Unit u1 = unitFactory.createUnit(unitFactory.RESTAURANT);
    //Unit은 추상클래스이기 때문에 인스턴스 생성이 불가능하여 u1에 주소값을 담아줌
    u1.build();
    System.out.println("--------------------");
    
    Unit u2 = unitFactory.createUnit(unitFactory.TRAINING_CENTER);
    u2.build();
    System.out.println("--------------------");

  }

}
