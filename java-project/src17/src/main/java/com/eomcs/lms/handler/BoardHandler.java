package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  Scanner keyboard;
  ArrayList list;
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList(20);
  }
  
  public void listBoard() {
    Object[] obj = list.toArray();
    for (Object objs : obj) {
      Board boards = (Board) objs;
      System.out.printf("%3d, %-20s, %s, %d\n", 
          boards.getNo(), boards.getContents(), 
          boards.getCreatedDate(), boards.getViewCount());
    }
  }

  public void addBoard() {
    Board board = new Board();
    
    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());
    
    board.setCreatedDate(new Date(System.currentTimeMillis())); 
    
    board.setViewCount(0);
    
    list.add(board);
    
    System.out.println("저장하였습니다.");
  }

}
