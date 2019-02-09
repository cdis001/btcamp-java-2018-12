package ch19.h;

public class Test01 {

  static interface Player {
    void play();
  }  
    public static void main(String[] args) {
      
      Player p1 = new Player() {
        public void play() {
          System.out.println("Test01");
        }
      };
     
      p1.play();
      
      Player p2 =() -> {
          System.out.println("Test01");
      };
     
      p2.play();
      
    }

}
