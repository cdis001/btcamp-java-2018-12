package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.agent.BoardAgent;

public class BoardDeleteCommand implements Command {
  
  Scanner keyboard;
  BoardAgent boardAgent;
  
  public BoardDeleteCommand(Scanner keyboard, BoardAgent boardAgent) {
    this.keyboard = keyboard;
    this.boardAgent = boardAgent;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      boardAgent.delete(no);
      System.out.println("게시물 삭제 완료!");
    }catch(Exception e) {
      System.out.printf("게시글 목록 삭제 오류: %s\n",e.getMessage());
    }
  }
  
}
