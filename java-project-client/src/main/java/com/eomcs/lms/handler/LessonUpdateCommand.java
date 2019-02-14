package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.agent.LessonAgent;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand implements Command {

  Scanner keyboard;

  public LessonUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      Lesson lesson = LessonAgent.get(no, in, out);
      Lesson temp = lesson.clone();
      
      System.out.printf("내용? ");
      String input = keyboard.nextLine();
      if (input.length() > 0) 
        temp.setTitle(input);
      
      System.out.printf("내용? ");
      input = keyboard.nextLine();
      if (input.length() > 0) 
        temp.setContents(input);
      
      System.out.printf("내용? ");
      input = keyboard.nextLine();
      if (input.length() > 0) 
        temp.setStartDate(Date.valueOf(input));
      
      System.out.printf("내용? ");
      input = keyboard.nextLine();
      if (input.length() > 0) 
        temp.setEndDate(Date.valueOf(input));
      
      System.out.printf("내용? ");
      input = keyboard.nextLine();
      if (input.length() > 0) 
        temp.setTotalHours(Integer.parseInt(input));
      
      System.out.printf("내용? ");
      input = keyboard.nextLine();
      if (input.length() > 0) 
        temp.setDayHours(Integer.parseInt(input));
      
      LessonAgent.update(temp, in, out);
      System.out.println("수업을 변경했습니다.");
    } catch(Exception e) {
      System.out.println("변경 중 오류 발생!");
    }
}
}
