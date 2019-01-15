package ch10;

class Monitor10 {
  int bright; //밝기(0%~100%)
  int contrast = 50; //명암(0%~100%)
  int widthRes; //해상도 너비
  int heightRes = 1080; //해상도 높이
  
  Monitor10() {
    this(50, 50, 2560, 1200);
    System.out.println("Monitor9()");
  }
  Monitor10(int bright, int contrast) {
    this(bright, contrast, 0, 0);
    System.out.println("Monitor9(int, int)");
  }
  Monitor10(int bright, int contrast, int widthRes, int heightRes) {
    this.bright = 50;
    this.contrast = 70;
    this.widthRes = 2560;
    this.heightRes = 1200;
    System.out.println("Monitor9(int, int, int, int)");
  }
  
  public void on() {
    System.out.println("화면을 출력한다.");
  }
}

public class Test12 {
  public static void main(String[] args) {
    new Monitor10();
    System.out.println("---------------------");
    new Monitor10(50, 50);
    System.out.println("---------------------");
    new Monitor10(50, 50, 1920, 1080);
    System.out.println("---------------------");
  }  
}
