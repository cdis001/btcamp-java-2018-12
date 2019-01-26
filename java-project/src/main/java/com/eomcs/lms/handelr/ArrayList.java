package com.eomcs.lms.handelr;

import java.util.Arrays;

public class ArrayList<E> {
  
  static final int DEFAULT_CAPACITY = 10;
  Object[] list;
  int size = 0;

  public ArrayList() {
    list = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      list = new Object[initialCapacity];
    else
      list = new Object[DEFAULT_CAPACITY];
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] sampleArr) {
    return (E[]) Arrays.copyOf(list, size, sampleArr.getClass());
    /*
    E[] arr = Arrays.copyOf(sampleArr, size);
    for (int i = 0; i < size; i++) {
      arr[i] = (E) list[i];
    }
    return arr;
    */
  }

  public void add(E obj) {
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }

    list[size++] = obj;
  }
  
  public E get(int index) {
    // index : 값을 꺼낼 배열의 항목 위치
    if (index < 0 || index > size) {
      System.out.println("번호를 확인해주세요");
      return null;
    }
    return (E) list[index];
  }
  
  public E set(int index, E value) {
    // index : 값을 변경할 배열의 항목 위치
    // value : 해당 위치에 있는 값을 대체할 값 
    // 리턴 값 : 대체되기 전의 기존 값
    if (index < 0 || index > size) {
      System.out.println("번호를 확인해주세요");
      return null;
    }
    E old = (E) list[index];
    list[index] = value;
    return old;
  }
  
  public E remove(int index) {
    // index : 삭제할 배열의 항목 위치
    // 리턴값: 삭제된 이전 값
    // 힌트: System.arraycopy() 참고! 
    if (index < 0 || index > size) {
      System.out.println("번호를 확인해주세요");
      return null;
    }
    E old = (E) list[index];
    for (int i = size - 1; i < index; i--) {
      list[i--] = list[i];
    }
   
    return old;
  }
}