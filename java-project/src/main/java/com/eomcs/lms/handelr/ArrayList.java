package com.eomcs.lms.handelr;

import java.util.Arrays;

public class ArrayList {

  static final int LENGTH = 10;
  Object[] A = new Object[LENGTH];
  int index = 0;
  
  public Object[] toArray() {
    Object[] arr = new Object[LENGTH];
    for (int a = 0; a < index; a++) {
      arr[a] = this.A[a];
    }
    return arr;
  }
  
  public void add(Object B) {
    if (index == A.length) {
      A = Arrays.copyOf(A, A.length + (A.length >> 1));
      System.out.println("배열이 증가하였습니다");
      
    }
    A[index++] = B;
  }

}
