package ch24.b;

public class Test03 {
  public static void main(String[] args) {
    
    Thread currThread = Thread.currentThread();
    ThreadGroup group = currThread.getThreadGroup();
    
    
    Thread[] threadList = new Thread[10];
    int size = 0;
    group.enumerate(threadList, false);
    
    System.out.println("main 스레드 그룹에 소속된 스레드들");
    
    for (int i = 0; i < size; i++) {
      System.out.println(threadList[i].getName());
    }
    
  }
}
