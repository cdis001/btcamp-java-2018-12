package ch19.h;

public class Test02 {

  static interface Player {
    void play();
  }  
    public static void main(String[] args) {
      
      Player p2 =() -> System.out.println("Test01");
     
      p2.play();
      
    }

}
