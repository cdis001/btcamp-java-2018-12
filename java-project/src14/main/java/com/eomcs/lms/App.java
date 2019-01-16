package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handelr.BoardHandler;
import com.eomcs.lms.handelr.LessonHandler;
import com.eomcs.lms.handelr.MemberHandler;

public class App {
  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    BoardHandler bH = new BoardHandler(keyboard);
    //생성자가 없으면, keyboard값을 받아오지 않더라도 App에서는 컴파일시 에러가 뜨지 않음! ->그러나, keyboard값이 없으면 실행시 에러가 뜸
    //생성자가 있는 경우 keyboard값을 받아와야 컴파일시 에러가 뜨므로 keyboard값을 '강제로' 받아와야 함
    
    BoardHandler bH2 = new BoardHandler(keyboard);
    
    LessonHandler lH = new LessonHandler(keyboard);
    
    MemberHandler mH = new MemberHandler(keyboard);
    //당장 하나만 쓰는 정보여도 나중에 재사용을 위하여 인스턴스 필드로 선언하는편이 좋음 
    
    
    while (true) {
      String command = prompt();

      if (command.equals("/lesson/add")) {
        lH.lessonAdd();
      } else if (command.equals("/lesson/list")) {
        lH.lessonList();
      } else if (command.equals("/member/add")) {
        mH.memberAdd();
      } else if (command.equals("/member/list")) {
        mH.memberList();
      } else if (command.equals("/board/add")) {
        bH.boardAdd();
      } else if (command.equals("/board/list")) {
        bH.boardList();
      } else if (command.equals("/board2/add")) {
        bH2.boardAdd();
      } else if (command.equals("/board2/list")) {
        bH2.boardList();
      }else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println(); // 결과 출력 후 빈 줄 출력
    }

    keyboard.close();
  }
  public static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }



}
