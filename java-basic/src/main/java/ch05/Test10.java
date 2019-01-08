package ch05;

public class Test10 {
  public static void main(String[] args) {
    
    //중첩반복문 기본
    int a = 1;
    while (a <= 10) {
      int b = 1;
      while (b <= a ) {
        System.out.print(b++ + " ");
      }
      System.out.println();
      a++;
    }
    
    //중첩반복문에서 반복문 하나 나가기
    a = 1;
    while (a <= 10) {
      int b = 1;
      while (b <= a ) {
        System.out.print(b++ + " ");
        if (b > 5)
          break;
      }
      System.out.println();
      a++;
    }
    
    //중첩반복문에서 가장 바깥의 반복문을 나가기
    a = 1;
    A: //반복문에 라벨을 붙임, while()문에 대한 별명
    while (a <= 10) {
      int b = 1;
      while (b <= a ) {
        System.out.print(b++ + " ");
        if (b > 5)
          break A; //break에 라벨명을 지정하면 그 라벨이 붙은 문장을 나감
      }
      System.out.println();
      a++;
    }

    System.out.println();
    System.out.println("프로그램 종료!");
  } //end main
} //end class
