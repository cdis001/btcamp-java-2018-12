package ch10;

class Monitor6 {
  int bright; //밝기(0%~100%)
  int contrast = 50; //명암(0%~100%)
  int widthRes; //해상도 너비
  int heihgtRes = 1080; //해상도 높이
  
  Monitor6() {
    this.bright = 50;
    this.contrast = 70;
    this.widthRes = 2560;
    this.heihgtRes = 1200;
 
  }
  
  public void on() {
    System.out.println("화면을 출력한다.");
  }
}

public class Test08 {
  public static void main(String[] args) {
//    new Monitor6; ->컴파일 오류; 생성자에 파라미터 값을 주지 않고 인스턴스를 생성 할 수는 없음
    
  }  
}
