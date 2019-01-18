package ch13.i;

public class Convertible extends Car {

  int cc;
  boolean open;

  public void openRoof() {
    open = true;
  }
  
  public void closeRoof() {
    open = false;
  }
}
