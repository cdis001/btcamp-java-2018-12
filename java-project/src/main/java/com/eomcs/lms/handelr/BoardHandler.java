package com.eomcs.lms.handelr;
//생성자를 사용하는 이유?????


import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  static final int LENGTH = 10; 

  public Scanner keyboard;
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard; //생성자를 통하여 기본 초기값을 keyboard로 맞추기 위함??
    //굳이 생성자를 사용하여 초기값으로 맞추는 이유?-> 객체 생성시 필수입력값을 강제하기 위함???
    //keyboard라는 이름의 파라미터 생성?!???
  }
  Board[] boards = new Board[LENGTH]; 
  int boardIdx = 0;
  
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
