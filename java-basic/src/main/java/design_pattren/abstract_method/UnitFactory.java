package design_pattren.abstract_method;

public interface UnitFactory {
  int RESTAURANT = 1;
  public static final int TRAINING_CENTER = 2;
  
  public Unit createUnit(int building); 
  
  }
