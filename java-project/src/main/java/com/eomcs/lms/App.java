package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handelr.BoardHandler;
import com.eomcs.lms.handelr.LessonHandler;
import com.eomcs.lms.handelr.MemberHandler;

public class App {
  static Scanner keyboard = new Scanner(System.in);


  public static void main(String[] args) {
    
    BoardHandler bH = new BoardHandler();
    bH.keyboard = keyboard;
    
    LessonHandler lH = new LessonHandler();
    lH.keyboard = keyboard;
    
    MemberHandler mH = new MemberHandler();
    mH.keyboard = keyboard;
    
    
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
