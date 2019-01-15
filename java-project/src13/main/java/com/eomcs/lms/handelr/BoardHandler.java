package com.eomcs.lms.handelr;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  static final int LENGTH = 10; //공통으로 관리할 변수

  public Scanner keyboard = new Scanner(System.in);
  //App에서 불러올 예정이기 때문에,  굳이 static을 붙이지 않아도 됨;
  Board[] boards = new Board[LENGTH]; 
  int boardIdx = 0;
  //개별적으로 관리해야 할 변수들; board 배열, 배열 초기값
  
  public void boardList() {
    for (int j = 0; j < this.boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          this.boards[j].no, this.boards[j].contents, 
          this.boards[j].createdDate, this.boards[j].viewCount);
    }    
  }
  public void boardAdd() {
    Board board = new Board();

    System.out.print("번호? ");
    board.no = Integer.parseInt(this.keyboard.nextLine());

    System.out.print("내용? ");
    board.contents = this.keyboard.nextLine();

    board.createdDate = new Date(System.currentTimeMillis()); 

    board.viewCount = 0;

    this.boards[this.boardIdx] = board;
    this.boardIdx++;

    System.out.println("저장하였습니다.");

  }

}
