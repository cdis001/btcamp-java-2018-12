package ch05;

public class Test11 {
  public static void main(String[] args) {
    int i = 1;
    do 
      System.out.printf(i + " ");
    while (++i <= 10);
    System.out.println();
    
    //1~10까지 출력하기
    i = 0;
    do {
      System.out.print(++i); //print()안에 명령문 넣어도 됨!
      System.out.print(",");
    } while (i < 10);
      System.out.println();
    
    
  } //end main
} //end class
