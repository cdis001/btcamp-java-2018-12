package ch10;

class Monitor8 {
  int bright; //밝기(0%~100%)
  int contrast = 50; //명암(0%~100%)
  int widthRes; //해상도 너비
  int heihgtRes = 1080; //해상도 높이
  
  Monitor8(int bright, int contrast) {
    this.bright = bright;
    this.contrast = contrast;
  }
  
  public void on() {
    System.out.println("화면을 출력한다.");
  }
}

public class Test10 {
  public static void main(String[] args) {
    new Monitor8(50, 50);
  }  
}
