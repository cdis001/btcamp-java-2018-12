package ch02;

public class Test02 {
  public static void main(String[] args) {
    //20억을 4바이트 리터럴로 출력하라
    System.out.println(2000000000);
    
    //20억을 8바이트 리터럴로 출력하라
    System.out.println(2000000000L);
    
    //30억을 8바이트 리터럴로 출력하라
    System.out.println(3000000000L);
    
    //30억을 4바이트 리터럴로 출력하라
    System.out.println("3000000000은 4바이트에서는 표현범위를 초과하여 오류");
    
  }

}
