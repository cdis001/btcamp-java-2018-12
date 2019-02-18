package ch24.a;

public class Test02 {
  static class MyThread extends Thread {
    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        System.out.println("T===> " + i);
      }
    }
  }
  
  public static void main(String[] args) {
    MyThread t = new MyThread();
    t.start();
    
    for (int i = 0; i < 100; i++) {
      System.out.println("M===> " + i);
    }
  }
}
