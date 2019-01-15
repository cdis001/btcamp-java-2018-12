//Test03에 덮어씀ㅠㅠㅠㅠㅠ
package ch11;

public class Test05 {
  public static void main(String[] args) {
    String s1 = new String ("Hello");
    String s2 = new String ("Hello");
    
    if (s1 != s2) { //s1과 s2의 인스턴스 끼리 비교
      System.out.println("인스턴스가 다르다!");
    } else {
      System.out.println("인스턴스가 같다!");
    }
    
    
    if (s1.equals(s2)) { //s1과 s2의 문자열의 비교
      System.out.println("문자열이 같다!");
    } else {
      System.out.println("문자열이 다르다!");
    }

    String s3 = "hello";
    String s4 = "HELLO";
    
    if (s3.equals(s4)) {
      System.out.println("s3.equals(s4)");
    }
    if (s3.equalsIgnoreCase(s4)) {
      System.out.println("s3.squalsIgnoreCase(s4)");
    }
    
  }  
}
