package ch18.e;

public class Zebra {
  String model = "지브라";
  static final int on = 1;
  static final int off = 2;
      
  boolean use;
  
  public void rotate(int direction) {
    if(direction == 1) { //오른쪽 회전
      this.use = true;
    } else if (direction == 2) {//왼쪽 회전
      this.use = false;
    }
  }
}
