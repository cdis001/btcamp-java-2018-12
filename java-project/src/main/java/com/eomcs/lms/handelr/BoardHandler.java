package com.eomcs.lms.handelr;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  static final int LENGTH = 10; 

  public Scanner keyboard;
  ArrayList boardList = new ArrayList();
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard; 
  }
  
  public void boardList() {
    Object[] a = boardList.toArray();
    for (Object board : a) {   //a 값의 범위때문인건 알겠는데 왜일까...
      Board boards = (Board) board;
      System.out.printf("%3d, %-20s, %s, %d\n", 
          boards.getNo(), boards.getContents(), 
          boards.getCreatedDate(), boards.getViewCount());
    }    
  }
  public void boardAdd() {
    Board boards = new Board();

    System.out.print("번호? ");
    boards.setNo(Integer.parseInt(this.keyboard.nextLine()));

    System.out.print("내용? ");
    boards.setContents(this.keyboard.nextLine());

    boards.setCreatedDate(new Date(System.currentTimeMillis())); 

    boards.setViewCount(0);
    
    boardList.add(boards);

    System.out.println("저장하였습니다.");

  }

}
