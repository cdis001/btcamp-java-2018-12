package design_pattren.composite;

public class File extends Node {

  String type;
  int length;
  
  public File (String title, String type, int length) {
    this.title = title;
    this.type = type;
    this.length = length;
  }
  
  @Override
  public void getFileInfo() {
    System.out.printf("파일명: %s\n", this.title);
    
  }

}
