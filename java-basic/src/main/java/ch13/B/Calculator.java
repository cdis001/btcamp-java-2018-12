package ch13.B;

public class Calculator {
  protected int result; 
  
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
