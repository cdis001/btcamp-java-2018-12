// Object 클래스 - clone() 인스턴스를 자동 복제할 때 호출하는 메서드
package ch15;


public class Test16 {
  
  static class Score implements Cloneable { //clone()를 오버라이딩 할 수 있도록 허락해주는 인터페이스
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
    
    public Score() {
      
    }
    @Override
    public Score clone() throws CloneNotSupportedException {
      return (Score) super.clone();
    }
    public Score(String name, int kor, int eng, int math) {
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      this.sum = kor + eng + math;
      this.aver = sum / 3f;
    }

    @Override
    public String toString() {
      return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
          + sum + ", aver=" + aver + "]";
    }
    
  }
  public static void main(String[] args) throws Exception {
   Score s1 = new Score("홍길동", 100, 100, 100);
   System.out.println(s1);
   
//   Score s2 = s1.clone() ->Object에서 상속받은 clone은 protected 접근 제한이 있음
   
   Score s2 = new Score(s1.name, s1.kor, s1.eng, s1.math);
   s2.name = "임꺽정";
   System.out.println(s2);
       
   
   Score s3 = s1.clone();
   s3.name = "유관순";
   System.out.println(s3);
   
  }
}







