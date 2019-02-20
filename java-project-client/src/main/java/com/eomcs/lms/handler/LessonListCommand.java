package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDaoImpl;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {
  
  Scanner keyboard;
  LessonDaoImpl lessonDaoProxy;

  public LessonListCommand(Scanner keyboard, LessonDaoImpl lessonDaoProxy) {
    this.keyboard = keyboard;
    this.lessonDaoProxy = lessonDaoProxy;
  }
  
  public void execute() {
    try {
      List<Lesson> lessons = lessonDaoProxy.findAll();
      for (Lesson l : lessons) {
        System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
            l.getNo(), l.getTitle(), 
            l.getStartDate(), l.getEndDate(), l.getTotalHours());
      }
      }catch(Exception e) {
        System.out.printf("레슨 목록 출력 오류: &s\n",e.getMessage());
    }
    
    
    }
  }

