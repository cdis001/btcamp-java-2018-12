package ch05;

public class Test04 {
  public static void main(String[] args) {
    byte b = 'A'; //switch 조건으로 OK!
    short s = 1;
    char c = 1;
    int i = 1;
    long l = 1L; //여기부턴 switch조건으로 안 됨
    float f = 1f;
    double d = 1.0;

    switch (b) {
      case 1:
        System.out.println("11");
        System.out.println("1111");
        break;
      case 2:
        System.out.println("22");
        System.out.println("2222");
        break;
      case 'A': //A의 리턴 값은 2바이트 정수값(UTF-16코드값)
        System.out.println("AAAA");

    }
  } //end main
} //end class
