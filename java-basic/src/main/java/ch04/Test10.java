package ch04;
//논리연산자 &&, ||, ^

public class Test10 {
  public static void main(String[] args) {
    
    //and연산
  System.out.println(true && false);
  System.out.println(true && true);
  
    //or연산
  System.out.println(true || false);
  System.out.println(false || false);
  
    //논리연산(^): 피연산자가 서로 다를때 true
  System.out.println(true ^ true);
  System.out.println(false ^ false);
  System.out.println(true ^ false);
  
  }
}
