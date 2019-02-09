package ch19.h;

public class Test04 {

  static interface Player {
    void play(String name, int age);
  }  
    public static void main(String[] args) {
      
      Player p1 =(String name, int age) -> 
      System.out.printf("%s(%d)님 환영합니다", name, age);
     
      p1.play("홍길동", 20);
      
      Player p2 =(name, age) -> 
      System.out.printf("%s(%d)님 환영합니다", name, age);
     
      p2.play("임꺽정", 30);
      
//      Player p3 =name, age -> 
//      System.out.printf("%s(%d)님 환영합니다", name, age);
//     
//      p3.play("임꺽정", 30);
      
    }

}
