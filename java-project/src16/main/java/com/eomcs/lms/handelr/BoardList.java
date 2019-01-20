package com.eomcs.lms.handelr;

import java.util.Arrays;
import com.eomcs.lms.domain.Board;

public class BoardList {
  static int oldLength =10;
  Board[] boards; 
  int boardIdx = 0;

  public BoardList() {
    boards = new Board[oldLength];
  }

  public BoardList(int newLength) {

    if(oldLength < newLength) {
      boards = new Board[newLength];
    } else {
      boards = new Board[oldLength];
    }

  }

  public Board[] toArray() {
    return Arrays.copyOf(boards, boardIdx);
  }

  public void add(Board board) {
    if(boardIdx >= boards.length) {
      int oldL = boards.length;
      int newL = oldL + (oldL >> 1);
      boards = Arrays.copyOf(boards, newL);
      System.out.println("배열이 증가하였습니다");

    }
    boards[boardIdx++] = board;
  }
}
