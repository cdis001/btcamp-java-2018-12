package bitcamp.lms;
import java.util.*;
import java.sql.Date;

public class App {

  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);

    int[] no = new int[200];
    String[] title = new String[200];
    String[] contents = new String[200];
    Date[] start = new Date[200];
    Date[] end = new Date[200];
    int[] totalHours = new int[200];
    int[] dayHours = new int[200];
    int a = 0;


    while (true) {

      System.out.println("번호? ");
      no[a] = Integer.parseInt(kb.nextLine());

      System.out.println("수업명? ");
      title[a] = kb.nextLine();

      System.out.println("설명? ");
      contents[a] = kb.nextLine();

      System.out.println("시작일? ");
      start[a] = Date.valueOf(kb.nextLine());

      System.out.println("종료일? ");
      end[a] = Date.valueOf(kb.nextLine());

      System.out.println("총 수업시간? ");
      totalHours[a] = Integer.parseInt(kb.nextLine());

      System.out.println("일 수업시간? ");
      dayHours[a] = Integer.parseInt(kb.nextLine());



      System.out.println("계속하시겠습니까? (Y/n)");
      String str = kb.nextLine(); 

      if (!str.equalsIgnoreCase("y") && !str.equalsIgnoreCase("")) {
        break;


      }
      ++a;
    }
    if (a < 200) {
    while (a <= 200) {
        System.out.println();
        System.out.printf("%d. ", no[a]);
        System.out.printf("%s: ", title[a]);
        System.out.printf("%s ~ %s, ", start[a], end[a]);
        System.out.printf("%d\n", totalHours[a]);
        
          break; //break에 라벨명을 지정하면 그 라벨이 붙은 문장을 나감
    }
    }


    kb.close();
  }
}
