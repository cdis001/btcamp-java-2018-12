package ch10;

class Monitor1 {
  int bright; //밝기(0%~100%)
  int contrast; //명암(0%~100%)
  int heihgtRes; //해상도 높이
  int widthRes; //해상도 너비
  void display() {
    System.out.println("----------------------------");
    System.out.printf("밝기(%d)\n", this.bright);
    System.out.printf("명암(%d)\n", this.contrast);
    System.out.printf("해상도 높이(%d)\n", this.heihgtRes);
    System.out.printf("해상도 너비(%d)\n", this.widthRes);
    System.out.println("----------------------------");
  }
}

public class Test03 {
  public static void main(String[] args) {
    //모니터 인스턴스 생성
    Monitor1 m1 = new Monitor1();
    
    m1.display();
    
    m1.bright = 50;
    m1.contrast = 50;
    m1.widthRes = 1920;
    m1.heihgtRes = 1080;
    
    m1.display();
    
  }  
}
