package ch11;

public class Test01 {
  public static void main(String[] args) {
    String s1; //stack 영역에 s1 레퍼런스 생성
    s1 = new String("Hello!"); //Heap 영역에 "Hello"를 저장한 후 주소를 리턴함
    
    String s2 = new String("Hello!");
    
    if (s1 != s2) {
      System.out.println("다르다!");
    } else {
      System.out.println("같다!");
    }
  }  
}
