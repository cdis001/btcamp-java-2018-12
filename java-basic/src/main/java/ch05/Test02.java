package ch05;
//if-else 조건문

public class Test02 {
  public static void main(String[] args) {
    int age = 22;

    //기본형식
    if (age >= 20)
      System.out.println("성인입니다");
    else
      System.out.println("미성년입니다");
    
    //여러문장 실행시 {}으로 묶어야 함
    if (age >= 20) {
      System.out.println("----------");
      System.out.println("성인입니다");
    }
    else {
      System.out.println("-------------");
      System.out.println("미성년입니다");
    }
    
    //대부분 if-else 의 모양은 K & R형식을 따름
    if (age >= 20) {
      System.out.println("----------");
      System.out.println("성인입니다");
    } else {
      System.out.println("-------------");
      System.out.println("미성년입니다");
    }
      
  }
}
