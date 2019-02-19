package ch24.c;

public class Test04 {
  
  public static void main(String[] args) throws Exception {
    
    Thread t = new Thread() {
      
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          System.out.printf("스레드(T) ===> %s\n", i);
        }
      }
    };
    
    t.start();
    
    new Thread(new Runnable() {
        public void run() {
          for (int i = 0; i < 1000; i++) {
            System.out.printf("스레드(T2) ///> %s\n", i);
          }
        }
      }
     );
    
    t.join();
    
    for (int i = 0; i < 1000; i++) {
      System.out.printf("스레드(M) ~~~> %s\n", i);
    }
  }
}  
