package ch18.e;

public class Test01 {
  public static void main(String[] args) {
    
    Ballpen153 t1 = new Ballpen153();
    MultiPen t2 = new MultiPen();
    Canvas c1 = new Canvas(t1);
    
    c1.setPen(t1);
    
    t1.press(true);
    t1.render("모나미 볼펜으로 그린 것");
    
    c1.setPen(t2);
    
    t2.
  }
}
