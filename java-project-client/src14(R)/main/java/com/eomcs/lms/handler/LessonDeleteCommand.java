package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.proxy.LessonDaoProxy;

public class LessonDeleteCommand implements Command {

  Scanner keyboard;
  LessonDaoProxy lessonDaoProxy;

  public LessonDeleteCommand(Scanner keyboard, LessonDaoProxy lessonDaoProxy) {
    this.keyboard = keyboard;
    this.lessonDaoProxy = lessonDaoProxy;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    try {
      lessonDaoProxy.delete(no);
      System.out.println("수업을 삭제했습니다.");
    }catch(Exception e) {
      System.out.printf("게시글 목록 삭제 오류: %s\n",e.getMessage());
    }
  }
}


