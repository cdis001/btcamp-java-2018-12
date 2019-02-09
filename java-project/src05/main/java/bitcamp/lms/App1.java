package bitcamp.lms;

public class App1 {

    public static void main(String[] args) {
      java.io.InputStream in = System.in;
      java.util.Scanner keyboard = new java.util.Scanner(in);
      
      System.out.println("번호? ");
      
      int number = keyboard.nextInt();
      keyboard.nextLine();
      
      System.out.println("수업명? ");
      String className = keyboard.nextLine();
      
      System.out.println("수업내용? ");
      String classC = keyboard.nextLine();
      
      System.out.println("시작일? ");
      String startDay = keyboard.nextLine();
      
      System.out.println("종료일? ");
      String endDay = keyboard.nextLine();
      
      System.out.println("총 수업시간? ");
      int classTime = keyboard.nextInt();
      keyboard.nextLine();
      
      System.out.println("일 수업시간? ");
      int classDay = keyboard.nextInt();
      keyboard.nextLine();
      
      System.out.printf("번호: %d\n", number);
      System.out.printf("수업명: %s\n", className);
      System.out.printf("수업내용: %s\n", classC);
      System.out.printf("시작일: %s\n", startDay);
      System.out.printf("종료일: %s\n", endDay);
      System.out.printf("총 수업시간: %d\n", classTime);
      System.out.printf("일 수업시간: %d\n", classDay);
      
      
    
    
    }
}
