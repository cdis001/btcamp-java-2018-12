package ch13.A;

public class Calculator2 {
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
