package com.eomcs.lms.handelr;

import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import java.sql.Date;


public class LessonHandler {
  
  public Scanner keyboard;
  ArrayList lessonList = new ArrayList();
  public LessonHandler (Scanner keyboard){
    this.keyboard = keyboard;
  }
  public void lessonList() {
    Object[] lessons = lessonList.toArray();
          for (Object lesson : lessons) {
            Lesson lesson1 = (Lesson) lesson;
            System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lesson1.getNo(), lesson1.getTitle(), 
          lesson1.getStartDate(), lesson1.getEndDate(),
          lesson1.getTotalHours());}
  }
    public void lessonAdd() {
      Lesson lesson = new Lesson();
      System.out.print("번호? ");
      lesson.setNo(Integer.parseInt(keyboard.nextLine()));

      System.out.print("수업명? ");
      lesson.setTitle(keyboard.nextLine());

      System.out.print("설명? ");
      lesson.setContents(keyboard.nextLine());

      System.out.print("시작일? ");
      lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

      System.out.print("종료일? ");
      lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

      System.out.print("총수업시간? ");
      lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));

      System.out.print("일수업시간? ");
      lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));


      System.out.println("저장하였습니다.");
      
      lessonList.add(lesson);
    }
}
