package ch19.h;

public class Test06 {

  static interface Player {
    void play();
  }  
  
  static interface Player2 {
    static String info() {
      return "Player2 입니다.";
    }
    
    default void stop() {
      
    }
    void play();
  }
  
  static interface Player3 {
    void play();
    void stop();
  }
  
  static abstract class Player4 {
    public abstract void play();
  }
  
    public static void main(String[] args) {
      
      Player p1 = () -> System.out.println("Player...");
      p1.play();
      
      Player2 p2 = () -> System.out.println("Player2...");
      p2.play();
      System.out.println(Player2.info());
      
      //Player3은 추상 메서드가 1개 초과이기 때문에 컴파일 오류
//      Player3 p3 = () -> System.out.println("Player3...");
//      p3.play();
      
      //인터페이스가 아닌 추상 클래스이기 때문에 컴파일 오류
//      Palyer4 p4 = () -> System.out.println("Player4...");
      }
}

