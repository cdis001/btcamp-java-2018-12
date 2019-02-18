package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.proxy.BoardDaoProxy;

public class BoardDeleteCommand implements Command {
  
  Scanner keyboard;
  BoardDaoProxy boardDao;
  
  public BoardDeleteCommand(Scanner keyboard, BoardDaoProxy boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      boardDao.delete(no);
      System.out.println("게시물 삭제 완료!");
    }catch(Exception e) {
      System.out.printf("게시글 목록 삭제 오류: %s\n",e.getMessage());
    }
  }
  
}
