package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonTest {
  ObjectOutputStream out;
  ObjectInputStream in;
  
  public LessonTest(ObjectOutputStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }
  
  public void test() throws Exception {
      
      add(new Lesson(1, "java Pprogramming"));
      
      add(new Lesson(2, "C programming"));
      
      list();
      
      detail(1);
      
      update(new Lesson(1, "java programming"));
      
      detail(1);
      
      delete(2);
      
      out.writeUTF("okok");
      out.flush();
      System.out.println(in.readUTF());

      
  }

  private void delete(int no) throws Exception {
    out.writeUTF("/lesson/delete");
    out.flush();
    if (!in.readUTF().equals("OK"))
      return;
    out.writeInt(no);
    out.flush();
    
    String status = in.readUTF();
    if (status.equals("OK")) {
      System.out.println("데이터 삭제 성공");
    } else {
      System.out.println("데이터 삭제 실패");
    }
  }

  private void update(Lesson lesson) throws Exception {
    out.writeUTF("/lesson/update");
    out.flush();
    if (!in.readUTF().equals("OK"))
      return;
    out.writeObject(lesson);
    out.flush();
    
    String status = in.readUTF();
    
    if (status.equals("OK")) {
      System.out.println("데이터 변경 성공");
    } else {
      System.out.println("데이터 변경 실패");
    }
  }

  private void detail(int no) throws Exception {
    out.writeUTF("/lesson/detail");
    out.flush();
    if (!in.readUTF().equals("OK"))
      return;
    out.writeInt(no);
    out.flush();
    
    String status = in.readUTF();
    if (status.equals("OK")) {
      System.out.println("데이터 불러오기 성공");
    } else {
      System.out.println("데이터 불러오기 실패");
    }
    Lesson lesson = (Lesson) in.readObject();
    System.out.println(lesson);
  }

  private void add(Lesson lesson) throws Exception {
    out.writeUTF("/lesson/add");
    out.flush();
    if (!in.readUTF().equals("OK"))
      return;
    out.writeObject(lesson);
    out.flush();
   
    String status = in.readUTF();
    
    if (status.equals("OK")) {
      System.out.println("데이터 추가 성공");
    } else {
      System.out.println("데이터 추가 실패");
    }
    System.out.println(in.readUTF());
  }
  
  private void list() throws Exception {
    out.writeUTF("/lesson/list");
    out.flush();
    if (!in.readUTF().equals("OK"))
      return;
    
    String status = in.readUTF();
    if (status.equals("OK")) {
      System.out.println("데이터 목록 가져오기 성공");
    } else {
      System.out.println("데이터 목록 가져오기 실패");
    }
    
    @SuppressWarnings("unchecked")
    List<Lesson> lessons = (List<Lesson>) in.readObject();
    for (Lesson m : lessons) {
      System.out.println(m);
    }
  }
  
}
