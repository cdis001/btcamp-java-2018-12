package design_pattren.composite;

public abstract class Node {
  protected String title;
  
  public String getTitle() {
    return this.title;
  }
  
  public abstract void getFileInfo();
}
