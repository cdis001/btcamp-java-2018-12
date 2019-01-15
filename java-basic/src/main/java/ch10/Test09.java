package ch10;

class Monitor7 {
  int bright; //밝기(0%~100%)
  int contrast = 50; //명암(0%~100%)
  int widthRes; //해상도 너비
  int heihgtRes = 1080; //해상도 높이
  
  Monitor7() {
    this.bright = 50;
    this.contrast = 70;
    this.widthRes = 2560;
    this.heihgtRes = 1200;
 
  }
  
  public void on() {
    System.out.println("화면을 출력한다.");
  }
}

public class Test09 {
  public static void main(String[] args) {
    new Monitor7();
  }  
}
