package design_pattren.template_method;

//템플릭 메서드 패턴 + 팩토리 메서드 패턴
public class UnitFactory {
  public static final int RESTAURANT = 1;
  public static final int TRAINING_CENTER = 2;
  
  public Unit createUnit(int building) {
    switch (building) {
      case RESTAURANT: //중복되기 때문에 따로 빼서 사용!
        return creatRestautant();
      
      case TRAINING_CENTER:
        return creatTrainingCenter();
    }
    return null;
  }
  
  private Unit creatRestautant() {
    Unit unit = new Restaurant();
    unit.setName("군인식당");
    unit.setArea(50);
    unit.setType(Unit.GENERAL_BUILDING);
    unit.build();
    return unit;
  }
  
  private Unit creatTrainingCenter() {
    Unit unit = new TrainingCenter();
    unit.setName("훈련소");
    unit.setArea(300);
    unit.setType(Unit.GENERAL_BUILDING);
    unit.build();
    return unit;
  }
}
