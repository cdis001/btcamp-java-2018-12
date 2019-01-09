package bitcamp.lms;
import java.util.*;
import java.sql.Date;

public class App01 {

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
      a++;
      if (a >= 200) {
        System.out.println("용량이 부족합니다");
        break;
      }
      if (!str.equalsIgnoreCase("y") && !str.equalsIgnoreCase("")) 
        break;

    }
    kb.close();
    int b = 0;
    while (true) {
      System.out.println();
      System.out.printf("%d. ", no[b]);
      System.out.printf("%s: ", title[b]);
      System.out.printf("%s ~ %s, ", start[b], end[b]);
      System.out.printf("%d\n", totalHours[b]);
      b++;
      if (a == b)
        break;
    }
  }//main end




}//<class end
