package design_pattren.abstract_method;

public class ZergUnitFactory implements UnitFactory {
  
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
    unit.setName("저그: 군인식당");
    unit.setArea(200);
    unit.setType(Unit.ATTACK_BUILDING);
    unit.build();
    return unit;
  }
  
  private Unit creatTrainingCenter() {
    Unit unit = new TrainingCenter();
    unit.setName("저그: 훈련소");
    unit.setArea(100);
    unit.setType(Unit.ATTACK_BUILDING);
    unit.build();
    return unit;
  }
}
