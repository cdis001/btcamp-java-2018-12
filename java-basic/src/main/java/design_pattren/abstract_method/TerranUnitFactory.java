package design_pattren.abstract_method;

public class TerranUnitFactory implements UnitFactory {
  
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
    unit.setName("테란: 군인식당");
    unit.setArea(50);
    unit.setType(Unit.GENERAL_BUILDING);
    unit.build();
    return unit;
  }
  
  private Unit creatTrainingCenter() {
    Unit unit = new TrainingCenter();
    unit.setName("테란: 훈련소");
    unit.setArea(500);
    unit.setType(Unit.GENERAL_BUILDING);
    unit.build();
    return unit;
  }
}
