package ch13.B;

public class Calculator2 extends Calculator {
  private int result; 
  
  public int getResult() {
    return result;
  }
  
  public void plus(int value) {
    this.result += value;
  }
  public void minus(int value){
    this.result -= value;
  }
  
  public void multiple(int value) {
    this.result *= value;
  }
  
  public void divide(int value) {
    this.result /= value;
  }

}
