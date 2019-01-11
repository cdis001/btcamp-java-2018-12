//JVM아규먼트를 응용하여 학생의 이름과 성적을 입력하여 이름, 총점, 평균을 계산 *실습
package ch06;

public class Test17 {
  public static void main(String[] args) {
    
    String name = System.getProperty("name");
    String ko = System.getProperty("kor");
    String en = System.getProperty("eng");
    String mt = System.getProperty("math");
    
    int kor = Integer.parseInt(ko);
    int eng = Integer.parseInt(en);
    int math = Integer.parseInt(mt);
    int sum = kor + eng + math;
    float aver = sum / 3f;
    
    System.out.printf("*이름: %s *총점: %d *평균: %f\n", name, sum, aver);
   
    
  }
}

