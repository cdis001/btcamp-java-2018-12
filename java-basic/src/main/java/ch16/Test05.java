package ch16;

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Test05 {
  public static void main(String[] args) {
    String[] strs = create2(new String[] {});
    System.out.println(strs.length);
  }
  static <T> T[] create1() {
//    T[] arr = new T[10];
    return null;
  }
  static <T> T[] create2(T[] arr) {
    return Arrays.copyOf(arr, 10);
  }
}
