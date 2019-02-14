package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import com.eomcs.lms.agent.BoardAgent;

public class BoardDeleteCommand implements Command {
  
  Scanner keyboard;
  
  public BoardDeleteCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      BoardAgent.delete(no, in, out);
      System.out.println("게시물 삭제 완료!");
    }catch(Exception e) {
      System.out.printf("게시글 목록 삭제 오류: %s\n",e.getMessage());
    }
  }
  
}
