package ch29.g;

import java.beans.PropertyEditorSupport;

public class MyCustomBlackBoxEditer2 extends PropertyEditorSupport{
  
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    
    BlackBox bBox = new BlackBox();
    
    String[] strs = text.split(",");
    
    String maker = strs[0];
    String model = strs[1];
    
    bBox.setMaker(maker);
    bBox.setModel(model);
    
    this.setValue(bBox);
    
  }
}
