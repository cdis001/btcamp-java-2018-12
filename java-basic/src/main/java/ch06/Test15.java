//학생의 이름과 국영수 점수를 입력 받아 총점과 평균 출력 *실습
package ch06;

public class Test15 {
  public static void main(String[] args) {
    
    int sum = 0;
    for (int i = 1; i < args.length; i++)
      sum += Integer.parseInt(args[i]);
    
    System.out.printf("이름: %s\n", args[0]);
    System.out.printf("총점: %d\n", sum);
    System.out.printf("평균: %.1f\n", sum / 3f);
    
  }
}

