package ch24.b;

public class Test07 {
  public static void main(String[] args) {
    
    Thread mainThread = Thread.currentThread();
    System.out.println(mainThread.getPriority());
  }
  
}
