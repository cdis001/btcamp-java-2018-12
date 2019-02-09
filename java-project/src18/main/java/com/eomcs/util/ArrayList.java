package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {
  static final int DEFALUT_LENGTH = 10;
  Object[] list; 
  int index = 0;
  
  public ArrayList(int DEFALUT_LENGTH) {
    this(0,0);
  }
  
  public ArrayList(int DEFALUT_LENGTH, int currentLength) {
    if(DEFALUT_LENGTH > currentLength) {
      this.list = new Object[DEFALUT_LENGTH];
    } else {
      this.list = new Object[currentLength];
    }
  }
  
  public E[] toArray(E[] arr1) {
    
    E[] arr = Arrays.copyOf(arr1, index);
    for (int i = 0; i < index; i++) {
      arr[i] = (E) list[i];
    }
    return arr;
  }
  
  public void add(E e) {
    if (index > list.length) {
      int oldV = list.length;
      int newV = oldV + (oldV >> 1);
      list = Arrays.copyOf(list, newV);
    }
    list[index++] = e;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int value) {
    if (value < 0 || value > list.length - 1 )
    return null;
    
    return (E) list[value];
  }
  
  public E set(int value, E e) {
    if (value < 0 || value > list.length - 1 )
    return null;
    
    @SuppressWarnings("unchecked")
    E obj = (E) list[value];
    
    list[value] = e;
    
    return obj;
    
  }
  
  public E remove(int value) {
    if (value < 0 || value > list.length - 1 )
    return null;
    
    @SuppressWarnings("unchecked")
    E obj = (E) list[value];
    
    return obj;
  }
}
