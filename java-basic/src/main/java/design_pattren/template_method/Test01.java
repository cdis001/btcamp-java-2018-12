package design_pattren.template_method;

public class Test01 {

  public static void main(String[] args) {
    Restaurant u1 = new Restaurant();
    u1.setName("군인식당");
    u1.setArea(50);
    u1.setType(Unit.GENERAL_BUILDING);
    u1.build();
    
    System.out.println("--------------------");
    
    TrainingCenter u2 = new TrainingCenter();
    u2.setName("훈련소");
    u2.setArea(300);
    u2.setType(Unit.GENERAL_BUILDING);
    u2.build();
    
    System.out.println("--------------------");
  }

}
