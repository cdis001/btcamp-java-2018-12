package ch02;

public class Test14 {
  public static void main(String[] args) {
    java.util.Date today = new java.util.Date();
    
    System.out.printf("%1$tY %1$ty\n", today); //년도
    System.out.printf("%1$tB %1$tb %1$tm\n", today); //월
    System.out.printf("%1$td %1$te\n", today); //일
    System.out.printf("%1$tA %1$ta\n", today); //요일
    System.out.printf("%1$tH %1$tI\n", today); //시
    System.out.printf("%1$tM\n", today); //분
    System.out.printf("%1$tS\n", today); //초
    
    
    //년-월-일 시:분:초 출력
    
    System.out.printf("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", today );
  }

}
