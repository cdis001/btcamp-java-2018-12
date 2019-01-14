package ch10;

class Monitor5 {
  int bright; //밝기(0%~100%)
  int contrast = 50; //명암(0%~100%)
  int widthRes; //해상도 너비
  int heihgtRes = 1080; //해상도 높이
  
  {
    this.bright = 50;
    this.contrast = 60;
    this.widthRes = 1920;
    this.heihgtRes = 1080;
  }
  
  Monitor5() {
    this.contrast = 70;
    this.widthRes = 2560;
    this.heihgtRes = 1200;
 
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

public class Test07 {
  public static void main(String[] args) {
    //모니터 인스턴스 생성
    Monitor5 m1 = new Monitor5(); 
    //선언한 순서대로 하는것이 아닌, 내부 순서(변수-블록-생성자순)대로 초기화됨 
    
    m1.display();
    
    m1.bright = 40;
    m1.contrast = 50;
    m1.widthRes = 1920;
    m1.heihgtRes = 1080;
    
    m1.display();
    
  }  
}
