package ch10;

class Monitor4 {
  int bright; //밝기(0%~100%)
  int contrast; //명암(0%~100%)
  int widthRes; //해상도 너비
  int heihgtRes; //해상도 높이
  
  Monitor4() {
    this.bright = 50;
    this.contrast = 50;
    this.widthRes = 1920;
    this.heihgtRes = 1080;
  }
  void display() {
    System.out.println("----------------------------");
    System.out.printf("밝기(%d)\n", this.bright);
    System.out.printf("명암(%d)\n", this.contrast);
    System.out.printf("해상도 너비(%d)\n", this.widthRes);
    System.out.printf("해상도 높이(%d)\n", this.heihgtRes);
    System.out.println("----------------------------");
  }
}

public class Test06 {
  public static void main(String[] args) {
    //모니터 인스턴스 생성
    Monitor4 m1 = new Monitor4();
    
    m1.display();
    
    m1.bright = 40;
    m1.contrast = 50;
    m1.widthRes = 1920;
    m1.heihgtRes = 1080;
    
    m1.display();
    
  }  
}
