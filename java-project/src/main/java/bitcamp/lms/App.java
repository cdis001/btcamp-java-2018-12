package bitcamp.lms;
import java.util.*;
import java.sql.Date;
import bitcamp.lms.Lesson;

public class App {

  public static void main(String[] args) {   
    
    Scanner kb = new Scanner(System.in);
    Lesson[] lessons = new Lesson[200];
    int a = 0;
    
    while (a < 200) {

      Lesson lesson = new Lesson(); //인스턴스 생성
      
      System.out.print("번호? ");
      lesson.no = Integer.parseInt(kb.nextLine()); //인스턴스 내부의 값 생성

      System.out.print("수업명? ");
      lesson.title = kb.nextLine();

      System.out.print("설명? ");
      lesson.contents = kb.nextLine();

      System.out.print("시작일? ");
      lesson.start = Date.valueOf(kb.nextLine());

      System.out.print("종료일? ");
      lesson.end = Date.valueOf(kb.nextLine());

      System.out.print("총 수업시간? ");
      lesson.totalHours = Integer.parseInt(kb.nextLine());

      System.out.print("일 수업시간? ");
      lesson.dayHours = Integer.parseInt(kb.nextLine());
      
      lessons[a] = lesson;
      a++;

      
      System.out.println();
      System.out.println("계속하시겠습니까? (Y/n)");
      String str = kb.nextLine(); 
      if (a >= 200) {
        System.out.println("용량이 부족합니다");
        break;
      }
      if (!str.equalsIgnoreCase("y") && !str.equalsIgnoreCase("")) 
        break;

    }
    kb.close();
    
    System.out.println();
    
    for (int b = 0; b < a ; b++) {
      System.out.println();
      System.out.printf("%d. ", lessons[b].no);
      System.out.printf("%s: ", lessons[b].title);
      System.out.printf("%s ~ %s, ", lessons[b].start, lessons[b].end);
      System.out.printf("%d\n", lessons[b].totalHours);
       
    }
  }//main end
}//<class end
