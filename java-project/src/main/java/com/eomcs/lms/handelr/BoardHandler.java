package com.eomcs.lms.handelr;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
 

  public Scanner keyboard;
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard; 
  }
  BoardList list;
  
  public void boardList() {
    for (Board board : boards) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          this.boards[j].getNo(), this.boards[j].getContents(), 
          this.boards[j].getCreatedDate(), this.boards[j].getViewCount());
    }    
  }
  public void boardAdd() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(Integer.parseInt(this.keyboard.nextLine()));

    System.out.print("내용? ");
    board.setContents(this.keyboard.nextLine());

    board.setCreatedDate(new Date(System.currentTimeMillis())); 

    board.setViewCount(0);



    System.out.println("저장하였습니다.");

  }

}
