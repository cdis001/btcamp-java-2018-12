package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handelr.BoardHandler;
import com.eomcs.lms.handelr.LessonHandler;
import com.eomcs.lms.handelr.MemberHandler;
import com.eomcs.lms.handelr.BoardHandler2;

public class App {
  static Scanner keyboard = new Scanner(System.in);


  public static void main(String[] args) {
    BoardHandler.keyboard = keyboard;
    LessonHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;
    
    BoardHandler2 bH2 = new BoardHandler2();
    bH2.keyboard = keyboard;
    while (true) {
      String command = prompt();

      if (command.equals("/lesson/add")) {
        LessonHandler.lessonAdd();
      } else if (command.equals("/lesson/list")) {
        LessonHandler.lessonList();
      } else if (command.equals("/member/add")) {
        MemberHandler.memberAdd();
      } else if (command.equals("/member/list")) {
        MemberHandler.memberList();
      } else if (command.equals("/board/add")) {
        BoardHandler.boardAdd();
      } else if (command.equals("/board/list")) {
        BoardHandler.boardList();
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
