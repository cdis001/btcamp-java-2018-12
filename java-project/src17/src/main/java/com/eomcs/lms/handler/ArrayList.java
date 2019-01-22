package com.eomcs.lms.handler;

import java.util.Arrays;

public class ArrayList {
  static final int DEFAULT_LENGTH = 10;
  Object[] list;
  int index = 0;
  
  public ArrayList(int DEFAULT_LENGTH) {
   this.list = new Object[DEFAULT_LENGTH];
  }
  public ArrayList(int DEFAULT_LENGTH, int newLength) {
    if (DEFAULT_LENGTH > newLength) {
      this.list = new Object[DEFAULT_LENGTH];
    } else {
      this.list = new Object[newLength];
    }
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(list, index);
  }
  
  public void add(Object obj) {
    if (index >= list.length) {
      int oldL = list.length;
      int newL = oldL + (oldL >> 1);
      
      list = Arrays.copyOf(list, newL);
    }
    
    list[index++] = obj;
  }
}
