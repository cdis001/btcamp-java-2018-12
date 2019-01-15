package ch11;

public class Test02 {
  public static void main(String[] args) {
    String s1; //stack 영역에 s1 레퍼런스 생성
    s1 = "Hello!"; // = new String("Hello!") => 스트링 상수풀에 생성
    
    String s2 = "Hello!"; //같은 문자열을 가진 인스턴스가 있기 때문에 기존 인스턴스의 주소를 리턴함
    
    
    if (s1 != s2) {
      System.out.println("다르다!");
    } else {
      System.out.println("같다!");
    }
    
    String s3 = new String ("Hello!");
    
    if (s1 != s3) {
      System.out.println("다르다!");
    } else {
      System.out.println("같다!");
    }
    
    System.out.println(s1 instanceof String);
    System.out.println(s2 instanceof String);
    System.out.println(s3 instanceof String);
  }  
}
