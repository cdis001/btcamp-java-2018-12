package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.agent.LessonAgent;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {
  
  Scanner keyboard;

  public LessonListCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    try {
      List<Lesson> lessons = LessonAgent.list(in, out);
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

