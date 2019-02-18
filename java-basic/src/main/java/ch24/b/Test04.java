package ch24.b;

public class Test04 {
  public static void main(String[] args) {

    Thread currThread = Thread.currentThread();
    ThreadGroup group = currThread.getThreadGroup();
    System.out.println("main 스레드 그룹에 소속된 하위 스레드 그룹들: ");

    System.out.println(group.getName() + "(TG)");


    ThreadGroup[] threadList = new ThreadGroup[10];
    int size = 0;
    group.enumerate(threadList, false);

    System.out.println("main 스레드 그룹에 소속된 하위 스레드 그룹들:");
    for (int i = 0; i < size; i++) {
      System.out.println(threadList[i].getName() + "(TG)");
    }

  }
}
