package ch03;

public class Test06 {
  public static void main(String[] args) {
    //키보드로 입력한 데이터를 읽을 때 사용할 도구 준비
    java.io.InputStream in = System.in;
    
//   InputStream은 바이트 단위로 읽는 기능이 있음
//    바이트 단위로 읽어서 int나 문자열로 바꾸려면 또 코딩해야 하는 불편함이 있음
//    이런 불편함을 줄이기 위해 자바에서는 바이트를 개발자가 원하는 값으로 바꿔주는 기능을 제공함
//     ->그 도구가 java.util.Scanner 임
    java.util.Scanner keybord = new java.util.Scanner(in);
    
    //사용자에게 입력하라고 간단히 출력
    System.out.println("이름을 입력하세요: ");
    
    //nextLine은 사용자가 입력할때 까지 기다리다가(LF값까지) 입력하면 그 값을 문자열로 만들어 리턴함
    java.lang.String str = keybord.nextLine();
    
    //사용자가 입력한 문자열을 출력한다.
    System.out.printf("당신의 이름은 %s 입니다", str);
  }
}
