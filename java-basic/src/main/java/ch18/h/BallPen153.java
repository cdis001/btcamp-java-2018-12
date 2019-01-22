package ch18.h;

public class BallPen153 extends AbstractPen {

  @Override
  public void write(String text) {
    if(!this.use) 
      return;
    System.out.println("monami153: " + text);
  }

}
