package ch10;

class Monitor2 {
  int bright = 50; //밝기(0%~100%)
  int contrast = 50; //명암(0%~100%)
  int widthRes = 1080; //해상도 너비
  int heihgtRes = 1920; //해상도 높이
  void display() {
    System.out.println("----------------------------");
    System.out.printf("밝기(%d)\n", this.bright);
    System.out.printf("명암(%d)\n", this.contrast);
    System.out.printf("해상도 너비(%d)\n", this.widthRes);
    System.out.printf("해상도 높이(%d)\n", this.heihgtRes);
    System.out.println("----------------------------");
  }
}

public class Test04 {
  public static void main(String[] args) {
    //모니터 인스턴스 생성
    Monitor2 m1 = new Monitor2();
    
    m1.display();
    
    m1.bright = 40;
    m1.contrast = 50;
    m1.widthRes = 1920;
    m1.heihgtRes = 1080;
    
    m1.display();
    
  }  
}
