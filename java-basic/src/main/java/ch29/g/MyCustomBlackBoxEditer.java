package ch29.g;

import java.beans.PropertyEditorSupport;

public class MyCustomBlackBoxEditer extends PropertyEditorSupport{
  
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    
    BlackBox bBox = new BlackBox();
    
    String[] strs = text.split(",");
    
    bBox.setMaker(strs[0]);
    bBox.setModel(strs[1]);
    
    this.setValue(bBox);
    
  }
}
