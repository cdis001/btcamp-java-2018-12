package ch18.h;

public class Test01 {
  public static void main(String[] args) {
    Pen pen = new MyPen(); //인터페이스를 직접 구현한 클래스
    Pen pen2 = new BallPen153(); //인터페이스를 간접 구현
  }
}
