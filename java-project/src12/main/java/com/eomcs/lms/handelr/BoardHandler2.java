package com.eomcs.lms.handelr;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler2 {
  public Scanner keyboard = new Scanner(System.in);
  static final int LENGTH = 10;
  
  Board[] boards2 = new Board[LENGTH]; 
  int boardIdx2 = 0;
  
  public void boardList() {
    for (int j = 0; j < this.boardIdx2; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          this.boards2[j].no, this.boards2[j].contents, 
          this.boards2[j].createdDate, this.boards2[j].viewCount);
    }    
  }
  public void boardAdd() {
    Board board2 = new Board();
    
    System.out.print("번호? ");
    board2.no = Integer.parseInt(this.keyboard.nextLine());
    
    System.out.print("내용? ");
    board2.contents = this.keyboard.nextLine();
    
    board2.createdDate = new Date(System.currentTimeMillis()); 
    
    board2.viewCount = 0;
    
    this.boards2[this.boardIdx2] = board2;
    this.boardIdx2++;
    
    System.out.println("저장하였습니다.");
    
  }

}
