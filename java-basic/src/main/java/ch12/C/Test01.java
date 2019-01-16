package ch12.C;

public class Test01 {
  private int result; //캡슐에 쌓임; 다른 클래스에서 값을 볼 수 있도록 값을 리턴해주는 메서드가 필요함
  
  public int getResult() {
    return result;
  }
  
  public void plus(int value) {
    this.result += value;
  }
  public void minus(int value){
    this.result -= value;
  }

}
