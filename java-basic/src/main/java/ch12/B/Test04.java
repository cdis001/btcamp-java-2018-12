//getter, setter 활용하면 좋은 이유
package ch12.B;

public class Test04 {
  public static void main(String[] args) {

    Score2 s1 = new Score2();
   // s1.name = "홍길동";
    s1.setKor(100);
    s1.setEng(90);
    s1.setMath(80);
    s1.compute();
    System.out.printf("총점: %d, 평균: %.1f\n", s1.getSum(), s1.getAver());
    
    s1.setKor(70);
    System.out.printf("총점: %d, 평균: %.1f\n", s1.getSum(), s1.getAver());
    
    s1.setEng(-200);
    s1.compute();
    System.out.printf("총점: %d, 평균: %.1f\n", s1.getSum(), s1.getAver());
  }

}
