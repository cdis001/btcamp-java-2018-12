package com.eomcs.lms.handler;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDaoImpl;
import com.eomcs.lms.domain.Board;

public class BoardListCommand implements Command {

  Scanner keyboard;
  BoardDaoImpl boardDao;
  
  public BoardListCommand(Scanner keyboard, BoardDaoImpl boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }

  @Override
  public void execute() {
    try {
      List<Board> boards = boardDao.findAll();
      for (Board board : boards) {
        System.out.printf("%3d, %-20s, %s, %d\n", 
            board.getNo(), board.getContents(), 
            board.getCreatedDate(), board.getViewCount());
      }
    } catch (Exception e) {
      System.out.printf("게시글 목록 출력 오류: %s\n",e.getMessage());
    }

  }

}
